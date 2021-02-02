package com.mds2.d100.foro.vp;

import java.util.Date;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Panel_de_mensajes_ventana;
import com.vaadin.server.ExternalResource;

public class Panel_de_mensajes extends Panel_de_mensajes_ventana {
	public com.mds2.d100.foro.db.Tema tema;
	public long idTema;

	public Panel_de_mensajes(long id) {
		super();

		panel_de_mensajes_like.setVisible(false);
		panel_de_mensajes_mod.setVisible(false);
		panel_de_mensajes_report.setVisible(false);
		image_panel_de_mensajes.setVisible(true);
		panel_enviar_mensaje.setVisible(false);

		this.tema = MyUI.db.getTema(id);
		this.idTema = id;

		label_panel_de_mensajes_titulo.setValue(tema.getTitulo());
		label_panel_de_mensajes_contenido.setValue(tema.getSubtitulo());
		label_panel_de_mensajes_fecha.setValue(new Date(tema.getFecha_creacion()).toString());
		label_panel_de_mensajes_nombre.setValue(tema.getCreado_por().getApodo());
		image_panel_de_mensajes.setSource(new ExternalResource(tema.getCreado_por().getFotoPerfil().getUrl()));

		setMensajesDe(id);
	}

	public void setMensajesDe(long id) {
		grid_panel_mensajes.removeAllComponents();

		for (com.mds2.d100.foro.db.Mensaje mensaje : MyUI.db.cargarMensajes(true, id)) {
			if (mensaje.getEliminado() == false) {
				if (mensaje.getRespondido() == null || mensaje.getRespondido().getIdMensaje() == 0) {
					if (DB_Main.session == null || DB_Main.session.getImportancia() == 0) {
						grid_panel_mensajes.addComponent(new Mensaje(mensaje));
					} else if (DB_Main.session.getIdUsuario() == mensaje.getPropietario().getIdUsuario()) {
						grid_panel_mensajes.addComponent(new Mensaje_Usuario_P(mensaje));
					} else if (DB_Main.session.getImportancia() == 1) {
						grid_panel_mensajes.addComponent(new Mensaje_Usuario_R(mensaje));
					} else if (DB_Main.session.getImportancia() > 1) {
						grid_panel_mensajes.addComponent(new Mensaje_Moderador(mensaje));
					}

					for (com.mds2.d100.foro.db.Mensaje respuesta : mensaje.respuestas.toArray()) {
						grid_panel_mensajes.addComponent(new Respuesta(respuesta));
					}
				}
			}
		}
	}
}