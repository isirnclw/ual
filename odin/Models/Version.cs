using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;

namespace Odin.Models
{
    public class Version : IEqualityComparer<Version>
    {
        public long ActEsfuerzo { get; set; }

        public byte EsfuerzoDia { get; set; }

        public DateTimeOffset Fin { get; set; }

        [JsonProperty("_id")]
        public long Id { get; set; }

        public DateTimeOffset Inicio { get; set; }

        public long MaxEsfuerzo { get; set; }

        public string Nombre { get; set; }

        public ObservableCollection<Requisito> Requisitos { get; set; }

        public long Satisfaccion { get; set; }

        [JsonIgnore]
        public ObservableCollection<Recurso> Recursos => App.Recursos;

        public bool Equals(Version x, Version y)
        {
            return x.Id.Equals(y.Id);
        }

        public int GetHashCode(Version obj)
        {
            return obj.Id.GetHashCode();
        }

        public override string ToString()
        {
            return Nombre;
        }
    }
}
