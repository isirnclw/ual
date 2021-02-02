package ual.hmis.sesion06;

public class Ejercicio4 {
	public String union(String P1, String P2) {
		if (P1.length() > 0 && P2.length() > 0) {
			String union = "";

			for (char ch : P1.toCharArray()) {
				if (P2.indexOf(ch) > -1 && union.indexOf(ch) == -1)
					union += ch;
			}

			return union;
		}

		return null;
	}
}
