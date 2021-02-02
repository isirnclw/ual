package ual.hmis.sesion06;

public class Ejercicio3 {
	public String asteriscos(int cantidad) {
		if (cantidad < 0)
			return "número erróneo";
		if (cantidad > 11)
			return "************";

		String stars = "*****";

		for (int i = 5; i < cantidad; i++)
			stars += '*';

		return stars;
	}
}
