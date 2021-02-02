package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.ventana.Modificar_seccion_ventana;

public class Modificar_seccion extends Modificar_seccion_ventana {
	public Panel_de_temas_Administrador panel_de_temas_Administrador;
	private long idSeccion;

	public void aceptar() {
		String nS = text_modificar_seccion_nombre.getValue();

		MyUI.db.modificarSeccion(idSeccion, text_modificar_seccion_nombre.getValue(),
				text_modificar_seccion_descripcion.getValue(),
				select_modificar_seccion_visibilidad.getValue().endsWith("co"));

		MyUI.navigator.addView(nS, new Panel_de_temas_Administrador(idSeccion));
		MyUI.navigator.navigateTo(nS);
	}

	public void cancelar() {
		throw new UnsupportedOperationException();
	}

	public Modificar_seccion(long idSeccion) {
		super();
		mod_seccion_sup.setVisible(true);
		mod_seccion_mid.setVisible(true);
		mod_seccion_inf.setVisible(true);

		this.idSeccion = idSeccion;

		boton_modificar_seccion_aceptar.addClickListener(l -> aceptar());
		boton_modificar_seccion_cancelar.addClickListener(l -> cancelar());
	}
}