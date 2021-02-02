package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;

public class Perfil_Usuario_P extends Perfil {
	private String nombre;
	private String descripcion;

	public void cambiar_visibilidad() {
		MyUI.db.cambiarVisibilidadPerfil(idUsuario);
	}

	public Perfil_Usuario_P() {
		super(DB_Main.session.getIdUsuario());

		boton_perfil_amigo.setVisible(false);
		tab_perfil_usuario.getTab(2).setVisible(true);
		grid_perfil_modificar.setVisible(true);

		text_nombre.setValue(nombre = actual.getNombre());
		text_descripcion.setValue(descripcion = actual.getDescripcion());

		text_nombre.addValueChangeListener(l -> nombre = l.getValue());
		text_descripcion.addValueChangeListener(l -> descripcion = l.getValue());
	}

	private void modificar() {
		MyUI.db.modificarPerfil(idUsuario, nombre, descripcion, actual.getFotoPerfil().getIdImagen(), true);
	}
}