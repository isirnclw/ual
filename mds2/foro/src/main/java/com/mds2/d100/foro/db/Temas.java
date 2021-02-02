package com.mds2.d100.foro.db;

import java.util.Date;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Temas {
	public DB_Main dB_Main = MyUI.db;
	public Tema[] all = new Tema[0];

	public void cambiarVisibilidad(long idTema, boolean publico) {
		try {
			Tema t = TemaDAO.getTemaByORMID(idTema);
			t.setOculto(!publico);
			TemaDAO.save(t);
			TemaDAO.refresh(t);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public long crearMensaje(long idTema, long idUsuario, String mensaje, long idMultimedia_1, long idImagen_2,
			long idImagen_3) {
		Mensaje nuevo = MensajeDAO.createMensaje();
		Usuario autor;
		Tema aux;

		try {
			autor = UsuarioDAO.getUsuarioByORMID(idUsuario);
			nuevo.setFecha_creacion(new Date().getTime());
			nuevo.setNum_likes(0);
			nuevo.setTexto(mensaje);
			nuevo.setPertenece_a(TemaDAO.getTemaByORMID(idTema));
			nuevo.setPropietario(autor);

			if (0 == idMultimedia_1 == (idImagen_3 == idImagen_2)) {
				for (Imagen i : ImagenDAO.listImagenByQuery("0=0", "null")) {
					if (i.getIdImagen() == idMultimedia_1 || i.getIdImagen() == idImagen_2
							|| i.getIdImagen() == idImagen_3) {
						nuevo.imagenes.add(i);
						break;
					}
				}

				if (nuevo.imagenes.size() == 0) {
					for (Video v : VideoDAO.listVideoByQuery("0=0", "null")) {
						if (v.getIdVideo() == idMultimedia_1) {
							v.mensaje.add(nuevo);
							nuevo.setVideo(v);
							break;
						}
					}
				}
			}

			autor.mensajes.add(nuevo);
			aux = nuevo.getPertenece_a();
			aux.setFecha_ult_mens(nuevo.getFecha_creacion());
			aux.getSeccion().setNum_mensajes(aux.getSeccion().getNum_mensajes() + 1);

			MensajeDAO.save(nuevo);
			TemaDAO.save(aux);
			UsuarioDAO.save(autor);
			MensajeDAO.refresh(nuevo);
			TemaDAO.refresh(aux);
			UsuarioDAO.refresh(autor);
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return nuevo.getIdMensaje();
	}

	public long crearTema(String titulo, String subtitulo, char icono, boolean visible, long byIdUsuario,
			long idSeccion) {
		try {
			Tema nuevo = TemaDAO.createTema();
			Seccion s = SeccionDAO.getSeccionByORMID(idSeccion);

			nuevo.setTitulo(titulo);
			nuevo.setSubtitulo(subtitulo);
			nuevo.setIcono(icono);
			nuevo.setCreado_por(UsuarioDAO.getUsuarioByORMID(byIdUsuario));
			nuevo.setSeccion(s);
			nuevo.setAutor_ult_mens(nuevo.getCreado_por().getApodo());
			nuevo.setEliminado(false);
			nuevo.setFecha_creacion(new Date().getTime());
			nuevo.setNum_likes(0);
			nuevo.setOculto(!visible);

			s.temas.add(nuevo);

			TemaDAO.save(nuevo);
			SeccionDAO.save(s);
			TemaDAO.refresh(nuevo);
			SeccionDAO.refresh(s);

			return TemaDAO.listTemaByQuery("titulo='" + titulo + "'", "Fecha_creacion")[0].getIdTema();
		} catch (PersistentException e) {
			e.printStackTrace();
			return 1;
		}
	}

	public Tema[] cargarTemasRecientes(long idSeccion) {
		try {
			return TemaDAO.listTemaByQuery("SeccionidSeccion=" + idSeccion, "Fecha_ult_mens DESC");
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Tema[0];
		}
	}

	public Tema[] cargarTemasRelevantes(long idSeccion) {
		try {
			return TemaDAO.listTemaByQuery("SeccionidSeccion=" + idSeccion, "Num_likes DESC");
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Tema[0];
		}
	}

	public void modificarTema(long idTema, String titulo, String subtitulo, char icono, boolean publico) {
		try {
			Tema t = TemaDAO.getTemaByORMID(idTema);
			t.setTitulo(titulo);
			t.setSubtitulo(subtitulo);
			t.setIcono(icono);
			cambiarVisibilidad(idTema, publico);
			TemaDAO.save(t);
			TemaDAO.refresh(t);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Mensaje[] cargarMensajes(long idTema) {
		try {
			return TemaDAO.getTemaByORMID(idTema).mensajesTema.toArray();
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Mensaje[0];
		}
	}

	public Tema getTema(long id) {
		try {
			return TemaDAO.getTemaByORMID(id);
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void eliminarTema(long idTema) {
		try {
			TemaDAO.getTemaByORMID(idTema).setEliminado(true);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void reportarTema(long idTema) {
		try {
			TemaDAO.getTemaByORMID(idTema).setOculto(true);
			System.out.println("Tema con identificador '" + idTema + "' reportado.");
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}