package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.ventana.Crear_seccion_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.navigator.View;

public class Crear_seccion extends Crear_seccion_ventana implements View {
	public Funciones_Administrador Funciones_Administrador;

	public void crear() {
		String nS = text_crear_seccion_nombre.getValue();
		long idSeccion = MyUI.db.crearSeccion(nS, text_crear_seccion_descripcion.getValue(),
				selector_crear_seccion_visibilidad.getValue().endsWith("ca"));
		Interfaz.centralinator(NAVTO.INICIO, true, idSeccion);
	}

	public void cancelar() {
		MyUI.navigator.navigateTo("funciones");
	}

	public Crear_seccion() {
		super();
		crear_seccion_sup.setVisible(true);
		crear_seccion_mid.setVisible(true);
		crear_seccion_inf.setVisible(true);

		boton_crear_seccion_cancelar.addClickListener(l -> cancelar());
		boton_crear_seccion_aceptar.addClickListener(l -> crear());
	}

}