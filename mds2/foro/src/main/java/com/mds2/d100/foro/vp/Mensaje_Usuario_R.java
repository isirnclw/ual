package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.server.*;

public class Mensaje_Usuario_R extends Mensaje {
	public Mensaje_Usuario_R(com.mds2.d100.foro.db.Mensaje mensaje) {
		super(mensaje);

		boton_gusta_mensaje.setVisible(true);
		boton_reportar_mensaje.setVisible(true);
		boton_mensaje_responder.setVisible(true);

		boton_mensaje_responder.addClickListener(l -> responder(mensaje));
		boton_mensaje_foto_perfil.addClickListener(l -> imagen_perfil());
		boton_gusta_mensaje.addClickListener(l -> dar_me_gusta());

		boton_gusta_mensaje.setCaption(mensaje.getNum_likes() + " ");
		boton_gusta_mensaje.setIcon(
				new ExternalResource(mensaje.m_gusta_a.contains(DB_Main.session) ? "fonticon://Vaadin-Icons/e6dc"
						: "fonticon://Vaadin-Icons/e6db"));

		if (DB_Main.session != null
				&& (mensaje.getPropietario().equals(DB_Main.session) || DB_Main.session.getImportancia() > 1)) {
			borrar_mensaje.addClickListener(
					l -> MyUI.db.eliminarMensaje(DB_Main.session.getIdUsuario(), mensaje.getIdMensaje()));
		}
	}

	private void responder(com.mds2.d100.foro.db.Mensaje mensaje) {
		Panel_de_mensajes_Usuario_R.respondido = mensaje;
		Panel_de_mensajes_Usuario_R.text.setPlaceholder("Respuesta a @" + mensaje.getPropietario() + "...");
	}

	public Mensaje_Usuario_R(com.mds2.d100.foro.db.Mensaje mensaje, boolean b) {
		super(mensaje, b);

		boton_gusta_mensaje.setVisible(true);
		boton_reportar_mensaje.setVisible(true);
		boton_mensaje_responder.setVisible(true);
		borrar_mensaje.setVisible(false);

		boton_mensaje_responder.addClickListener(l -> Panel_de_mensajes_Usuario_R.respondido = mensaje);
		boton_mensaje_foto_perfil.addClickListener(l -> imagen_perfil());
		boton_gusta_mensaje.addClickListener(l -> dar_me_gusta());

		boton_gusta_mensaje.setCaption(mensaje.getNum_likes() + " ");
		boton_gusta_mensaje.setIcon(
				new ExternalResource(mensaje.m_gusta_a.contains(DB_Main.session) ? "fonticon://Vaadin-Icons/e6dc"
						: "fonticon://Vaadin-Icons/e6db"));

		if (DB_Main.session != null
				&& (mensaje.getPropietario().equals(DB_Main.session) || DB_Main.session.getImportancia() > 1)) {
			borrar_mensaje.addClickListener(
					l -> MyUI.db.eliminarMensaje(DB_Main.session.getIdUsuario(), mensaje.getIdMensaje()));
		}
	}

	public void dar_me_gusta() {
		boolean like = MyUI.db.gustaMensaje(DB_Main.session.getIdUsuario(), actual.getIdMensaje());

		boton_gusta_mensaje.setCaption(actual.getNum_likes() + " ");
		boton_gusta_mensaje
				.setIcon(new ExternalResource(like ? "fonticon://Vaadin-Icons/e6dc" : "fonticon://Vaadin-Icons/e6db"));
	}

	private void imagen_perfil() {
		long idPropietario = actual.getPropietario().getIdUsuario();
		Interfaz.centralinator(NAVTO.PERFIL, DB_Main.session.getIdUsuario() == (idPropietario), idPropietario);
	}

	public void reportar_mensaje() {
		MyUI.db.reportar(DB_Main.session.getIdUsuario(), actual.getIdMensaje());
		boton_reportar_mensaje.setEnabled(false);
	}
}