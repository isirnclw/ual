package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;

public class Perfil_Administrador extends Perfil_Usuario_R {
	public void ascender_a_moderador() {
		MyUI.db.ascenderAModerador(idUsuario);
	}

	public Perfil_Administrador(long id) {
		super(id);

		boton_perfil_ascender.setVisible(true);
		boton_perfil_restringir.setVisible(true);
		tab_perfil_usuario.getTab(2).setVisible(false);

		boton_perfil_ascender.addClickListener(l -> ascender_a_moderador());
	}
}