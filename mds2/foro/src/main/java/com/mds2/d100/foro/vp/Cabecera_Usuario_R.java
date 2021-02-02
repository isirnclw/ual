package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.server.ExternalResource;

public class Cabecera_Usuario_R extends Cabecera {
	public Cabecera_Usuario_R() {
		super();

		cabecera_usuario_r.setVisible(true);

		MyUI.navigator.addView("funciones",
				DB_Main.session.getImportancia() > 2 ? new Funciones_Administrador() : new Funciones_comunes());

		label_cabecera_nombre.setValue(DB_Main.session.getApodo());
		boton_logo.addClickListener(l -> com.mds2.d100.foro.vp.Interfaz.centralinator(NAVTO.INICIO, true, 1));
		boton_funciones.addClickListener(l -> MyUI.navigator.navigateTo("funciones"));
		boton_funciones.setIcon(new ExternalResource(DB_Main.session.getFotoPerfil().getUrl() + "&s=36"));
	}
}