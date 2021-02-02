package ual.hmis.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.asignatura.Alumno;

class Ejercicio6Test {

	@CsvSource({ "-2.2,Error en la nota", "4.4,Suspenso", "6.6,Aprobado", "8.8,Notable", "9.9,Sobresaliente",
			"10.0,Matrícula", "10.1,Error en la nota" })

	@ParameterizedTest(name = "{index} =>  {0} es {1}.")
	void testCalificacion_parametrized(double cal, String result) {
		// Arrange
		Alumno a = new Alumno();
		String was;
		// Act
		was = a.calificacion(cal);
		// Assert
		assertEquals(result, was);
	}

}
