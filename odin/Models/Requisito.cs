using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Odin.Models
{
    public class Requisito : IEqualityComparer<Requisito>
    {
        public long Esfuerzo { get; set; }

        public string Estado { get; set; }

        public long Exito { get; set; }

        public DateTimeOffset Fin { get; set; }

        [JsonProperty("_id")]
        public long Id { get; set; }

        public DateTimeOffset Inicio { get; set; }

        public string Nombre { get; set; }

        public long Prioridad { get; set; }

        public ObservableCollection<Recurso> Recursos { get; set; }

        public ObservableCollection<Requisito> Relaciones { get; set; }

        public long Riesgo { get; set; }

        public long Satisfaccion { get; set; }

        public ObservableCollection<byte> Valoraciones { get; set; }

        public bool Equals(Requisito x, Requisito y)
        {
            return x.Id.Equals(y.Id);
        }

        public int GetHashCode(Requisito obj)
        {
            return obj.Id.GetHashCode();
        }

        public override string ToString()
        {
            return Nombre;
        }
    }
}
