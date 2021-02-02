package ual.hmis.asignatura;

import java.util.ArrayList;

public class Alumno {

	private String nombre;
	private ArrayList<Actividad> actividadesAsignadas;

	public Alumno() {
		this.setNombre("?");
		this.setActividadesAsignadas(new ArrayList<Actividad>());
	}

	public double calcularNotaActividad(String nombreActividad) {
		double resultado = -1.0;

		for (Actividad act : actividadesAsignadas) {
			if (act.getNombre().equals(nombreActividad)) {
				resultado = .0;

				for (Ejercicio ej : act.getEjercicios()) {
					if (ej.getPuntuacion() < .0 || ej.getPuntuacion() > 10.0) {
						return -1.0;
					} else {
						resultado += ej.getPuntuacion();
					}
				}

				act.setPuntuacionTotal(resultado);
				break;
			}
		}

		return resultado;
	}

	public String calificacion(double nota) {
		if (nota < 0 || nota > 10) {
			return "Error en la nota";
		}
		if (nota < 5) {
			return "Suspenso";
		}
		if (nota < 7) {
			return "Aprobado";
		}
		if (nota < 9) {
			return "Notable";
		}
		if (nota < 10) {
			return "Sobresaliente";
		}

		return "Matrícula";
	}

	public String cursoSegunEdad(int anyoNacimiento) {
		switch (anyoNacimiento) {
		case 2005:
			return "4º Educación Secundaria";
		case 2006:
			return "3º Educación Secundaria";
		case 2007:
			return "2º Educación Secundaria";
		case 2008:
			return "1º Educación Secundaria";
		case 2009:
			return "6º Educación Primaria";
		case 2010:
			return "5º Educación Primaria";
		case 2011:
			return "4º Educación Primaria";
		case 2012:
			return "3º Educación Primaria";
		case 2013:
			return "2º Educación Primaria";
		case 2014:
			return "1º Educación Primaria";
		case 2015:
			return "3º Educación Infantil";
		case 2016:
			return "2º Educación Infantil";
		case 2017:
			return "1º Educación Infantil";
		default:
			return "No contemplado";
		}
	}

	public ArrayList<Actividad> getActividadesAsignadas() {
		return actividadesAsignadas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setActividadesAsignadas(ArrayList<Actividad> actividadesAsignadas) {
		this.actividadesAsignadas = actividadesAsignadas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
