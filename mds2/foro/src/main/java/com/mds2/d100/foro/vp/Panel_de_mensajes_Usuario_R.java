package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.vaadin.ui.TextField;

public class Panel_de_mensajes_Usuario_R extends Panel_de_mensajes {
	public static com.mds2.d100.foro.db.Mensaje respondido;
	public static String respuesta;
	public static long[] idMultimedia = new long[3];
	public static boolean hayVideo;
	public static TextField text;

	public void enviar_mensaje() {
		long u = DB_Main.session.getIdUsuario();

		if (respondido == null) {
			MyUI.db.crearMensaje(idTema, u, respuesta, hayVideo, idMultimedia[0], idMultimedia[1], idMultimedia[2]);
		} else {
			long m = respondido.getIdMensaje();
			MyUI.db.responder(u, m, respuesta, hayVideo, idMultimedia[0], idMultimedia[1], idMultimedia[2]);
		}

		text_mensaje.setValue("Enviando...");
		text_mensaje.setEnabled(false);

		setMensajesDe(idTema);

		text_mensaje.setValue("");
		text_mensaje.setEnabled(true);
	}

	public void subir_multimedia(Mensaje mensaje) {
		String v0 = Agregar_multimedia.Urls[0];
		String i1 = Agregar_multimedia.Urls[1];
		String i2 = Agregar_multimedia.Urls[2];
		String i3 = Agregar_multimedia.Urls[3];

		if (!v0.isBlank()) {
			hayVideo = true;

			idMultimedia[0] = MyUI.db.subirMultimedia((byte) 2, mensaje.actual.getIdMensaje(),
					DB_Main.session.getIdUsuario(), v0,
					"Vídeo subido por " + DB_Main.session.getApodo() + " en \"" + tema.getTitulo() + "\".");
		} else {
			hayVideo = false;

			if (!i1.isBlank()) {
				idMultimedia[0] = MyUI.db.subirMultimedia((byte) 1, mensaje.actual.getIdMensaje(),
						DB_Main.session.getIdUsuario(), i1,
						"Imagen subida por " + DB_Main.session.getApodo() + " en \"" + tema.getTitulo() + "\".");
			}
			if (!i2.isBlank()) {
				idMultimedia[1] = MyUI.db.subirMultimedia((byte) 1, mensaje.actual.getIdMensaje(),
						DB_Main.session.getIdUsuario(), i2,
						"Imagen subida por " + DB_Main.session.getApodo() + " en \"" + tema.getTitulo() + "\".");
			}
			if (!i3.isBlank()) {
				idMultimedia[2] = MyUI.db.subirMultimedia((byte) 1, mensaje.actual.getIdMensaje(),
						DB_Main.session.getIdUsuario(), i3,
						"Imagen subida por " + DB_Main.session.getApodo() + " en \"" + tema.getTitulo() + "\".");
			}
		}
	}

	public void reportar() {
		MyUI.db.reportarTema(tema.getIdTema());
	}

	public void dar_me_gusta() {
		MyUI.db.gustaTema(DB_Main.session.getIdUsuario(), tema.getIdTema(), !tema.t_gusta_a.contains(DB_Main.session));
	}

	public Panel_de_mensajes_Usuario_R(long id) {
		super(id);
		
		panel_de_mensajes_like.setVisible(true);
		panel_de_mensajes_report.setVisible(true);
		panel_enviar_mensaje.setVisible(true);

		text = text_mensaje;
		
		panel_de_mensajes_like.addClickListener(l -> dar_me_gusta());
		panel_de_mensajes_report.addClickListener(l -> reportar());
		text_mensaje.addValueChangeListener(l -> respuesta = l.getValue());
		boton_mensaje_enviar.addClickListener(l -> enviar_mensaje());

		// boton_mensaje_multimedia.addClickListener(l ->
		// Interfaz.centralinator(NAVTO.MULTIMEDIA, true, null));
	}
}