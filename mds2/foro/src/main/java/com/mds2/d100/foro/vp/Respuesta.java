package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.vaadin.shared.ui.MarginInfo;

public class Respuesta extends Mensaje_Moderador {
	public Respuesta(com.mds2.d100.foro.db.Mensaje mensaje) {
		super(mensaje);

		if (DB_Main.session == null) {
			boton_mensaje_responder1.setVisible(false);
		} else if (mensaje.getPropietario().getIdUsuario() == DB_Main.session.getIdUsuario()) {
			boton_reportar_mensaje.setVisible(false);
			borrar_mensaje.addClickListener(l -> eliminar_mensaje_propio());
		} else if (DB_Main.session.getImportancia() == 1) {
			borrar_mensaje.setVisible(false);
		}

		setMargin(new MarginInfo(false, false, false, true));
	}

	public Respuesta(com.mds2.d100.foro.db.Mensaje mensaje, boolean isProfile) {
		super(mensaje);

		boton_mensaje_responder1.setVisible(false);
		setMargin(new MarginInfo(false, false, false, true));
	}
}