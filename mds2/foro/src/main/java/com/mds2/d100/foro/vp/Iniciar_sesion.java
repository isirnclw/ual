package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.ventana.Iniciar_sesion_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.navigator.View;

public class Iniciar_sesion extends Iniciar_sesion_ventana implements View {
	public Cabecera_Usuario_NR cabecera_Usuario_NR;

	public void recordar_contrsena() {
		MyUI.navigator.navigateTo("recordar_contraseña");
	}

	public void iniciar_sesion() {
		if (MyUI.db.iniciarSesion(text_iniciar_sesion_usuario.getValue(), text_iniciar_sesion_contraseña.getValue())) {
			Interfaz.centralinator(NAVTO.INICIO, true, 1);
		}
	}

	public void validar_inicio_sesion() {
		if (!text_iniciar_sesion_usuario.getValue().isBlank() && !text_iniciar_sesion_contraseña.getValue().isBlank()) {
			iniciar_sesion();
		}
	}

	public Iniciar_sesion() {
		super();
		iniciar_sesion_superior.setVisible(true);
		iniciar_sesion_mitad.setVisible(true);
		iniciar_sesion_inferior.setVisible(true);

		MyUI.navigator.addView("recordar_contraseña", new Recordar_contrasena());

		boton_iniciar_sesion_entrar.addClickListener(l -> validar_inicio_sesion());
		boton_recordar_contrasena.addClickListener(l -> recordar_contrsena());
	}

}