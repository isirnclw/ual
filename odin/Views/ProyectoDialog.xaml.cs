using Odin.Helpers;
using Odin.Models;
using System;
using System.Collections.ObjectModel;
using Windows.UI.Xaml.Controls;

// La plantilla de elemento del cuadro de diálogo de contenido está documentada en https://go.microsoft.com/fwlink/?LinkId=234238

namespace Odin.Views
{
    public sealed partial class ProyectoDialog : ContentDialog
    {
        public Proyecto Proyecto { get; set; }

        public ProyectoDialog()
        {
            InitializeComponent();

            box.SelectionChanged += async (s, e) =>
            {
                if (box.SelectedIndex >= 0)
                {
                    App.Proyecto = await ((string)box.Items[box.SelectedIndex]).Parse();
                    pName.Text = string.Empty;
                    Hide();
                }
            };

            Opened += Clear;
            Closed += (s, e) => Proyecto = null;
        }

        public async void Clear(object sender, ContentDialogOpenedEventArgs e)
        {
            box.Items.Clear();

            foreach (Windows.Storage.StorageFile json in await DataHelper.Folder.GetFilesAsync())
            {
                box.Items.Add(json.DisplayName);
            }

            box.SelectedIndex = -1;
            box.IsEnabled = box.Items.Count > 0;
            pName.Text = string.Empty;
        }

        public void ContentDialog_PrimaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            App.Proyecto = new Proyecto
            {
                Id = box.Items.Count + 1,
                Clientes = new ObservableCollection<Cliente>(),
                Inicio = DateTime.UtcNow,
                Fin = DateTime.UtcNow,
                Nombre = pName.Text,
                Versiones = new ObservableCollection<Models.Version>(),
                Recursos = new ObservableCollection<Recurso>()
            };

            App.Proyecto.Versiones.Add(new Models.Version
            {
                Id = 0,
                Inicio = DateTime.UtcNow,
                Fin = DateTime.UtcNow,
                Nombre = "No asignado",
                Requisitos = new ObservableCollection<Requisito>()
            });

            App.Versiones.Add(App.Proyecto.Versiones[0]);
        }
    }
}
