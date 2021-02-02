package ual.hmis.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio3Test {

	@CsvSource({ "-1,número erróneo", "4,*****", "5,*****", "6,******", "11,***********", "12,************",
			"13,************" })

	@ParameterizedTest(name = "{index} => Con cantidad {0} => {1}")
	void testAsteriscos_parametrized(String cantidad, String resultado) {
		// Arrange
		Ejercicio3 e = new Ejercicio3();
		// Act
		// Assert
		assertEquals(resultado, e.asteriscos(Integer.parseInt(cantidad)));
	}

}
