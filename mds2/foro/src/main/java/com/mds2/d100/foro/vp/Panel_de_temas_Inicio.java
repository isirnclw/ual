package com.mds2.d100.foro.vp;

import com.vaadin.navigator.View;

public class Panel_de_temas_Inicio extends Panel_de_temas implements View {
	public Panel_de_temas_Inicio(long id) {
		super(id);
		panel_de_temas_centro.setVisible(true);
	}
}