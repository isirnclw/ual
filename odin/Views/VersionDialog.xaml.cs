using Odin.Models;
using System;
using System.Collections.ObjectModel;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;
using Windows.UI.Xaml.Controls;
using Version = Odin.Models.Version;

// La plantilla de elemento del cuadro de diálogo de contenido está documentada en https://go.microsoft.com/fwlink/?LinkId=234238

namespace Odin.Views
{
    public sealed partial class VersionDialog : ContentDialog
    {
        public string PNname => App.PName;

        public ObservableCollection<Recurso> RecItems => App.Recursos;

        public ObservableCollection<Requisito> ReqItems => App.Requisitos;

        public Version Version { get; set; }

        public VersionDialog()
        {
            InitializeComponent();

            Opened += Clear;
            Closed += async (s, e) =>
            {
                await CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync((CoreDispatcherPriority)1, async () =>
                {
                    await App.Guardar();
                    Version = null;
                });
            };
        }

        public void ContentDialog_PrimaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            // Cancel Button
        }

        public void ContentDialog_SecondaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            bool isNew = Version is null;
            Version version = Version ?? new Version
            {
                Nombre = Nombre.Text,
                Inicio = FInicio.Date,
                Fin = FFin.Date,
                Requisitos = new ObservableCollection<Requisito>(),
            };

            uint.TryParse(Esfuerzo.Text, out uint esfuerzo);
            version.MaxEsfuerzo = esfuerzo;

            foreach (object item in Requisitos.SelectedItems)
            {
                version.Requisitos.Add(item as Requisito);
                version.Satisfaccion += ((Requisito)item).Satisfaccion;
            }

            foreach (object item in Recursos.SelectedItems)
            {
                version.Recursos.Add(item as Recurso);
            }

            if (isNew) { App.Versiones.Add(version); }
        }

        private void Clear(object s, ContentDialogOpenedEventArgs e)
        {
            Nombre.Text = string.Empty;
            FInicio.Date = FFin.Date = DateTime.UtcNow;
            Esfuerzo.Text = string.Empty;
            Requisitos.SelectionMode = default;
            Requisitos.SelectionMode = ListViewSelectionMode.Multiple;
            Recursos.SelectionMode = default;
            Recursos.SelectionMode = ListViewSelectionMode.Multiple;
        }
    }
}
