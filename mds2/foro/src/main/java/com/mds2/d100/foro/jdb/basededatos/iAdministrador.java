package com.mds2.d100.foro.jdb.basededatos;

import com.mds2.d100.foro.db.Usuario;

public interface iAdministrador extends iModerador {

	public void cambiarNumeroMensajesPerfil(int max);

	public long crearSeccion(String titulo, String subtitulo, boolean publica);

	public Usuario[] cargarUsuariosRestringidos();

	public void eliminarUsuarioRestringido(long idUsuario);

	public void modificarSeccion(long idSeccion, String titulo, String subtitulo, boolean publico);

	public void restringirAcceso(long idUsuario);
}