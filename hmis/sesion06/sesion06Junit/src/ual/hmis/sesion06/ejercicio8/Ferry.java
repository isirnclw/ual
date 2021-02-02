package ual.hmis.sesion06.ejercicio8;

import java.util.List;

public class Ferry extends Vehiculo {
	/** Máximo número de pasajeros **/
	private int numPasajeros;
	/** Máximo número de vehiculos **/
	private int numVehiculos;
	/** Máximo peso de los vehículos **/
	private int maxPesoVehiculos;
	/** Lista de los vehículos a bordo **/
	private List<Vehiculo> vehiculos;

	public Ferry(int numPasajeros, int maxNumPasajeros, int numVehiculos, int pesoDescargado, int maxPesoVehiculos,
			List<Vehiculo> vehiculos) {
		super(numPasajeros, 0, pesoDescargado, 50000000);
		this.setNumPasajeros(maxNumPasajeros);
		this.setMaxPesoVehiculos(maxPesoVehiculos);
		this.setVehiculos(vehiculos);
	}

	/** Embarca un vehículo añadiéndolo a la lista **/
	public boolean embarcarVehiculo(Vehiculo v) {
		boolean added = this.getVehiculos().add(v);

		if (this.superadoMaximoPeso() || this.superadoMaximoVehiculos()) {
			this.getVehiculos().remove(v);
			return false;
		}

		return added;
	}

	public int getMaxPesoVehiculos() {
		return maxPesoVehiculos;
	}

	public int getNumPasajeros() {
		return numPasajeros;
	}

	public int getNumVehiculos() {
		return numVehiculos;
	}

	public int getPesoVehiculos() {
		int pesoTotal = 0;

		for (Vehiculo v : vehiculos) {
			pesoTotal += v.getPesoCargado();
		}

		return pesoTotal;
	}

	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}

	public void setMaxPesoVehiculos(int maxPesoVehiculos) {
		this.maxPesoVehiculos = maxPesoVehiculos;
	}

	public void setNumPasajeros(int numPasajeros) {
		this.numPasajeros = numPasajeros;
	}

	public void setNumVehiculos(int numVehiculos) {
		this.numVehiculos = numVehiculos;
	}

	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	/** Verdadero si el peso total de los vehículos supera el máximo **/
	public boolean superadoMaximoPeso() {
		int pesoTotal = this.getPesoVehiculos();
		this.setPesoCargado(pesoTotal + this.getPesoDescargado());
		return pesoTotal > this.getMaxPesoVehiculos();
	}

	/** Verdadero si el número total de los vehículos supera el máximo **/
	public boolean superadoMaximoVehiculos() {
		return this.getVehiculos().size() > this.getNumVehiculos();
	}

	/** Devuelve el número total de vehículos embarcados **/
	public int totalVehiculos() {
		return this.getVehiculos().size();

	}

	/** Verdadero si no hay ningún vehículo **/
	public boolean vacio() {
		return totalVehiculos() == 0;
	}
}
