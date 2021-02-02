package com.mds2.d100.foro.db;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Videos {
	public DB_Main dB_Main = MyUI.db;
	public Video[] all = new Video[0];

	public long subirVideo(String url, long idMensaje, long idUsuario, String text) {
		Video i = VideoDAO.createVideo();
		Mensaje m;

		try {
			m = MensajeDAO.getMensajeByORMID(idMensaje);
		} catch (PersistentException e) {
			e.printStackTrace();
			m = MensajeDAO.createMensaje();
		}

		try {
			i.setUrl(url);
			m.setVideo(i);
			VideoDAO.save(i);
			VideoDAO.refresh(i);
		} catch (PersistentException e) {
			e.printStackTrace();
			return 0;
		}

		try {
			MensajeDAO.save(m);
			MensajeDAO.refresh(m);
		} catch (PersistentException e) {
			e.printStackTrace();
			try {
				MensajeDAO.save(m);
				MensajeDAO.refresh(m);
			} catch (PersistentException e1) {
				e1.printStackTrace();
				return 0;
			}
		}

		return i.getIdVideo();
	}
}