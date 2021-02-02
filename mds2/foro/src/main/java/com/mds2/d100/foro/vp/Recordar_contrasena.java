package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.ventana.Recordad_contraseña_ventana;
import com.vaadin.navigator.View;

public class Recordar_contrasena extends Recordad_contraseña_ventana implements View {
	public Iniciar_sesion iniciar_sesion;

	public void atras() {
		MyUI.navigator.navigateTo("iniciar_sesion");
	}

	public void recordar() {
		MyUI.db.recordarContrasena(text_recordar_contraseña_usuario.getValue(),
				text_recordar_contraseña_correo.getValue());
		MyUI.navigator.navigateTo("iniciar_sesion");
	}

	public void validar_recordatorio() {
		if (!text_recordar_contraseña_correo.getValue().isBlank()
				&& !text_recordar_contraseña_usuario.getValue().isBlank()) {
			recordar();
		}
	}

	public Recordar_contrasena() {
		super();
		recordar_superior.setVisible(true);
		recordar_mitad.setVisible(true);
		recordar_inferior.setVisible(true);

		boton_retroceder_recordar.addClickListener(l -> atras());
		boton_recordar_aceptar.addClickListener(l -> validar_recordatorio());
	}

}