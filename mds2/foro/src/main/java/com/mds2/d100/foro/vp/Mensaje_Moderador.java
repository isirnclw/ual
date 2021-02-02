package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.db.Mensaje;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Mensaje_Moderador extends Mensaje_Usuario_P {
	public Mensaje_Moderador(Mensaje mensaje) {
		super(mensaje);

		boton_reportar_mensaje.setVisible(true);

		borrar_mensaje.addClickListener(l -> eliminar_mensaje_ajeno());
	}

	public Mensaje_Moderador(Mensaje mensaje, boolean b) {
		super(mensaje, b);

		boton_reportar_mensaje.setVisible(true);

		borrar_mensaje.addClickListener(l -> eliminar_mensaje_ajeno());
	}

	public void eliminar_mensaje_ajeno() {
		MyUI.db.eliminarMensaje(DB_Main.session.getIdUsuario(), actual.getIdMensaje());
		label_mensaje_descripcion.setValue("[ MENSAJE ELIMINADO ]");
		boton_mensaje_responder1.setVisible(false);
	}
}