package com.mds2.d100.foro.jdb.basededatos;

import com.mds2.d100.foro.db.Notificacion;

public interface iUsuario_registrado extends iInterfaz {

	public void ascenderAModerador(long idUsuario);

	public void anadirAmigo(long fromIdUsuario, long toIdUsuario);

	public long crearMensaje(long idTema, long idUsuario, String mensaje, boolean hayVideo, long idMultimedia_1,
			long idImagen_2, long idImagen_3);

	public long crearTema(String titulo, String subtitulo, char icono, boolean visible, long byIdUsuario,
			long idSeccion);

	public Notificacion[] cargarNotificaciones(long idUsuario);

	public void eliminarAmigo(long fromIdUsuario, long toIdUsuario);

	public boolean gustaMensaje(long idUsuario, long idMensaje);

	public void gustaTema(long idUsuario, long idTema, boolean gusta);

	public void reportar(long fromIdUsuario, long toIdMensaje);

	public void responder(long idUsuario, long idMensaje, String mensaje, boolean hayVideo, long idMultimedia_1,
			long idImagen_2, long idImagen_3);

	/**
	 * @param tipo 0 = Otro 1 = Imagen 2 = Vídeo
	 * @return
	 */
	public long subirMultimedia(byte tipo, long idMensaje, long idUsuario, String url, String texto);
}