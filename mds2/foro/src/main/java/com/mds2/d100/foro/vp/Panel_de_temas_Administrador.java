package com.mds2.d100.foro.vp;

import com.vaadin.navigator.View;

public class Panel_de_temas_Administrador extends Panel_de_temas_Usuario_R implements View {

	public Panel_de_temas_Administrador(long id_seccion) {
		super(id_seccion);
		panel_de_temas_centro.setVisible(true);
		boton_crear_tema.setVisible(true);
	}
}