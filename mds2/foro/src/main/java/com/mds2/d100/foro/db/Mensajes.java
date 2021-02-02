package com.mds2.d100.foro.db;

import java.util.Date;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Mensajes {
	public DB_Main dB_Main = MyUI.db;
	public Mensaje[] all = new Mensaje[0];

	public Mensaje[] cargarMensajes(long idTema) {
		try {
			return TemaDAO.getTemaByORMID(idTema).mensajesTema.toArray();
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Mensaje[0];
		}
	}

	public Mensaje[] cargarMensajes(long idUsuario, long max) {
		try {
			return MensajeDAO.getMensajeByORMID(idUsuario).respuestas.toArray();
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Mensaje[0];
		}
	}

	public void eliminarMensaje(long idUsuario, long idMensaje) {
		try {
			Mensaje m = MensajeDAO.getMensajeByORMID(idMensaje);
			m.setEliminado(true);
			MensajeDAO.save(m);
			MensajeDAO.refresh(m);
			System.out.println("Mensaje " + idMensaje + " eliminado por " + idUsuario + ".");
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void reportar(long fromIdUsuario, long toIdMensaje) {
		try {
			Notificacion n = NotificacionDAO.createNotificacion();
			Usuario mod = UsuarioDAO.getUsuarioByORMID(fromIdUsuario);
			Mensaje ban = MensajeDAO.getMensajeByORMID(toIdMensaje);

			n.setEnviada_a(UsuarioDAO.listUsuarioByQuery("Apodo='admin'", "null")[0]);
			n.setFecha_creacion(new Date().getTime());
			n.setIcono('!');
			n.setTitulo("Petición de moderación");
			n.setDescripcion("El moderador '" + mod.getApodo() + "' ha solicitado moderación para '"
					+ ban.getPropietario() + "' por el cotenido del mensaje:\n.'" + ban.getTexto() + "'.");

			NotificacionDAO.save(n);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void responder(long idUsuario, long idMensaje, String mensaje, boolean hayVideo, long idMultimedia_1,
			long idImagen_2, long idImagen_3) {
		try {
			Mensaje m = MensajeDAO.getMensajeByORMID(idMensaje);
			long r = MyUI.db.crearMensaje(m.getPertenece_a().getIdTema(), idUsuario, mensaje, hayVideo, idMultimedia_1,
					idImagen_2, idImagen_3);

			m.respuestas.add(MensajeDAO.getMensajeByORMID(r));

			MensajeDAO.save(m);
			MensajeDAO.refresh(m);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}