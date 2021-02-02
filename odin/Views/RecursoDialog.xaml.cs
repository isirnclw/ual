using Odin.Models;
using System;
using System.Collections.ObjectModel;
using System.Linq;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;
using Version = Odin.Models.Version;

namespace Odin.Views
{
    public sealed partial class RecursoDialog : ContentDialog
    {
        public ObservableCollection<Version> Items => Singleton<ObservableCollection<Version>>.Instance;

        public string PNname => App.PName;

        public Recurso Recurso { get; set; }

        public RecursoDialog()
        {
            InitializeComponent();

            Opened += Clear;
            Closed += async (s, e) =>
            {
                await CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync((CoreDispatcherPriority)1, async () => 
                {
                    await App.Guardar();
                    Recurso = null;
                });
        
            };
        }

        public void ContentDialog_PrimaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            // Cancel button
        }

        public void ContentDialog_SecondaryButtonClick(ContentDialog sender, ContentDialogButtonClickEventArgs args)
        {
            bool isNew = Recurso is null;
            Recurso recurso = Recurso ?? new Recurso
            {
                Id = App.Recursos.Count + 1,
                Tipo = tipo.Text
            };

            long.TryParse(cantidad.Text, out long cant);
            recurso.Cantidad = cant;

            if (isNew)
            {
                App.Recursos.Add(recurso);
            }
        }

        private void Clear(object s, ContentDialogOpenedEventArgs e)
        {
            tipo.Text = string.Empty;
            cantidad.Text = "0";
        }
    }
}
