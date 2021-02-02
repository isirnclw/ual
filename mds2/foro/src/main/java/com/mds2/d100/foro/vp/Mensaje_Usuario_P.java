package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.db.Mensaje;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Mensaje_Usuario_P extends Mensaje_Usuario_R {

	public Mensaje_Usuario_P(Mensaje mensaje) {
		super(mensaje);

		boton_reportar_mensaje.setVisible(false);
		boton_mensaje_responder.setVisible(true);
		borrar_mensaje.setVisible(true);

		borrar_mensaje.addClickListener(l -> eliminar_mensaje_propio());
	}

	public Mensaje_Usuario_P(Mensaje mensaje, boolean b) {
		super(mensaje, b);

		boton_reportar_mensaje.setVisible(false);
		boton_mensaje_responder.setVisible(true);
		borrar_mensaje.setVisible(true);

		borrar_mensaje.addClickListener(l -> eliminar_mensaje_propio());
	}

	public void eliminar_mensaje_propio() {
		if (DB_Main.session.getIdUsuario() == actual.getIdMensaje()) {
			MyUI.db.eliminarMensaje(DB_Main.session.getIdUsuario(), actual.getIdMensaje());
			label_mensaje_descripcion.setValue("[ MENSAJE ELIMINADO ]");
			boton_mensaje_responder1.setVisible(false);
		}
	}
}