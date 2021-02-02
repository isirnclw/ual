package com.mds2.d100.foro.jdb.basededatos;

public interface iUsuario_registrado_propietario extends iUsuario_registrado {

	public void setEnviarAlCorreo(long idUsuario, boolean notificar);

	public void setNotificarRespuestas(long idUsuario, boolean notificar);

	public void cambiarImagen(long idUsuario, long idImagen);

	public void cambiarVisibilidad(long idTema, boolean publico);

	public void eliminarCuenta(long idUsuario);

	public void eliminarMensaje(long idUsuario, long idMensaje);

	public void eliminarTema(long idTema);

	public void cambiarVisibilidadPerfil(long idUsuario);

	public void modificarPerfil(long idUsuario, String nombre, String descripcion, long idFotoPerfil,
			boolean visibilidad);

	public void modificarTema(long idTema, String titulo, String subtitulo, char icono, boolean publico);
}