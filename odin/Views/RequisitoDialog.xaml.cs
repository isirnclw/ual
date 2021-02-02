using Odin.Models;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;
using OCRec = System.Collections.ObjectModel.ObservableCollection<Odin.Models.Recurso>;
using OCReq = System.Collections.ObjectModel.ObservableCollection<Odin.Models.Requisito>;

// La plantilla de elemento del cuadro de diálogo de contenido está documentada en https://go.microsoft.com/fwlink/?LinkId=234238

namespace Odin.Views
{
    public sealed partial class RequisitoDialog : ContentDialog
    {
        public string PNname => App.PName;

        public OCRec RecItems => Singleton<OCRec>.Instance;

        public OCReq ReqItems => Requisito is null
            ? Singleton<OCReq>.Instance
            : new OCReq(Singleton<OCReq>.Instance.SkipWhile(r => Requisito.Id == r.Id));

        public Requisito Requisito { get; set; }

        public string[] EstadosValues = new[] { "Nuevo", "Activo", "Resuelto", "Cerrado" };

        public RequisitoDialog()
        {
            InitializeComponent();

            Opened += Clear;
            Closed += async (s, e) =>
            {
                await CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync((CoreDispatcherPriority)1, async () =>
                {
                    await App.Guardar();
                    Requisito = null;
                });
            };

        }

        public void ContentDialog_PrimaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            // Cancel Button
        }

        public void ContentDialog_SecondaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            bool isNew = Requisito is null;
            Requisito requisito = Requisito ?? new Requisito
            {
                Id = App.Requisitos.Count + 1,
                Valoraciones = new ObservableCollection<byte>()
            };

            requisito.Nombre = Nombre.Text;
            requisito.Recursos = ToList<Recurso>(Recursos.SelectedItems);
            requisito.Relaciones = ToList<Requisito>(Dependencias.SelectedItems);
            requisito.Estado = EstadosValues[Estados.SelectedIndex < 0 ? 0 : Estados.SelectedIndex];

            long.TryParse(Esfuerzo.Text, out long num);
            requisito.Esfuerzo = num;

            long.TryParse(Exito.Text, out num);
            requisito.Exito = num;

            long.TryParse(Riesgo.Text, out num);
            requisito.Riesgo = num;

            if (requisito != null && requisito.Valoraciones != null)
            {
                for (int i = requisito.Valoraciones.Count; i < App.Clientes.Count; i++)
                {
                    requisito.Valoraciones.Add(1);
                }
            }

            if (isNew)
            {
                App.Requisitos.Add(requisito);
                App.Proyecto.Versiones.Last().Requisitos.Add(requisito);
            }
        }

        private void Clear(object s, ContentDialogOpenedEventArgs e)
        {
            Recursos.SelectionMode = ListViewSelectionMode.None;
            Dependencias.SelectionMode = ListViewSelectionMode.None;
            Recursos.SelectionMode = ListViewSelectionMode.Multiple;
            Dependencias.SelectionMode = ListViewSelectionMode.Multiple;

            Estados.ItemsSource = EstadosValues;

            if (Requisito != null)
            {
                Title = "Requisito";
                SecondaryButtonText = "Aceptar";

                Nombre.Text = Requisito.Nombre;
                Esfuerzo.Text = Requisito.Esfuerzo.ToString();
                Exito.Text = Requisito.Exito.ToString();
                Riesgo.Text = Requisito.Riesgo.ToString();
                Estados.SelectedIndex = (Requisito.Estado ?? " ")[0] switch { 'A' => 1, 'R' => 2, 'C' => 3, _ => 0 };

                foreach (Recurso rec in Requisito.Recursos.Distinct())
                {
                    Recursos.SelectedItems.Add(rec);
                }

                foreach (Requisito req in Requisito.Relaciones.Distinct())
                {
                    Dependencias.SelectedItems.Add(req);
                }
            }
            else
            {
                Nombre.Text = string.Empty;
                Esfuerzo.Text = "0";
                Exito.Text = "0";
                Riesgo.Text = "0";
                Estados.SelectedIndex = 0;
            }
        }

        private ObservableCollection<T> ToList<T>(IList<object> items)
        {
            ObservableCollection<T> list = new ObservableCollection<T>();

            foreach (object item in items)
            {
                list.Add((T)item);
            }

            return list;
        }
    }
}
