using XCore.Helpers;

namespace Odin.ViewModels
{
    public class MainViewModel : Observable
    {
        public string PName => App.PName;

        public static bool ShouldOpen = true;
    }
}
