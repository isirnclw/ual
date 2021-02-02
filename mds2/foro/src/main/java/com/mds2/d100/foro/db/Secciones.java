package com.mds2.d100.foro.db;

import java.util.Date;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Secciones {
	public DB_Main dB_Main = MyUI.db;
	public Seccion[] all = new Seccion[0];

	public long crearSeccion(String titulo, String subtitulo, boolean publica) {
		Seccion nueva = SeccionDAO.createSeccion();

		nueva.setTitulo(titulo);
		nueva.setSubtitulo(subtitulo);
		nueva.setFecha_creacion(new Date().getTime());
		nueva.setNum_mensajes(0);
		nueva.setEliminado(false);

		try {
			nueva.setCreado_por(UsuarioDAO.listUsuarioByQuery("Apodo='admin'", "null")[0]);
			SeccionDAO.save(nueva);
			SeccionDAO.refresh(nueva);
			return SeccionDAO.listSeccionByQuery("titulo='" + titulo + "'", "Fecha_creacion")[0].getIdSeccion();
		} catch (PersistentException e) {
			e.printStackTrace();
			return 1;
		}
	}

	public Seccion[] cargarSecciones() {
		try {
			return all = SeccionDAO.listSeccionByQuery("0=0", "null");
		} catch (PersistentException e) {
			e.printStackTrace();
			return all;
		}
	}

	public void modificarSeccion(long idSeccion, String titulo, String subtitulo, boolean publico) {
		try {
			Seccion s = SeccionDAO.getSeccionByORMID(idSeccion);
			s.setTitulo(titulo);
			s.setSubtitulo(subtitulo);
			s.setOculto(!publico);
			SeccionDAO.save(s);
			SeccionDAO.refresh(s);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Seccion getSeccion(long idSeccion) {
		try {
			return SeccionDAO.getSeccionByORMID(idSeccion);
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public long getIdSeccion(String titulo) {
		if (all.length < 1) {
			cargarSecciones();
		}

		for (Seccion s : all) {
			if (s.getTitulo().contentEquals(titulo)) {
				return s.getIdSeccion();
			}
		}

		return 1;
	}
}