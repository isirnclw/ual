using Odin.Models;
using Odin.ViewModels;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Threading.Tasks;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;
using static Odin.Helpers.AlgorithmHelper;
using Version = Odin.Models.Version;

namespace Odin.Views
{
    public sealed partial class VersionListPage : Page
    {
        public VersionViewModel ViewModel => Singleton<VersionViewModel>.Instance;

        public VersionListPage()
        {
            InitializeComponent();

            Loaded += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            ResetBtn.Click += (s, e) => dataGrid.ItemsSource = ViewModel.Items;
            AddBtn.Click += async (s, e) => await TryDialog();
            SearchBtn.Click += async (s, e) =>
            {
                Singleton<SearchDialog>.Instance.Type = "Version";
                await Singleton<SearchDialog>.Instance.ShowAsync();
                dataGrid.ItemsSource = Singleton<SearchDialog>.Instance.Items;
            };

            GenBtn.Click += async (s, e) =>
            {
                Grid content = new Grid();
                Style textBox = (Style)Application.Current.Resources["TextBox"];
                DatePicker inicio = new DatePicker { Date = DateTime.Now, Margin = new Thickness(0, 4, 8, 8) };
                ContentDialog dialog = new ContentDialog
                {
                    Title = "Versionado automático",
                    Style = (Style)Application.Current.Resources["Agregar"],
                    SecondaryButtonText = "Generar",
                    Content = content
                };

                TextBlock
                    nombreHeader = new TextBlock { Text = "Nombre", Margin = new Thickness(0, 8, 0, 4) },
                    inicioHeader = new TextBlock { Text = "Fecha de inicio", Margin = new Thickness(0, 8, 0, 4) },
                    mesfHeader = new TextBlock { Text = "Esfuerzo máximo", Margin = new Thickness(0, 8, 0, 4) },
                    esfdHeader = new TextBlock { Text = "Esfuerzo / Día", Margin = new Thickness(0, 8, 0, 4) };

                TextBox
                    nombre = new TextBox { Margin = new Thickness(0, 4, 8, 8), Style = textBox },
                    esfuerzoMax = new TextBox { Margin = new Thickness(0, 4, 8, 8), Style = textBox },
                    esfuerzoDia = new TextBox { Margin = new Thickness(0, 4, 8, 8), Style = textBox };

                #region Construcción del contenido del diálogo

                content.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });
                content.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });
                content.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });
                content.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });
                content.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });
                content.RowDefinitions.Add(new RowDefinition { Height = new GridLength(1, GridUnitType.Star) });

                content.ColumnDefinitions.Add(new ColumnDefinition { Width = new GridLength(1, GridUnitType.Star) });
                content.ColumnDefinitions.Add(new ColumnDefinition { Width = new GridLength(1, GridUnitType.Star) });

                content.Children.Add(nombreHeader);
                content.Children.Add(nombre);
                content.Children.Add(inicioHeader);
                content.Children.Add(inicio);
                content.Children.Add(mesfHeader);
                content.Children.Add(esfuerzoMax);
                content.Children.Add(esfdHeader);
                content.Children.Add(esfuerzoDia);

                Grid.SetRow(nombreHeader, 0);
                Grid.SetRow(nombre, 1);
                Grid.SetRow(inicioHeader, 2);
                Grid.SetRow(inicio, 3);
                Grid.SetRow(mesfHeader, 4);
                Grid.SetRow(esfuerzoMax, 5);
                Grid.SetRow(esfdHeader, 4);
                Grid.SetRow(esfuerzoDia, 5);

                Grid.SetColumnSpan(nombreHeader, 2);
                Grid.SetColumnSpan(nombre, 2);
                Grid.SetColumnSpan(inicioHeader, 2);
                Grid.SetColumnSpan(inicio, 2);

                Grid.SetColumn(esfdHeader, 1);
                Grid.SetColumn(esfuerzoDia, 1);

                #endregion Construcción del contenido del diálogo

                dialog.SecondaryButtonClick += async (s, e) =>
                {
                    Dictionary<DateTimeOffset, List<Requisito>> fechasReqs;
                    Version nueva = new Version
                    {
                        Id = App.Versiones.Count,
                        Nombre = nombre.Text,
                        Requisitos = new ObservableCollection<Requisito>(App.Requisitos.Where(r => r.Estado != Singleton<RequisitoDialog>.Instance.EstadosValues[3]).ToList()),
                        Inicio = inicio.Date,
                        Satisfaccion = 0,
                        ActEsfuerzo = 0
                    };

                    if (nueva.Requisitos.Count == 0)
                    {
                        return;
                    }

                    long.TryParse(esfuerzoMax.Text, out long mesf);
                    nueva.MaxEsfuerzo = mesf;

                    byte.TryParse(esfuerzoDia.Text, out byte esfd);
                    nueva.EsfuerzoDia = esfd;

                    fechasReqs = GenerarVersion(nueva);
                    nueva.Fin = fechasReqs.Keys.LastOrDefault();

                    nueva.Requisitos.Clear();

                    foreach (KeyValuePair<DateTimeOffset, List<Requisito>> fecha in fechasReqs)
                    {
                        foreach (Requisito req in fecha.Value)
                        {
                            req.Inicio = fecha.Key;
                            req.Fin = fecha.Key.AddDays(req.Esfuerzo / esfd);

                            nueva.Satisfaccion += req.Satisfaccion;
                            nueva.ActEsfuerzo += req.Esfuerzo;
                            nueva.Requisitos.Add(req);
                        }
                    }

                    App.Versiones.Add(nueva);

                    await App.Guardar();
                };

                await dialog.ShowAsync();
            };

            dataGrid.CellEditEnded += async (s, e) => await App.Guardar();
        }

        private void CantidadRec(object sender, RoutedEventArgs e)
        {
            ViewModel.Cantidades((TextBlock)sender, dataGrid);
        }

        private async void ReqDialog(object sender, SelectionChangedEventArgs e)
        {
            ListView s = (ListView)sender;

            if (s.SelectedIndex != -1)
            {
                Singleton<RequisitoDialog>.Instance.Requisito = (Requisito)s.SelectedItem;
                await Singleton<RequisitoDialog>.Instance.ShowAsync();
                s.SelectedIndex = -1;
            }
        }

        private async Task TryDialog()
        {
            try
            {
                await Singleton<VersionDialog>.Instance.ShowAsync();
            }
            catch
            {
                await Task.Delay(100).ContinueWith((e) => TryDialog());
            }
        }
    }
}
