using Odin.Helpers;
using System;
using System.Collections.ObjectModel;
using System.Threading.Tasks;
using XCore.Helpers;

namespace Odin.Models
{
    public static class ProyectoExtensions
    {
        public static async Task<Proyecto> Parse(this string value)
        {
            return await Json.ToObjectAsync<Proyecto>(DataHelper.Read(value));
        }
    }

    public class Proyecto
    {
        public ObservableCollection<Cliente> Clientes { get; set; }

        public DateTimeOffset Fin { get; set; }

        public long Id { get; set; }

        public DateTimeOffset Inicio { get; set; }

        public string Nombre { get; set; }

        public ObservableCollection<Recurso> Recursos { get; set; }

        public ObservableCollection<Version> Versiones { get; set; }

        public override string ToString()
        {
            return Nombre;
        }
    }
}
