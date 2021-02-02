package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;

public class Funciones_Administrador extends Funciones_comunes {

	public void cambiar_numero_de_mensajes_en_perfiles() {
		int max = 7;

		try {
			max = Integer.parseInt(text_funciones_comunes_mensajes.getValue());
		} catch (Exception e) {
			e.printStackTrace();
		}

		MyUI.db.cambiarNumeroMensajesPerfil(max);
	}

	public Funciones_Administrador() {
		super();
		funciones_administrador_botones.setVisible(true);
		funciones_admin.setVisible(true);

		MyUI.navigator.addView("crear seccion", new Crear_seccion());

		boton_usuarios_restringidos.addClickListener(l -> Interfaz.centralinator(NAVTO.US_RESTRINGIDOS, true, 0));
		boton_crear_seccion.addClickListener(l -> MyUI.navigator.navigateTo("crear seccion"));
		text_funciones_comunes_mensajes.addValueChangeListener(l -> cambiar_numero_de_mensajes_en_perfiles());
	}
}