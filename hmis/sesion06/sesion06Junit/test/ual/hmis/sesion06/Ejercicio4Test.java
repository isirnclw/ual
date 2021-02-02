package ual.hmis.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Ejercicio4Test {

	@CsvSource({ "user,pass,s", "'',pass,", "user,'',",
			"nombredeusuariossuperlagruisimomayorde30caraceteres,pass,sap" })

	@ParameterizedTest(name = "{index} => los caracteres de {0} que están en {1} son: {2}.")
	void testUnion_parametrized(String p1, String p2, String result) {
		// Arrange
		Ejercicio4 e = new Ejercicio4();
		// Act
		// Assert
		assertEquals(result, e.union(p1, p2));
	}

}
