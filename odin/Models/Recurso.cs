using Newtonsoft.Json;
using System.Collections.Generic;

namespace Odin.Models
{
    public class Recurso : IEqualityComparer<Recurso>
    {
        public long Cantidad { get; set; }

        [JsonProperty("_id")]
        public long Id { get; set; }

        public string Tipo { get; set; }

        public bool Equals(Recurso x, Recurso y)
        {
            return x.Id.Equals(y.Id);
        }

        public int GetHashCode(Recurso obj)
        {
            return obj.Id.GetHashCode();
        }

        public override string ToString()
        {
            return Tipo;
        }
    }
}
