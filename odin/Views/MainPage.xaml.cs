using Odin.ViewModels;
using System;
using System.Threading.Tasks;
using Windows.UI.Xaml.Controls;
using Windows.UI.Xaml.Navigation;
using XCore.Helpers;

namespace Odin.Views
{
    public sealed partial class MainPage : Page
    {
        public MainViewModel ViewModel => Singleton<MainViewModel>.Instance;

        public static bool ShouldOpen = true;

        public MainPage()
        {
            InitializeComponent();
            TryDialog();
        }

        protected override void OnNavigatedTo(NavigationEventArgs e)
        {
            base.OnNavigatedTo(e);
            TryDialog();
        }

        private async void TryDialog()
        {
            if (ShouldOpen)
            {
                try
                {
                    ShouldOpen = false;
                    await Singleton<ProyectoDialog>.Instance.ShowAsync();
                }
                catch
                {
                    await Task.Delay(100).ContinueWith((r) => Singleton<ProyectoDialog>.Instance.ShowAsync());
                }
            }

            pName.Text = ViewModel.PName;
        }
    }
}
