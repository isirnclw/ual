using Odin.Models;
using System.Collections.ObjectModel;
using XCore.Helpers;

namespace Odin.ViewModels
{
    public class RecursoViewModel : Observable
    {
        public ObservableCollection<Recurso> Items => Singleton<ObservableCollection<Recurso>>.Instance;
    }
}
