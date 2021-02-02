package com.mds2.d100.foro.jdb.basededatos;

import com.mds2.d100.foro.db.Imagenes;
import com.mds2.d100.foro.db.Mensaje;
import com.mds2.d100.foro.db.Mensajes;
import com.mds2.d100.foro.db.Notificacion;
import com.mds2.d100.foro.db.Notificaciones;
import com.mds2.d100.foro.db.Seccion;
import com.mds2.d100.foro.db.Secciones;
import com.mds2.d100.foro.db.Tema;
import com.mds2.d100.foro.db.Temas;
import com.mds2.d100.foro.db.Usuario;
import com.mds2.d100.foro.db.Usuarios;
import com.mds2.d100.foro.db.Videos;

public class DB_Main implements iUsuario_registrado_propietario, iUsuario_registrado, iUsuario_no_registrado, iInterfaz,
		iAdministrador, iModerador {
	public Notificaciones notificaciones = new Notificaciones();
	public Secciones secciones = new Secciones();
	public Mensajes mensajes = new Mensajes();
	public Imagenes imagenes = new Imagenes();
	public Temas temas = new Temas();
	public Usuarios usuarios = new Usuarios();
	public Videos videos = new Videos();

	public static Usuario session = null;

	public void setEnviarAlCorreo(long idUsuario, boolean notificar) {
		usuarios.setEnviarAlCorreo(idUsuario, notificar);
	}

	public void setNotificarRespuestas(long idUsuario, boolean notificar) {
		usuarios.setNotificarRespuestas(idUsuario, notificar);
	}

	public void cambiarImagen(long idUsuario, long idImagen) {
		usuarios.cambiarImagen(idUsuario, idImagen);
	}

	public void cambiarVisibilidad(long idTema, boolean publico) {
		temas.cambiarVisibilidad(idTema, publico);
	}

	public void eliminarCuenta(long idUsuario) {
		usuarios.eliminarCuenta(idUsuario);
	}

	public void eliminarMensaje(long idUsuario, long idMensaje) {
		mensajes.eliminarMensaje(idUsuario, idMensaje);
	}

	public void cambiarVisibilidadPerfil(long idUsuario) {
		usuarios.cambiarVisibilidadPerfil(idUsuario);
	}

	public void modificarTema(long idTema, String titulo, String subtitulo, char icono, boolean publico) {
		temas.modificarTema(idTema, titulo, subtitulo, icono, publico);
	}

	public void ascenderAModerador(long idUsuario) {
		usuarios.ascenderAModerador(idUsuario);
	}

	public void anadirAmigo(long fromIdUsuario, long toIdUsuario) {
		usuarios.anadirAmigo(fromIdUsuario, toIdUsuario);
	}

	public long crearMensaje(long idTema, long idUsuario, String mensaje, boolean hayVideo, long idMultimedia_1,
			long idImagen_2, long idImagen_3) {
		return temas.crearMensaje(idTema, idUsuario, mensaje, idMultimedia_1, idImagen_2, idImagen_3);
	}

	public Notificacion[] cargarNotificaciones(long idUsuario) {
		return notificaciones.cargarNotificaciones(idUsuario);
	}

	public void eliminarAmigo(long fromIdUsuario, long toIdUsuario) {
		usuarios.eliminarAmigo(fromIdUsuario, toIdUsuario);
	}

	public Usuario[] cargarAmigos(long idUsuario) {
		return usuarios.cargarAmigos(idUsuario);
	}

	public Mensaje[] cargarMensajes(boolean esTema, long id) {
		return esTema ? mensajes.cargarMensajes(id) : temas.cargarMensajes(id);
	}

	public Seccion[] cargarSecciones() {
		return secciones.cargarSecciones();
	}

	public Tema[] cargarTemas(boolean recienteRelevante, long idSeccion) {
		return recienteRelevante ? temas.cargarTemasRecientes(idSeccion) : temas.cargarTemasRelevantes(idSeccion);
	}

	public void crearCuenta(String email, String usuario, String contrasena, String imagen, String nombre,
			String descripcion) {
		usuarios.createCuenta(email, usuario, contrasena, imagen, nombre, descripcion);
	}

	public void recordarContrasena(String usuario, String email) {
		usuarios.recordarContrasena(usuario, email);
	}

	public void cambiarNumeroMensajesPerfil(int max) {
		usuarios.cambiarNumeroMensajesPerfil(max);
	}

	public long crearSeccion(String titulo, String subtitulo, boolean publica) {
		return secciones.crearSeccion(titulo, subtitulo, publica);
	}

	public void modificarSeccion(long idSeccion, String titulo, String subtitulo, boolean publico) {
		secciones.modificarSeccion(idSeccion, titulo, subtitulo, publico);
	}

	public void notificarAdminSobreUsuario(long fromIdUsuario, long toIdUsuario) {
		usuarios.notificarAdminSobreUsuario(fromIdUsuario, toIdUsuario);
	}

	public Usuario[] cargarUsuariosRestringidos() {
		return usuarios.cargarUsuariosRestringidos();
	}

	public boolean iniciarSesion(String usuario, String contrasena) {
		return usuarios.iniciarSesion(usuario, contrasena);
	}

	public void eliminarUsuarioRestringido(long idUsuario) {
		usuarios.eliminarUsuarioRestringido(idUsuario);
	}

	public void restringirAcceso(long idUsuario) {
		usuarios.restringirAcceso(idUsuario);
	}

	/**
	 * @param tipo puede ser 0 = Otro, 1 = Imagen, 2 = Vídeo.
	 * @return
	 */
	public long subirMultimedia(byte tipo, long idMensaje, long idUsuario, String url, String texto) {
		return tipo == 1 ? imagenes.subirImagen(url, idMensaje, idUsuario, texto)
				: videos.subirVideo(url, idMensaje, idUsuario, texto);
	}

	public boolean gustaMensaje(long idUsuario, long idMensaje) {
		return usuarios.gustaMensaje(idUsuario, idMensaje);
	}

	public void gustaTema(long idUsuario, long idTema, boolean gusta) {
		usuarios.gustaTema(idUsuario, idTema, gusta);
	}

	public void reportar(long fromIdUsuario, long toIdMensaje) {
		mensajes.reportar(fromIdUsuario, toIdMensaje);
	}

	public void responder(long idUsuario, long idMensaje, String mensaje, boolean hayVideo, long idMultimedia_1,
			long idImagen_2, long idImagen_3) {
		mensajes.responder(idUsuario, idMensaje, mensaje, hayVideo, idMultimedia_1, idImagen_2, idImagen_3);
	}

	public long crearTema(String titulo, String subtitulo, char icono, boolean visible, long byIdUsuario,
			long idSeccion) {
		return temas.crearTema(titulo, subtitulo, icono, visible, byIdUsuario, idSeccion);
	}

	public Tema getTema(long id) {
		return temas.getTema(id);
	}

	public void eliminarTema(long idTema) {
		temas.eliminarTema(idTema);
	}

	public Seccion getSeccion(long idSeccion) {
		return secciones.getSeccion(idSeccion);
	}

	public long getIdSeccion(String titulo) {
		return secciones.getIdSeccion(titulo);
	}

	public void reportarTema(long idTema) {
		temas.reportarTema(idTema);
	}

	public Usuario getUsuario(long idUsuario) {
		return usuarios.getUsuario(idUsuario);
	}

	public void modificarPerfil(long idUsuario, String nombre, String descripcion, long idFotoPerfil,
			boolean visibilidad) {
		usuarios.modificarPerfil(idUsuario, nombre, descripcion, idFotoPerfil, visibilidad);
	}
}