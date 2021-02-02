package com.mds2.d100.foro.vp;

import java.util.Random;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Modificar_perfil_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;

public class Modificar_perfil extends Modificar_perfil_ventana {
	public Perfil_Usuario_P perfil_Usuario_P;

	public void cambiar_imagen() {
		MyUI.db.cambiarImagen(DB_Main.session.getIdUsuario(),
				MyUI.db.subirMultimedia((byte) 1, 0, DB_Main.session.getIdUsuario(),
						"https://www.gravatar.com/avatar/" + new Random().nextInt() + "?d=identicon",
						"Imagen de perfil para " + DB_Main.session.getApodo() + "."));
	}

	public void eliminar_cuenta() {
		MyUI.db.eliminarCuenta(DB_Main.session.getIdUsuario());
		DB_Main.session = null;
		Interfaz.centralinator(NAVTO.INICIO, true, 1);
	}

	public void guardar_cambios() {
		MyUI.db.modificarPerfil(DB_Main.session.getIdUsuario(), text_modificar_perfil_nombre.getValue(),
				text_modificar_perfil_descripcion.getValue(),
				MyUI.db.subirMultimedia((byte) 1, 0, DB_Main.session.getIdUsuario(),
						"https://www.gravatar.com/avatar/" + new Random().nextInt() + "?d=identicon",
						"Imagen de perfil para " + DB_Main.session.getApodo() + "."),
				true);
	}

	public Modificar_perfil() {
		super();
		mod_perfil_sup.setVisible(true);
		mod_perfil_mid.setVisible(true);
		mod_perfil_inf.setVisible(true);

		boton_modificar_perfil_eliminar.addClickListener(l -> eliminar_cuenta());
		boton_modificar_perfil_guardar.addClickListener(l -> guardar_cambios());
		image_modificar_perfil.addClickListener(l -> cambiar_imagen());
	}
}