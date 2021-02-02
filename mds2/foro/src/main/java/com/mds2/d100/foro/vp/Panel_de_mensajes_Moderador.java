package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;

public class Panel_de_mensajes_Moderador extends Panel_de_mensajes_Usuario_P {
	public void eliminar_tema_ajeno() {
		MyUI.db.eliminarTema(tema.getIdTema());
	}

	public Panel_de_mensajes_Moderador(long id) {
		super(id);
		panel_de_mensajes_like.setVisible(true);
		panel_de_mensajes_report.setVisible(true);
		panel_de_mensajes_mod.setVisible(true);
		panel_enviar_mensaje.setVisible(true);
	}

}