using Newtonsoft.Json;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Odin.Models
{
    public class Cliente : IEqualityComparer<Cliente>
    {
        [JsonProperty("_id")]
        public long Id { get; set; }

        public long Importancia { get; set; }

        public string Nombre { get; set; }

        [JsonIgnore]
        public ObservableCollection<Requisito> Requisitos => App.Requisitos;

        public bool Equals(Cliente x, Cliente y)
        {
            return x.Id.Equals(y.Id);
        }

        public int GetHashCode(Cliente obj)
        {
            return obj.Id.GetHashCode();
        }

        public override string ToString()
        {
            return Nombre;
        }
    }
}
