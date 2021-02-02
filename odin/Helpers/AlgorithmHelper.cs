using Odin.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using Version = Odin.Models.Version;

namespace Odin.Helpers
{
    public class AlgorithmHelper
    {
        private static float fechaFin;

        private static LinkedList<Requisito> ListaRequisitos;

        private static Dictionary<float, List<long>> ResultadoTemporal;

        private static Version Version;

        public static void Clonar(ICollection<long> salida, ICollection<long> entrada)
        {
            salida.Clear();
            foreach (long aux in entrada)
            {
                salida.Add(aux);
            }
        }

        public static Dictionary<DateTimeOffset, List<Requisito>> GenerarVersion(Version version)
        {
            ResultadoTemporal = new Dictionary<float, List<long>>();
            ListaRequisitos = new LinkedList<Requisito>();
            LinkedList<LinkedList<Requisito>> conjuntosCandidatos;

            fechaFin = float.MaxValue;
            Version = version;

            foreach (Requisito req in version.Requisitos)
            {
                ListaRequisitos.AddLast(req);
            }

            //Sacamos todos los conjuntos
            conjuntosCandidatos = CalcularCombinaciones(ListaRequisitos);

            LinkedList<Requisito> elegido = new LinkedList<Requisito>();

            long satisfaccion = 0;
            long temp;

            //Localizamos los validos y btenemos los mejores conjuntos validos Satisfaccion
            foreach (LinkedList<Requisito> req in conjuntosCandidatos)
            {
                if (!Validar(req, version))
                {
                    continue;
                }

                //El que tenga mejor satisfacción. si son iguales. Mejor esfuerzo
                temp = CalcularSumaSatisfaccion(req);
                if (temp > satisfaccion)
                {
                    satisfaccion = temp;
                    elegido = req;
                }
                else if (temp == satisfaccion)
                {
                    if (CalcularSumaEsfuerzo(req) < CalcularSumaEsfuerzo(elegido))
                    {
                        satisfaccion = temp;
                        elegido = req;
                    }
                }
            }

            //Buscamos el mejor orden
            Ordenar(elegido);

            Dictionary<DateTimeOffset, List<Requisito>> Resultado = GetSalida(version.Inicio);

            return Resultado;
        }

        private static LinkedList<LinkedList<Requisito>> CalcularCombinaciones(LinkedList<Requisito> lista)
        {
            LinkedList<LinkedList<Requisito>> salida = new LinkedList<LinkedList<Requisito>>();
            IEnumerable<List<Requisito>> result = Enumerable
                .Range(1, (1 << lista.Count) - 1)
                .Select(index => lista.Where((item, idx) => ((1 << idx) & index) != 0)
                .ToList());

            foreach (List<Requisito> list in result)
            {
                LinkedList<Requisito> temp = new LinkedList<Requisito>();
                foreach (Requisito req in list)
                {
                    temp.AddLast(req);
                }
                salida.AddLast(temp);
            }
            return salida;
        }

        private static long CalcularSatisfaccion(Requisito actual)
        {
            long salida = 0;

            for (int i = 0; i < actual.Valoraciones.Count; i++)
            {
                salida += actual.Valoraciones[i] * App.Clientes[i].Importancia;
            }

            return salida;
        }

        private static long CalcularSumaEsfuerzo(LinkedList<Requisito> actual)
        {
            long salida = 0;

            foreach (Requisito temp in actual)
            {
                salida += (temp.Esfuerzo + (1 - temp.Exito) / 100 * temp.Riesgo);
            }

            return salida;
        }

        private static long CalcularSumaSatisfaccion(LinkedList<Requisito> actual)
        {
            long salida = 0;

            foreach (Requisito tmp in actual)
            {
                salida += CalcularSatisfaccion(tmp);
            }

            return salida;
        }

        private static void Clonar(Dictionary<float, List<long>> salida, Dictionary<float, List<long>> entrada)
        {
            salida.Clear();
            Dictionary<float, List<long>>.KeyCollection x = entrada.Keys;
            for (int i = 0; i < x.Count; i++)
            {
                List<long> y = entrada[x.ElementAt(i)];
                if (!salida.ContainsKey(x.ElementAt(i)))
                {
                    salida.Add(x.ElementAt(i), new List<long>() { });
                }

                foreach (long aux in y)
                {
                    salida[x.ElementAt(i)].Add(aux);
                }
            }
        }

