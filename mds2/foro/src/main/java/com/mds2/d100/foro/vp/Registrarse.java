package com.mds2.d100.foro.vp;

import java.util.Random;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.ventana.Registrarse_ventana;
import com.vaadin.navigator.View;

public class Registrarse extends Registrarse_ventana implements View {
	public Cabecera_Usuario_NR cabecera_Usuario_NR;

	public void validar_registro() {
		if (!text_registrarse_correo.getValue().strip().isBlank() && !text_registrarse_contraseña.getValue().isBlank()
				&& !text_registrarse_contraseña2.getValue().isBlank()
				&& !text_registrarse_descripcion.getValue().strip().isBlank()
				&& !text_registrarse_nombre.getValue().strip().isBlank()
				&& !text_registrarse_usuario.getValue().strip().isBlank()
				&& text_registrarse_contraseña.getValue().equals(text_registrarse_contraseña2.getValue())) {
			crear_cuenta();
		}
	}

	public void anadir_imagen() {
		throw new UnsupportedOperationException();
	}

	public void cancelar() {
		MyUI.navigator.navigateTo("iniciar_sesion");
	}

	public void crear_cuenta() {
		Random rand = new Random();
		int nat = rand.nextInt();

		while (nat < 10000000) {
			nat = rand.nextInt();
		}

		MyUI.db.crearCuenta(text_registrarse_correo.getValue().strip(), text_registrarse_usuario.getValue().strip(),
				text_registrarse_contraseña.getValue(), "https://www.gravatar.com/avatar/" + nat + "?d=identicon",
				text_registrarse_nombre.getValue().strip(), text_registrarse_descripcion.getValue().strip());
		MyUI.navigator.navigateTo("iniciar_sesion");
	}

	public Registrarse() {
		super();
		registrarse_mitad.setVisible(true);
		registrarse_margen_superior.setVisible(true);
		registrarse_margen_inferior.setVisible(true);

		MyUI.navigator.addView("iniciar_sesion", new Iniciar_sesion());

		boton_registro_aceptar.addClickListener(l -> validar_registro());
		boton_registro_atras.addClickListener(l -> cancelar());
	}
}