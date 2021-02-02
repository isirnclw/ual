package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Perfil_Usuario_R extends Perfil {
	public void anadir_amigo() {
		MyUI.db.anadirAmigo(DB_Main.session.getIdUsuario(), idUsuario);
	}

	public Perfil_Usuario_R(long id) {
		super(id);

		boton_perfil_amigo.addClickListener(l -> anadir_amigo());
	}
}