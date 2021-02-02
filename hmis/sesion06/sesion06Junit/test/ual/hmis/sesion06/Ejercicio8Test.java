package ual.hmis.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.sesion06.ejercicio8.Ferry;
import ual.hmis.sesion06.ejercicio8.Vehiculo;

class Ejercicio8Test {

	@CsvSource({ "400,500,380" })

	@ParameterizedTest(name = "{index} => hay un ferry para {0} personas con capacidad para [1] Kg de vehículos. Ahora mismo hay {2} personas a bordo.")
	void testFerry_parametrized(String maxPasajeros, String cargado, String numPasajeros) {
		// Arrange
		boolean[] results = new boolean[5];
		int[] values = new int[] { Integer.parseInt(maxPasajeros), Integer.parseInt(cargado),
				Integer.parseInt(numPasajeros) };
		Ferry f = new Ferry(values[2], values[0], 0, 0, values[1], new ArrayList<Vehiculo>());
		Vehiculo v = new Vehiculo(1, 2, 1000, 800);
		// Act
		results[0] = f.vacio();
		results[1] = f.embarcarVehiculo(v);
		f.setMaxPesoVehiculos(5000);
		results[2] = f.superadoMaximoPeso();
		results[3] = f.embarcarVehiculo(v);
		f.getVehiculos().add(v);
		results[4] = f.superadoMaximoVehiculos();
		f.getVehiculos().remove(0);
		f.setNumVehiculos(1);
		// Assert
		assertEquals(values[0], f.getNumPasajeros());
		assertEquals(true, results[0]);
		assertEquals(false, results[1]);
		assertEquals(false, results[2]);
		assertEquals(false, results[3]);
		assertEquals(true, results[4]);
		assertEquals(true, f.embarcarVehiculo(v));
		assertEquals(false, f.vacio());
		assertEquals(false, f.superadoMaximoVehiculos());
	}

	@CsvSource({ "4,4,2000,1400", "7,4,2300,1800", "2,4,1400,1100", "1,2,230,180" })

	@ParameterizedTest(name = "{index} => hay un vehículo para {0} personas con {1} ruedas y un peso cargado/descargado de {2}/{3} Kg.")
	void testVehiculo_parametrized(String pasajeros, String ruedas, String cargado, String descargado) {
		// Arrange
		int[] values = new int[] { Integer.parseInt(pasajeros), Integer.parseInt(ruedas), Integer.parseInt(cargado),
				Integer.parseInt(descargado) };
		Vehiculo v = new Vehiculo(values[0], values[1], values[2], values[3]);
		// Act
		// Assert
		assertEquals(values[0], v.getNumPasajeros());
		assertEquals(values[1], v.getNumRuedas());
		assertEquals(values[2], v.getPesoCargado());
		assertEquals(values[3], v.getPesoDescargado());
	}

}
