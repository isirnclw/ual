using Odin.Models;
using System.Collections.ObjectModel;
using Windows.UI.Xaml.Controls;
using XCore.Helpers;
using Valoraciones = System.Collections.ObjectModel.ObservableCollection<byte>;

namespace Odin.ViewModels
{
    public class ClienteViewModel : Observable
    {
        public ObservableCollection<Cliente> Items => Singleton<ObservableCollection<Cliente>>.Instance;

        public void Requisitos(Valoraciones valoraciones, Cliente cliente, TextBox textBox)
        {
            for (int i = valoraciones.Count; i < App.Clientes.Count; i++)
            {
                valoraciones.Add(1);
            }

            textBox.Text = valoraciones[App.Clientes.IndexOf(cliente)].ToString();
        }

        public void Valoraciones(Valoraciones valoraciones, Cliente cliente, TextBox textBox)
        {
            byte.TryParse(textBox.Text, out byte valor);

            for (int i = valoraciones.Count; i < App.Clientes.Count; i++)
            {
                valoraciones.Add(1);
            }

            valoraciones[App.Clientes.IndexOf(cliente)] = (byte)(valor < 1 ? 1 : valor > 5 ? 5 : valor);

            ((Requisito)textBox.Tag).Satisfaccion = 0;

            for (int i = valoraciones.Count; i < App.Clientes.Count; i++)
            {
                valoraciones.Add(1);
            }

            for (int i = 0; i < App.Clientes.Count; i++)
            {
                ((Requisito)textBox.Tag).Satisfaccion += App.Clientes[i].Importancia * valoraciones[i];
            }
        }
    }
}
