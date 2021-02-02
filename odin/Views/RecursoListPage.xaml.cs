using Odin.ViewModels;
using System;
using System.Threading.Tasks;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;

namespace Odin.Views
{
    public sealed partial class RecursoListPage : Page
    {
        public RecursoViewModel ViewModel => Singleton<RecursoViewModel>.Instance;

        public RecursoListPage()
        {
            InitializeComponent();

            Loaded += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            ResetBtn.Click += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            AddBtn.Click += async (s, e) => await TryDialog();
            SearchBtn.Click += async (s, e) =>
            {
                Singleton<SearchDialog>.Instance.Type = "Recurso";
                await Singleton<SearchDialog>.Instance.ShowAsync();
                dataGrid.ItemsSource = Singleton<SearchDialog>.Instance.Items;
            };

            dataGrid.CellEditEnded += async (s, e) => await App.Guardar();
        }

        private async Task TryDialog()
        {
            try
            {
                await Singleton<RecursoDialog>.Instance.ShowAsync();
            }
            catch
            {
                await Task.Delay(100).ContinueWith((e) => TryDialog());
            }
        }
    }
}
