using Odin.Models;
using Odin.ViewModels;
using System;
using System.Threading.Tasks;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;
using Valoraciones = System.Collections.ObjectModel.ObservableCollection<byte>;

namespace Odin.Views
{
    public sealed partial class ClienteListPage : Page
    {
        public ClienteViewModel ViewModel => Singleton<ClienteViewModel>.Instance;

        public ClienteListPage()
        {
            InitializeComponent();

            Loaded += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            ResetBtn.Click += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            AddBtn.Click += async (s, e) => await TryDialog();
            SearchBtn.Click += async (s, e) =>
            {
                Singleton<SearchDialog>.Instance.Type = "Cliente";
                await Singleton<SearchDialog>.Instance.ShowAsync();
                dataGrid.ItemsSource = Singleton<SearchDialog>.Instance.Items;
            };

            dataGrid.CellEditEnded += async (s, e) => await App.Guardar();
        }

        private void AsignarReq(object sender, Windows.UI.Xaml.RoutedEventArgs e)
        {
            Valoraciones valoraciones = ((Requisito)((TextBox)sender).Tag).Valoraciones;
            ViewModel.Requisitos(valoraciones, (Cliente)dataGrid.SelectedItem, (TextBox)sender);
        }

        private void AsignarValor(object sender, TextChangedEventArgs e)
        {
            Valoraciones valoraciones = ((Requisito)((TextBox)sender).Tag).Valoraciones;
            ViewModel.Valoraciones(valoraciones, (Cliente)dataGrid.SelectedItem, (TextBox)sender);
        }

        private async Task TryDialog()
        {
            try
            {
                await Singleton<ClienteDialog>.Instance.ShowAsync();
            }
            catch
            {
                await Task.Delay(100).ContinueWith((e) => TryDialog());
            }
        }
    }
}
