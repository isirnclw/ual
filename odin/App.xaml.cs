using Odin.Helpers;
using Odin.Models;
using Odin.Services;
using Odin.Views;
using System;
using System.Linq;
using System.Threading.Tasks;
using Windows.ApplicationModel.Activation;
using Windows.UI.Xaml;
using XCore.Helpers;
using OCCli = System.Collections.ObjectModel.ObservableCollection<Odin.Models.Cliente>;
using OCRec = System.Collections.ObjectModel.ObservableCollection<Odin.Models.Recurso>;
using OCReq = System.Collections.ObjectModel.ObservableCollection<Odin.Models.Requisito>;
using OCVer = System.Collections.ObjectModel.ObservableCollection<Odin.Models.Version>;

namespace Odin
{
    public sealed partial class App : Application
    {
        #region Colecciones

        public static OCCli Clientes => Singleton<OCCli>.Instance;

        public static OCRec Recursos => Singleton<OCRec>.Instance;

        public static OCReq Requisitos => Singleton<OCReq>.Instance;

        public static OCVer Versiones => Singleton<OCVer>.Instance;

        #endregion Colecciones

        #region Proyecto

        public static string PName => _proyecto is null ? "(?)" : _proyecto.Nombre;

        public static Proyecto Proyecto
        {
            get => _proyecto;
            set
            {
                if (value != null && !string.IsNullOrWhiteSpace(value.Nombre))
                {
                    Cargar(value);
                }

                _proyecto = value;
            }
        }

        private static Proyecto _proyecto;

        #endregion Proyecto

        private ActivationService ActivationService => _activationService.Value;

        private readonly Lazy<ActivationService> _activationService;

        public App()
        {
            InitializeComponent();

            _activationService = new Lazy<ActivationService>(() =>
            {
                return new ActivationService(this, typeof(MainPage), new Lazy<UIElement>(new ShellPage()));
            });
        }

        public static async Task Guardar()
        {
            if (Proyecto != null && !string.IsNullOrWhiteSpace(Proyecto.Nombre))
            {
                Proyecto.Clientes = Clientes;
                Proyecto.Versiones = Versiones;
                Proyecto.Recursos = Recursos;

                foreach (Requisito req in Requisitos)
                {
                    for (int i = req.Valoraciones.Count; i < Clientes.Count; i++)
                    {
                        req.Valoraciones.Add(0);
                    }
                }

                await DataHelper.SaveAs(Proyecto.Nombre, await Json.ToStringAsync(Proyecto));
            }
        }

        protected override async void OnActivated(IActivatedEventArgs args)
        {
            await ActivationService.ActivateAsync(args);
        }

        protected override async void OnLaunched(LaunchActivatedEventArgs args)
        {
            if (!args.PrelaunchActivated)
            {
                await ActivationService.ActivateAsync(args);
            }
        }

        private static void Cargar(Proyecto value)
        {
            Clientes.Clear();
            Versiones.Clear();
            Requisitos.Clear();
            Recursos.Clear();

            foreach (Cliente cliente in value.Clientes)
            {
                Clientes.Add(cliente);
            }

            foreach (Recurso rec in value.Recursos)
            {
                Recursos.Add(rec);
            }

            foreach (Models.Version version in value.Versiones)
            {
                foreach (Requisito req in version.Requisitos.Where(req => !Requisitos.Any(r => r.Id == req.Id)))
                {
                    Requisitos.Add(req);
                }

                Versiones.Add(version);
            }
        }
    }
}
