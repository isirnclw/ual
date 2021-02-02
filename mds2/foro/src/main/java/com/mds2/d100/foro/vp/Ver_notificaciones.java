package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.db.Notificacion;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Ver_notificaciones_ventana;

public class Ver_notificaciones extends Ver_notificaciones_ventana {

	public void set_enviar_al_correo() {
		MyUI.db.setEnviarAlCorreo(DB_Main.session.getIdUsuario(), check_ver_notificaciones_enviar.getValue());
		check_ver_notificaciones_enviar.setValue(DB_Main.session.getNotificarAlCorreo());
	}

	public void set_notificar_respuestas() {
		MyUI.db.setNotificarRespuestas(DB_Main.session.getIdUsuario(), check_ver_notificaciones_notificar.getValue());
		check_ver_notificaciones_notificar.setValue(DB_Main.session.getNotificarRespuestas());
	}

	public Ver_notificaciones() {
		super();

		check_ver_notificaciones_enviar.setValue(DB_Main.session.getNotificarAlCorreo());
		check_ver_notificaciones_notificar.setValue(DB_Main.session.getNotificarRespuestas());

		check_ver_notificaciones_enviar.addValueChangeListener(l -> set_enviar_al_correo());
		check_ver_notificaciones_notificar.addValueChangeListener(l -> set_notificar_respuestas());

		for (Notificacion n : MyUI.db.cargarNotificaciones(DB_Main.session.getIdUsuario())) {
			grid_notificaciones.addComponent(new com.mds2.d100.foro.vp.Notificacion(n));
		}
	}
}