        private static void CompararResultado(Dictionary<float, List<long>> candidato)
        {
            float fechaFinTemp = 0;

            Dictionary<float, List<long>>.KeyCollection keys = candidato.Keys;

            long esfuerzo;

            foreach (float key in keys)
            {
                List<long> value = candidato[key];
                foreach (long req in value)
                {
                    esfuerzo = GetRequisito(req).Esfuerzo;
                    if (key + esfuerzo > fechaFinTemp)
                    {
                        fechaFinTemp = key + esfuerzo;
                    }
                }
            }

            //Nos quedamos con el que tarde menos.
            if (fechaFin > fechaFinTemp)
            {
                fechaFin = fechaFinTemp;
                ResultadoTemporal = candidato;
            }
        }

        private static bool Compatible(LinkedList<long> recursosDisponibles, long requisito)
        {
            foreach (Recurso rec in GetRequisito(requisito).Recursos)
            {
                if (!recursosDisponibles.Any(r => r == rec.Id))
                {
                    return false;
                }
            }

            return true;
        }

        private static LinkedList<long> EliminarRecursos(LinkedList<long> recursosDisponibles, long actual)
        {
            Requisito tmp = GetRequisito(actual);
            for (int i = 0; i < tmp.Recursos.Count; i++)
            {
                recursosDisponibles.Remove(tmp.Recursos.ElementAt(i).Id);
            }
            return recursosDisponibles;
        }

        private static Requisito GetRequisito(long _id)
        {
            return ListaRequisitos.First(r => r.Id == _id);
        }

        private static Dictionary<DateTimeOffset, List<Requisito>> GetSalida(DateTimeOffset version)
        {
            List<float> listKeys;
            listKeys = ResultadoTemporal.Keys.ToList();
            List<Requisito> aux;
            Dictionary<DateTimeOffset, List<Requisito>> salida = new Dictionary<DateTimeOffset, List<Requisito>>();

            for (int i = 0; i < listKeys.Count; i++)
            {
                aux = new List<Requisito>();

                foreach (long y in ResultadoTemporal[listKeys[i]])
                {
                    aux.Add(GetRequisito(y));
                }

                salida.Add(version.AddDays((int)(listKeys[i] / Version.EsfuerzoDia))
                                  .AddHours(listKeys[i] % Version.EsfuerzoDia), aux);
            }
            DateTimeOffset posibleKey = version.AddDays((int)(fechaFin / Version.EsfuerzoDia))
                                  .AddHours(fechaFin % Version.EsfuerzoDia);

            if (!salida.ContainsKey(posibleKey))
            {
                salida.Add(posibleKey, new List<Requisito>(0));
            }

            return salida;
        }

        //Devuelve la lista de recursos que se libera
        private static LinkedList<long> LiberarRecursos(long requisito, LinkedList<long> salidaTmp)
        {
            foreach (Recurso recurso in GetRequisito(requisito).Recursos)
            {
                salidaTmp.AddLast(recurso.Id);
            }

            return salidaTmp;
        }

        private static void Ordenar(LinkedList<Requisito> entrada)
        {
            LinkedList<long> entry = new LinkedList<long>();
            foreach (Requisito req in entrada)
            {
                entry.AddLast(req.Id);
            }
            LinkedList<long> rec = new LinkedList<long>();
            foreach (Recurso req in Version.Recursos)
            {
                rec.AddLast(req.Id);
            }

            Ordenar(new Dictionary<float, List<long>>(), new List<long>(), entry, 0, rec);
        }

