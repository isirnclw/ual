using Microsoft.Toolkit.Uwp.UI.Controls;
using Odin.Models;
using Odin.ViewModels;
using System;
using System.Linq;
using System.Threading.Tasks;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;

namespace Odin.Views
{
    public sealed partial class RequisitoListPage : Page
    {
        public RequisitoViewModel ViewModel => Singleton<RequisitoViewModel>.Instance;

        public string[] Estados => Singleton<RequisitoDialog>.Instance.EstadosValues;

        public RequisitoListPage()
        {
            InitializeComponent();

            Loaded += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            ResetBtn.Click += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            AddBtn.Click += async (s, e) => await TryDialog();
            SearchBtn.Click += async (s, e) =>
            {
                Singleton<SearchDialog>.Instance.Type = "Requisito";
                await Singleton<SearchDialog>.Instance.ShowAsync();
                dataGrid.ItemsSource = Singleton<SearchDialog>.Instance.Items;
            };

            dataGrid.CellEditEnded += async (s, e) => await App.Guardar();
        }

        private void ActualizarReq(object sender, SelectionChangedEventArgs e)
        {
            ViewModel.Selected = (Requisito)((DataGrid)sender).SelectedItem;
        }

        private async void AgregarRec(object sender, RoutedEventArgs e)
        {
            await ViewModel.ShowRecAync(new ListView
            {
                ItemsSource = App.Recursos.Where(r => !ViewModel.Selected.Recursos.Contains(r)),
                SelectionMode = ListViewSelectionMode.Multiple,
            });
        }

        private async void AgregarReq(object sender, RoutedEventArgs e)
        {
            await ViewModel.ShowReqAsync(new ListView
            {
                ItemsSource = App.Requisitos.Where(r => !ViewModel.Selected.Relaciones.Contains(r) && !ViewModel.Selected.Equals(r)),
                SelectionMode = ListViewSelectionMode.Multiple
            });
        }

        private void EliminarRec(object sender, RoutedEventArgs e)
        {
            ViewModel.RemoveRec((long)((Button)sender).Tag);
        }

        private void EliminarReq(object sender, RoutedEventArgs e)
        {
            ViewModel.RemoveReq((long)((Button)sender).Tag);
        }

        private async Task TryDialog()
        {
            try
            {
                await Singleton<RequisitoDialog>.Instance.ShowAsync();
            }
            catch
            {
                await Task.Delay(100).ContinueWith((e) => TryDialog());
            }
        }
    }
}
