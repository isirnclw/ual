package com.mds2.d100.foro.jdb.basededatos;

public interface iUsuario_no_registrado extends iInterfaz {

	public void crearCuenta(String email, String usuario, String contrasena, String imagen, String nombre,
			String descripcion);

	public boolean iniciarSesion(String usuario, String contrasena);

	public void recordarContrasena(String usuario, String email);
}