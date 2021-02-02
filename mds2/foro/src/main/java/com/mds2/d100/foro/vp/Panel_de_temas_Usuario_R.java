package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;

public class Panel_de_temas_Usuario_R extends Panel_de_temas {
	public Crear_tema crear_tema;

	public Panel_de_temas_Usuario_R(long id_seccion) {
		super(id_seccion);
		panel_de_temas_centro.setVisible(true);
		boton_crear_tema.setVisible(true);

		MyUI.navigator.addView("crear tema", new Crear_tema(id_seccion));
		boton_crear_tema.addClickListener(l -> MyUI.navigator.navigateTo("crear tema"));
	}
}