package com.mds2.d100.foro.jdb.basededatos;

import com.mds2.d100.foro.db.Mensaje;
import com.mds2.d100.foro.db.Seccion;
import com.mds2.d100.foro.db.Tema;
import com.mds2.d100.foro.db.Usuario;

public interface iInterfaz {

	public Usuario[] cargarAmigos(long idUsuario);

	public Mensaje[] cargarMensajes(boolean esTema, long id);

	public Seccion[] cargarSecciones();

	public Tema[] cargarTemas(boolean recienteRelevante, long idSeccion);
}