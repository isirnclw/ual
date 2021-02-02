using Odin.ViewModels;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;

namespace Odin.Views
{
    public sealed partial class ShellPage : Page
    {
        public ShellViewModel ViewModel => Singleton<ShellViewModel>.Instance;

        public ShellPage()
        {
            InitializeComponent();

            DataContext = ViewModel;

            ViewModel.Initialize(shellFrame, navigationView, KeyboardAccelerators);
        }
    }
}