package ual.hmis.sesion06;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import ual.hmis.asignatura.Alumno;

class Ejercicio7Test {

	@CsvSource({ "2004,No contemplado", "2005,4º Educación Secundaria", "2006,3º Educación Secundaria",
			"2007,2º Educación Secundaria", "2008,1º Educación Secundaria", "2009,6º Educación Primaria",
			"2010,5º Educación Primaria", "2011,4º Educación Primaria", "2012,3º Educación Primaria",
			"2013,2º Educación Primaria", "2014,1º Educación Primaria", "2015,3º Educación Infantil",
			"2016,2º Educación Infantil", "2017,1º Educación Infantil", "2018,No contemplado" })

	@ParameterizedTest(name = "{index} =>  Nacido en {0} => {1}.")
	void testCursoSegunEdad_parametrized(int anyoNac, String result) {
		// Arrange
		Alumno a = new Alumno();
		String was;
		// Act
		was = a.cursoSegunEdad(anyoNac);
		// Assert
		assertEquals(result, was);
	}

}
