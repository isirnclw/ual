package com.mds2.d100.foro.db;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Imagenes {
	public DB_Main dB_Main = MyUI.db;
	public Imagen[] all = new Imagen[0];

	public long subirImagen(String url, long idMensaje, long idUsuario, String text) {
		Imagen i = ImagenDAO.createImagen();
		Mensaje m;

		try {
			m = MensajeDAO.getMensajeByORMID(idMensaje);
		} catch (PersistentException e) {
			e.printStackTrace();
			m = MensajeDAO.createMensaje();
		}

		try {
			i.setUsuario(UsuarioDAO.getUsuarioByORMID(idUsuario));
			i.setUrl(url);
			m.imagenes.add(i);
			ImagenDAO.save(i);
			ImagenDAO.refresh(i);
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

		return i.getIdImagen();
	}
}