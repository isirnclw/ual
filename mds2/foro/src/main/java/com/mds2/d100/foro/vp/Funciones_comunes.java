package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Funciones_comunes_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.navigator.View;

public class Funciones_comunes extends Funciones_comunes_ventana implements View {
	public Ver_notificaciones ver_notificaciones;

	public void cerrar_sesion() {
		DB_Main.session = null;
		Interfaz.centralinator(NAVTO.INICIO, true, 1);
	}

	public Funciones_comunes() {
		super();
		funciones_comunes_botones.setVisible(true);
		funciones_administrador_botones.setVisible(true);
		funciones_admin.setVisible(false);

		boton_mi_perfil
				.addClickListener(l -> Interfaz.centralinator(NAVTO.PERFIL, true, DB_Main.session.getIdUsuario()));
		boton_mis_notificaciones.addClickListener(
				l -> Interfaz.centralinator(NAVTO.NOTIFICACIONES, true, DB_Main.session.getIdUsuario()));
		boton_cerrar_sesion.addClickListener(l -> cerrar_sesion());
	}
}