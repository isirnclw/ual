using Odin.Models;
using System;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;
using Windows.UI.Xaml.Controls;

// La plantilla de elemento del cuadro de diálogo de contenido está documentada en https://go.microsoft.com/fwlink/?LinkId=234238

namespace Odin.Views
{
    public sealed partial class ClienteDialog : ContentDialog
    {
        public Cliente Cliente { get; set; }

        public string PNname => App.PName;

        public ClienteDialog()
        {
            InitializeComponent();

            Opened += Clear;
            Closed += async (s, e) =>
            {
                await CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync((CoreDispatcherPriority)1, async () =>
                {
                    await App.Guardar();
                    Cliente = null;
                });
            };
        }

        public void ContentDialog_PrimaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            // Cancel Button
        }

        public void ContentDialog_SecondaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            bool isNew = Cliente is null;
            Cliente cliente = Cliente ?? new Cliente { Id = App.Clientes.Count + 1 };
            cliente.Nombre = Nombre.Text;

            uint.TryParse(Importancia.Text, out uint importancia);
            cliente.Importancia = importancia;

            if (isNew) { App.Clientes.Add(cliente); }
        }

        private void Clear(object s, ContentDialogOpenedEventArgs e)
        {
            Nombre.Text = string.Empty;
            Importancia.Text = string.Empty;
        }
    }
}
