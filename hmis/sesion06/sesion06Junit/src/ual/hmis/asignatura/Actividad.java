package ual.hmis.asignatura;

import java.util.ArrayList;

public class Actividad {

	private String nombre; // nombre de la actividad
	private ArrayList<Ejercicio> ejercicios;
	private boolean apta;
	private double puntuacionTotal;

	public Actividad(String nombre) {
		this.setNombre(nombre);
		this.setEjercicios(new ArrayList<Ejercicio>());
	}

	public void agregarEjercicioCalificado(String nombreEjercicio, double puntuacion) {

		Ejercicio nuevoEjercicio = new Ejercicio();

		nuevoEjercicio.setNombre(nombreEjercicio);
		nuevoEjercicio.setPuntuacion(puntuacion);

		ejercicios.add(nuevoEjercicio);
	}

	public ArrayList<Ejercicio> getEjercicios() {
		return ejercicios;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPuntuacionTotal() {
		return this.puntuacionTotal;
	}

	public boolean isApta() {
		return apta;
	}

	public void setApta(boolean apta) {
		this.apta = apta;
	}

	public void setEjercicios(ArrayList<Ejercicio> ejercicios) {
		this.ejercicios = ejercicios;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPuntuacionTotal(double value) {
		this.puntuacionTotal = value;
	}

}
