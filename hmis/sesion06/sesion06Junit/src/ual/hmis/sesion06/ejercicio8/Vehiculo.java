package ual.hmis.sesion06.ejercicio8;

public class Vehiculo {
	private int numPasajeros;
	private int numRuedas;
	private int pesoCargado;
	private int pesoDescargado;

	public Vehiculo(int numPasajeros, int numRuedas, int pesoCargado, int pesoDescargado) {
		super();
		this.setNumPasajeros(numPasajeros);
		this.setNumRuedas(numRuedas);
		this.setPesoCargado(pesoCargado);
		this.setPesoDescargado(pesoDescargado);
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public int getPesoCargado() {
		return pesoCargado;
	}

	public int getPesoDescargado() {
		return pesoDescargado;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}

	public void setPesoCargado(int pesoCargado) {
		this.pesoCargado = pesoCargado;
	}

	public void setPesoDescargado(int pesoDescargado) {
		this.pesoDescargado = pesoDescargado;
	}

}
