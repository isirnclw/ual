package com.mds2.d100.foro.vp;

import java.util.Date;

import com.mds2.d100.foro.ventana.Notificacion_ventana;
import com.vaadin.ui.Component;

public class Notificacion extends Notificacion_ventana implements Component {

	public Notificacion(com.mds2.d100.foro.db.Notificacion actual) {
		super();

		label_notificacion_contenido.setValue(actual.getDescripcion());
		label_notificacion_fecha.setValue((new Date(actual.getFecha_creacion()).toString()));
		label_notificacion_titulo.setValue(actual.getTitulo());
		label_notificacion_icono.setValue(actual.getIcono() + "");
	}
}
