package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.ventana.Agregar_multimedia_ventana;

public class Agregar_multimedia extends Agregar_multimedia_ventana {
	public static String[] Urls = new String[4];

	public Agregar_multimedia() {
		boton_agregar_aceptar.addClickListener(l -> aceptar());
	}

	private void aceptar() {
		Urls[0] = text_agregar_video.getValue().strip();
		Urls[1] = text_agregar_imagen1.getValue().strip();
		Urls[2] = text_agregar_imagen2.getValue().strip();
		Urls[3] = text_agregar_imagen3.getValue().strip();
	}
}
