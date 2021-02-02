package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;

public class Cabecera_Usuario_NR extends Cabecera {
	public Cabecera_Usuario_NR() {
		super();
		super.cabecera_usuario_nr.setVisible(true);

		MyUI.navigator.addView("iniciar_sesion", new Iniciar_sesion());
		MyUI.navigator.addView("registrarse", new Registrarse());

		boton_iniciar_sesion.addClickListener(l -> MyUI.navigator.navigateTo("iniciar_sesion"));
		boton_registrarse.addClickListener(l -> MyUI.navigator.navigateTo("registrarse"));

	}

}