        //Algoritmo x fuerza bruta con recortes
        private static void Ordenar(Dictionary<float, List<long>> salida, List<long> listaEnProceso, LinkedList<long> listaRestantes, float dia, LinkedList<long> recursosDisponibles)
        {
            //Condicion de salida
            if (listaRestantes.Count() == 0) //Cuando no haya que añadir nada más. se entra aquí
            {
                CompararResultado(salida);
                return;
            }

            List<long> enProcesoTmp = new List<long>();
            Dictionary<float, List<long>> salidaTmp = new Dictionary<float, List<long>>();
            LinkedList<long> restantesTmp = new LinkedList<long>();
            LinkedList<long> recursosTmp = new LinkedList<long>();
            float diaTmp;
            List<long> aux = new List<long>();

            //optimizacion, 2 bucles, uno si están todos los recursos, otro si no están todos
            for (int i = 0; i < listaRestantes.Count; i++)
            {
                long actual = listaRestantes.ElementAt(i);
                Clonar(salidaTmp, salida);

                Clonar(restantesTmp, listaRestantes);

                Clonar(recursosTmp, recursosDisponibles);

                Clonar(enProcesoTmp, listaEnProceso);
                diaTmp = dia;

                //Si hay hueco y se puede utilizar
                if (Compatible(recursosDisponibles, actual) && Realizable(actual, listaRestantes, listaEnProceso))//Comprueba que los recursos disponibles sean válidos para el requisito actual.
                {
                    //añadimos en el par key value temporal
                    if (salidaTmp.ContainsKey(diaTmp))
                    {
                        aux = salidaTmp[diaTmp];
                        aux.Add(actual);
                        salidaTmp[diaTmp] = aux;
                    }
                    else
                    {
                        salidaTmp.Add(dia, new List<long>() { actual });
                    }

                    restantesTmp.Remove(actual);
                    enProcesoTmp.Add(actual);
                    recursosTmp = EliminarRecursos(recursosTmp, actual);

                    Ordenar(salidaTmp, enProcesoTmp, restantesTmp, diaTmp, recursosTmp);
                }
                else //Si no se puede utilizar el hueco/No hay hueco
                {
                    diaTmp = SiguienteDia(salidaTmp, out long aux2, enProcesoTmp);
                    if (aux2 == -1)
                    {
                        continue;
                    }

                    recursosTmp = LiberarRecursos(aux2, recursosTmp); // mira las keys y saca la que tenga antes la fecha de finalizacion. libera todos esos recursos
                    enProcesoTmp.Remove(aux2);
                    Ordenar(salidaTmp, enProcesoTmp, restantesTmp, diaTmp, recursosTmp);
                }
            }
        }

        private static bool Realizable(long actual, LinkedList<long> listaRestantes, List<long> listaEnProceso)
        {
            IEnumerable<long> enumerable = GetRequisito(actual).Relaciones.Select(r => r.Id);

            return enumerable.Intersect(listaRestantes).Count() + enumerable.Intersect(listaEnProceso).Count() == 0;
        }

        //Devuelve el día más cercano al actual
        private static float SiguienteDia(Dictionary<float, List<long>> salidaTmp, out long id_requisito, List<long> enProceso)
        {
            id_requisito = -1; // oTRA VEZ ESTO

            float fechaFinTemp = float.MaxValue;

            for (int i = 0; i < enProceso.Count; i++)
            {
                foreach (float key in salidaTmp.Keys)
                {
                    if (salidaTmp[key].Contains(enProceso.ElementAt(i)))
                    {
                        if (key + GetRequisito(enProceso.ElementAt(i)).Esfuerzo < fechaFinTemp)
                        {
                            fechaFinTemp = key + GetRequisito(enProceso.ElementAt(i)).Esfuerzo;
                            id_requisito = enProceso.ElementAt(i);
                        }
                    }
                }
            }

            return fechaFinTemp;
        }

        private static bool Validar(LinkedList<Requisito> lista, Version version)
        {
            if (CalcularSumaEsfuerzo(lista) > version.MaxEsfuerzo)
            {
                return false;
            }

            long id;

            for (int i = 0; i < lista.Count; i++)
            {
                for (int j = 0; j < lista.ElementAt(i).Relaciones.Count; j++)
                {
                    id = lista.ElementAt(i).Relaciones.ElementAt(j).Id;

                    if (!lista.Any(r => r.Id == id) && ListaRequisitos.Any(r => r.Id == id))
                    {
                        return false;
                    }
                }
            }

            //¿Comprobar obligatorio?

            return true;
        }
    }
}
