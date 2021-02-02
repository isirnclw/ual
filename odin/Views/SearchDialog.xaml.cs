using Odin.Models;
using System.Collections;
using System.Collections.ObjectModel;
using System.Linq;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;

// La plantilla de elemento del cuadro de diálogo de contenido está documentada en https://go.microsoft.com/fwlink/?LinkId=234238

namespace Odin.Views
{
    public sealed partial class SearchDialog : ContentDialog
    {
        public IList Items { get; set; }

        public string Type { get; set; }

        public SearchDialog()
        {
            InitializeComponent();
            Opened += Clear;
        }

        public void ContentDialog_PrimaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            Type = default;
        }

        public void ContentDialog_SecondaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            IList items = Type switch
            {
                "Cliente" => App.Clientes,
                "Recurso" => App.Recursos.Distinct().ToList(),
                "Requisito" => App.Requisitos.Distinct().ToList(),
                _ => App.Versiones.OrderBy(v => v.Id).ToList()
            };

            Items = Type switch
            {
                "Cliente" => new ObservableCollection<Cliente>(),
                "Recurso" => new ObservableCollection<Recurso>(),
                "Requisito" => new ObservableCollection<Requisito>(),
                _ => new ObservableCollection<Version>(),
            };

            if (!string.IsNullOrWhiteSpace(Busqueda.Text))
            {
                for (int i = 0; i < items.Count; i++)
                {
                    bool matches = Type switch
                    {
                        "Cliente" => Search(items[i] as Cliente),
                        "Recurso" => Search(items[i] as Recurso),
                        "Requisito" => Search(items[i] as Requisito),
                        _ => Search(items[i] as Version)
                    };

                    if (matches)
                    {
                        Items.Add(items[i]);
                    }
                }
            }
            else
            {
                for (int i = 0; i < items.Count; i++)
                {
                    Items.Add(items[i]);
                }
            }
        }

        private void Clear(object s, ContentDialogOpenedEventArgs e)
        {
            Busqueda.Text = string.Empty;
        }

        #region Search

        private bool Search(Version version)
        {
            return version.Nombre.ContainsIns(Busqueda.Text);
        }

        private bool Search(Cliente cliente)
        {
            return cliente.Nombre.ContainsIns(Busqueda.Text);
        }

        private bool Search(Requisito requisito)
        {
            return requisito.Nombre.ContainsIns(Busqueda.Text) || EstadoEs(requisito.Estado, Busqueda.Text);
        }

        private bool Search(Recurso recurso)
        {
            return recurso.Tipo.ContainsIns(Busqueda.Text);
        }

        #endregion Search

        private bool EstadoEs(string estado, string texto)
        {
            return Singleton<RequisitoDialog>.Instance.EstadosValues.Any(e => estado == e && texto.ContainsIns(e));
        }
    }
}
