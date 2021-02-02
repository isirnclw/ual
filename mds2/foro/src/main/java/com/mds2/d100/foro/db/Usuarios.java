package com.mds2.d100.foro.db;

import java.awt.Desktop;
import java.net.URI;
import java.util.Date;
import java.util.Random;

import org.orm.PersistentException;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Usuarios {
	public DB_Main dB_Main = MyUI.db;
	public Usuario[] all = new Usuario[0];

	public void createCuenta(String email, String usuario, String contrasena, String imagen, String nombre,
			String descripcion) {
		try {
			Imagen fotoPerfil = ImagenDAO.createImagen();
			Usuario nuevo = UsuarioDAO.createUsuario();

			nuevo.setApodo(usuario);
			nuevo.setContrasena(contrasena);
			nuevo.setConectado(false);
			nuevo.setDescripcion(descripcion);
			nuevo.setEmail(email);
			nuevo.setImportancia((byte) 1);
			nuevo.setNombre(nombre);
			nuevo.setNotificarAlCorreo(false);
			nuevo.setNotificarRespuestas(false);
			nuevo.setPerfil_publico(true);
			nuevo.setMaxItemsPerfil(UsuarioDAO.getUsuarioByORMID(1).getMaxItemsPerfil());

			fotoPerfil.setUrl(imagen);
			nuevo.setFotoPerfil(fotoPerfil);

			ImagenDAO.save(fotoPerfil);
			UsuarioDAO.save(nuevo);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cambiarNumeroMensajesPerfil(int max) {
		try {
			for (Usuario u : UsuarioDAO.listUsuarioByQuery("0=0", "null")) {
				u.setMaxItemsPerfil(max);
				UsuarioDAO.save(u);
				UsuarioDAO.refresh(u);
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public boolean iniciarSesion(String usuario, String contrasena) {
		try {
			Usuario u = UsuarioDAO.listUsuarioByQuery("apodo='" + usuario + "'", "null")[0];

			if (u.getContrasena().equals(contrasena) && !u.getReportado()) {
				u.setConectado(true);
				UsuarioDAO.save(u);
				UsuarioDAO.refresh(u);
				DB_Main.session = u;
			}
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return DB_Main.session != null;
	}

	public String recordarContrasena(String usuario, String email) {
		Usuario us = null;
		Random rand = new Random();
		float mask = rand.nextFloat();

		try {
			us = UsuarioDAO.listUsuarioByQuery("apodo='" + usuario + "'", "null")[0];

			while (mask < 0.1) {
				mask = rand.nextFloat();
			}

			us.setContrasena((int) (100000000 * mask) + "");

			Desktop.getDesktop().mail(URI.create("mailto:" + email + "?subject=" + "Contrasena+restablecida"
					+ "&body=Utiliza+esta+para+acceder+de+nuevo+-+" + us.getContrasena() + "+-."));

			UsuarioDAO.save(us);
			UsuarioDAO.refresh(us);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return us == null ? null : us.getContrasena();
	}

	public void setEnviarAlCorreo(long idUsuario, boolean notificar) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			u.setNotificarAlCorreo(notificar);
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void setNotificarRespuestas(long idUsuario, boolean notificar) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			u.setNotificarRespuestas(notificar);
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void ascenderAModerador(long idUsuario) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			u.setImportancia((byte) 2);
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void anadirAmigo(long fromIdUsuario, long toIdUsuario) {
		try {
			Usuario from = UsuarioDAO.getUsuarioByORMID(fromIdUsuario);

			from.amigos.add(UsuarioDAO.getUsuarioByORMID(toIdUsuario));

			UsuarioDAO.save(from);
			UsuarioDAO.refresh(from);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cambiarImagen(long idUsuario, long idImagen) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			Imagen i = ImagenDAO.getImagenByORMID(idImagen);
			u.setFotoPerfil(i);
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Usuario[] cargarAmigos(long idUsuario) {
		try {
			return UsuarioDAO.getUsuarioByORMID(idUsuario).amigos.toArray();
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Usuario[0];
		}
	}

	public Usuario[] cargarUsuariosRestringidos() {
		try {
			return UsuarioDAO.listUsuarioByQuery("restringido=1", "null");
		} catch (PersistentException e) {
			e.printStackTrace();
			return new Usuario[0];
		}
	}

	public void eliminarCuenta(long idUsuario) {
		try {
			UsuarioDAO.delete(UsuarioDAO.getUsuarioByORMID(idUsuario));
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void eliminarAmigo(long fromIdUsuario, long toIdUsuario) {
		try {
			Usuario from = UsuarioDAO.getUsuarioByORMID(fromIdUsuario);
			from.amigos.remove(UsuarioDAO.getUsuarioByORMID(fromIdUsuario));
			UsuarioDAO.save(from);
			UsuarioDAO.refresh(from);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public int getMaxProfMens() {
		try {
			return UsuarioDAO.getUsuarioByORMID(1).getMaxItemsPerfil();
		} catch (PersistentException e) {
			e.printStackTrace();
			return 7;
		}
	}

	public void eliminarUsuarioRestringido(long idUsuario) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			u.setReportado(false);
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void cambiarVisibilidadPerfil(long idUsuario) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			u.setPerfil_publico(!u.getPerfil_publico());
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public boolean gustaMensaje(long idUsuario, long idMensaje) {
		try {
			boolean res;

			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			Mensaje m = MensajeDAO.getMensajeByORMID(idMensaje);

			if (u.likesMensajes.contains(m)) {
				u.likesMensajes.remove(m);
				m.setNum_likes(m.getNum_likes() - 1);
				m.m_gusta_a.remove(u);
				res = false;
			} else {
				u.likesMensajes.remove(m);
				m.setNum_likes(m.getNum_likes() + 1);
				m.m_gusta_a.add(u);
				res = true;
			}

			UsuarioDAO.save(u);
			MensajeDAO.save(m);
			UsuarioDAO.refresh(u);
			MensajeDAO.refresh(m);

			return res;
		} catch (PersistentException e) {
			e.printStackTrace();
		}

		return false;
	}

	public void gustaTema(long idUsuario, long idTema, boolean gusta) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			Tema t = TemaDAO.getTemaByORMID(idTema);

			if (gusta) {
				t.t_gusta_a.add(u);
				u.likesTemas.add(t);
				t.setNum_likes(t.getNum_likes() + 1);
			} else {
				t.t_gusta_a.remove(u);
				u.likesTemas.remove(t);
				t.setNum_likes(t.getNum_likes() - 1);
			}

			UsuarioDAO.save(u);
			TemaDAO.save(t);
			UsuarioDAO.refresh(u);
			TemaDAO.refresh(t);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void notificarAdminSobreUsuario(long fromIdUsuario, long toIdUsuario) {
		try {
			Notificacion n = NotificacionDAO.createNotificacion();
			Usuario mod = UsuarioDAO.getUsuarioByORMID(fromIdUsuario);
			Usuario ban = UsuarioDAO.getUsuarioByORMID(toIdUsuario);

			n.setEnviada_a(UsuarioDAO.listUsuarioByQuery("Apodo='admin'", "null")[0]);
			n.setFecha_creacion(new Date().getTime());
			n.setIcono('!');
			n.setTitulo("Petición de moderación");
			n.setDescripcion("El moderador '" + mod.getApodo() + "' ha solicitado moderación para el usuario '"
					+ ban.getApodo() + "'.");

			NotificacionDAO.save(n);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public void restringirAcceso(long idUsuario) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);
			u.setReportado(true);
			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}

	public Usuario getUsuario(long idUsuario) {
		try {
			return UsuarioDAO.getUsuarioByORMID(idUsuario);
		} catch (PersistentException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void modificarPerfil(long idUsuario, String nombre, String descripcion, long idFotoPerfil,
			boolean visibilidad) {
		try {
			Usuario u = UsuarioDAO.getUsuarioByORMID(idUsuario);

			u.setNombre(nombre);
			u.setDescripcion(descripcion);
			u.setPerfil_publico(visibilidad);
			u.setFotoPerfil(ImagenDAO.getImagenByORMID(idFotoPerfil));

			UsuarioDAO.save(u);
			UsuarioDAO.refresh(u);
		} catch (PersistentException e) {
			e.printStackTrace();
		}
	}
}