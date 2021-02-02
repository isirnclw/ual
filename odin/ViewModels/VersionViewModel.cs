using Microsoft.Toolkit.Uwp.UI.Controls;
using Odin.Models;
using System.Collections.ObjectModel;
using System.Linq;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;

namespace Odin.ViewModels
{
    public class VersionViewModel : Observable
    {
        public ObservableCollection<Version> Items => Singleton<ObservableCollection<Version>>.Instance;

        public void Cantidades(TextBlock s, DataGrid dataGrid)
        {
            long total = 0;

            if (s.Tag is Recurso r && dataGrid.SelectedItem is Version v)
            {
                foreach (Recurso rec in v.Requisitos.SelectMany(req => req.Recursos.Where(rec => rec.Id.Equals(r.Id))))
                {
                    total += rec.Cantidad;
                }
            }

            s.Text = total.ToString();
        }
    }
}
