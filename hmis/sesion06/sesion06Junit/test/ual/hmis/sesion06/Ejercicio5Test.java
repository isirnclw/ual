package ual.hmis.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.asignatura.Actividad;
import ual.hmis.asignatura.Alumno;

class Ejercicio5Test {

	@CsvSource({ "6,7,7,20", "-1,5,4,-1", "11,9,9,-1" })

	@ParameterizedTest(name = "Notas de la Actividad {index} =>  {0}, {1}, y {2}.")
	void testCalcularNotaActividad_parametrized(int p1, int p2, int p3, int result) {
		// Arrange
		Alumno a = new Alumno();
		Actividad act1 = new Actividad("A1"), act2 = new Actividad("A1");
		double[] results = new double[2];
		act1.agregarEjercicioCalificado("E1", p1);
		act1.agregarEjercicioCalificado("E2", p2);
		act1.agregarEjercicioCalificado("E3", p3);
		a.getActividadesAsignadas().add(act1);
		a.getActividadesAsignadas().add(act2);
		// Act
		results[0] = a.calcularNotaActividad("A1");
		results[1] = a.calcularNotaActividad("A2");
		// Assert
		assertEquals(result, results[0]);
		assertEquals(-1.0, results[1]);
	}

}
