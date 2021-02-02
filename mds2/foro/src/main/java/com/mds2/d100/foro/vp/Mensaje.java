package com.mds2.d100.foro.vp;

import java.util.Date;

import com.mds2.d100.foro.ventana.Mensaje_ventana;
import com.vaadin.server.ExternalResource;

public class Mensaje extends Mensaje_ventana {
	public com.mds2.d100.foro.db.Mensaje actual;

	public Mensaje(com.mds2.d100.foro.db.Mensaje mensaje) {
		super();

		boton_gusta_mensaje.setVisible(false);
		boton_reportar_mensaje.setVisible(false);
		boton_mensaje_responder.setVisible(false);
		borrar_mensaje.setVisible(false);

		this.actual = mensaje;

		label_mensaje_nombre.setValue(mensaje.getPropietario().getApodo());
		label_mensaje_fecha.setValue(new Date(mensaje.getFecha_creacion()).toString());
		label_mensaje_descripcion.setValue(mensaje.getTexto());
		boton_mensaje_foto_perfil
				.setIcon(new ExternalResource(mensaje.getPropietario().getFotoPerfil().getUrl() + "&s=36"));
	}

	public Mensaje(com.mds2.d100.foro.db.Mensaje mensaje, boolean b) {
		super();

		boton_gusta_mensaje.setVisible(false);
		boton_reportar_mensaje.setVisible(false);
		borrar_mensaje.setVisible(false);

		this.actual = mensaje;

		label_mensaje_nombre.setValue(mensaje.getPropietario().getApodo());
		label_mensaje_fecha.setValue(new Date(mensaje.getFecha_creacion()).toString());
		label_mensaje_descripcion.setValue(mensaje.getTexto());
		boton_mensaje_foto_perfil.setIcon(new ExternalResource(mensaje.getPropietario().getFotoPerfil().getUrl()));
		boton_mensaje_responder.setVisible(b);
	}
}