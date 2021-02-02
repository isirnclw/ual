using Odin.Models;
using System;
using System.Collections.ObjectModel;
using System.Threading.Tasks;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;
using Windows.UI.Xaml;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;

namespace Odin.ViewModels
{
    public class RequisitoViewModel : Observable
    {
        public ObservableCollection<Requisito> Items => Singleton<ObservableCollection<Requisito>>.Instance;

        public Requisito Selected { get; set; }

        public void RemoveRec(long id)
        {
            for (ushort i = 0; i < Selected.Recursos.Count; i++)
            {
                if (Selected.Recursos[i].Id == id)
                {
                    Selected.Recursos.RemoveAt(i);
                    break;
                }
            }
        }

        public void RemoveReq(long id)
        {
            for (ushort i = 0; i < Selected.Relaciones.Count; i++)
            {
                if (Selected.Relaciones[i].Id == id)
                {
                    Selected.Relaciones.RemoveAt(i);

                    break;
                }
            }
        }

        public async Task ShowRecAync(ListView list)
        {
            ContentDialog dialog = new ContentDialog
            {
                Title = "Agregar recursos",
                Style = (Style)Application.Current.Resources["Agregar"],
                Content = list
            };

            dialog.Closed += async (s, e) =>
            {
                await CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync((CoreDispatcherPriority)1, async () =>
                {
                    await App.Guardar();
                });
            };

            dialog.SecondaryButtonClick += (s, e) =>
            {
                foreach (object rec in list.SelectedItems)
                {
                    Selected.Recursos.Add((Recurso)rec);
                }
            };

            foreach (Recurso rec in Selected.Recursos)
            {
                list.SelectedItems.Add(rec);
            }

            await dialog.ShowAsync();
        }

        public async Task ShowReqAsync(ListView list)
        {
            ContentDialog dialog = new ContentDialog
            {
                Title = "Agregar dependencias",
                Style = (Style)Application.Current.Resources["Agregar"],
                Content = list
            };

            dialog.Closed += async (s, e) =>
            {
                await CoreApplication.MainView.CoreWindow.Dispatcher.RunAsync((CoreDispatcherPriority)1, async () =>
                {
                    await App.Guardar();
                });
            };

            dialog.SecondaryButtonClick += (s, e) =>
            {
                foreach (object req in list.SelectedItems)
                {
                    Selected.Relaciones.Add((Requisito)req);
                }
            };

            foreach (Requisito req in Selected.Relaciones)
            {
                list.SelectedItems.Add(req);
            }

            await dialog.ShowAsync();
        }
    }
}
