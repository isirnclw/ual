package com.mds2.d100.foro.db;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Notificaciones {
	public DB_Main dB_Main = MyUI.db;
	public Notificacion[] all = new Notificacion[0];

	public Notificacion[] cargarNotificaciones(long idUsuario) {
		try {
			return NotificacionDAO.listNotificacionByQuery("UsuarioIdUsuario='" + idUsuario + "'", "null");
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Notificacion[0];
		}
	}
}