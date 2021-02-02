package ual.hmis.ejercicio3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio3Test {

	@CsvSource({ "0,ERROR!", "1,lunes", "2,martes", "3,miércoles", "4,jueves", "5,viernes", "6,sábado", "7,domingo",
			"8,ERROR!" })

	@ParameterizedTest(name = "{index} => El día {0} es {1}")
	void testAsteriscos_parametrized(int dia, String resultado) {
		// Arrange
		Ejercicio3 e = new Ejercicio3();
		// Act
		// Assert
		assertEquals(resultado, e.diaSemana(dia));
	}

}
