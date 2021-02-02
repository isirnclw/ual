package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Perfil_Moderador extends Perfil_Usuario_R {
	public void notificar_al_administrador() {
		MyUI.db.notificarAdminSobreUsuario(DB_Main.session.getIdUsuario(), idUsuario);
	}

	public void restringir_acceso() {
		MyUI.db.restringirAcceso(idUsuario);
	}

	public Perfil_Moderador(long id) {
		super(id);

		boton_perfil_notificar.setVisible(true);
		tab_perfil_usuario.getTab(2).setVisible(false);

		boton_perfil_notificar.addClickListener(l -> notificar_al_administrador());
		boton_perfil_restringir.addClickListener(l -> restringir_acceso());
	}
}