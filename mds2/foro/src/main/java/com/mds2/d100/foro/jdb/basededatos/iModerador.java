package com.mds2.d100.foro.jdb.basededatos;

public interface iModerador extends iUsuario_registrado_propietario {

	public void notificarAdminSobreUsuario(long fromIdUsuario, long toIdUsuario);
}