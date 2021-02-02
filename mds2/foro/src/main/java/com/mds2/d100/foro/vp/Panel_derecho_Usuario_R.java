package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Panel_derecho_Usuario_R extends Panel_derecho {
	public Panel_derecho_Usuario_R() {
		super();
		panel_derecho_conectado.setVisible(true);

		setAmigos();
	}

	public void setAmigos() {
		for (com.mds2.d100.foro.db.Usuario amigo : DB_Main.session.amigos.toArray()) {
			grid_panel_derecho_amigos.addComponent(new Amigo(amigo));
		}
	}
}