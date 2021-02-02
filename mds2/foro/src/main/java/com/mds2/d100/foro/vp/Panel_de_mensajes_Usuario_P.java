package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Panel_de_mensajes_Usuario_P extends Panel_de_mensajes_Usuario_R {
	public void eliminar_tema_propio() {
		if (tema.getCreado_por().equals(DB_Main.session)) {
			MyUI.db.eliminarTema(tema.getIdTema());
		}
	}

	public Panel_de_mensajes_Usuario_P(long id) {
		super(id);
		panel_de_mensajes_like.setVisible(true);
		panel_de_mensajes_report.setVisible(true);
		panel_de_mensajes_mod.setVisible(true);
		panel_enviar_mensaje.setVisible(true);

		panel_de_mensajes_mod.addClickListener(l -> modificar());
	}

	private void modificar() {
		MyUI.navigator.addView("modificar_tema", new Modificar_tema(idTema));
		MyUI.navigator.navigateTo("modificar_tema");
	}
}