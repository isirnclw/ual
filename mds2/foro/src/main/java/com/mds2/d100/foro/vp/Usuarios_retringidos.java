package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.db.Usuario;
import com.mds2.d100.foro.ventana.Usuarios_restringidos_ventana;

public class Usuarios_retringidos extends Usuarios_restringidos_ventana {
	public Usuarios_restringidos usuarios_restringidos;
	public Usuario[] usuario_restringido;

	public Usuarios_retringidos() {
		super();

		usuario_restringido = MyUI.db.cargarUsuariosRestringidos();
	}
}