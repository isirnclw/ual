package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Crear_tema_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.navigator.View;

public class Crear_tema extends Crear_tema_ventana implements View {
	private char icon;
	private long idSeccion;
	public Panel_de_temas_Usuario_R panel_de_temas_Usuario_R;

	public void crear() {
		long idTema = MyUI.db.crearTema(text_crear_tema_nombre.getValue(), text_crear_tema_descripcion.getValue(), icon,
				selector_crear_tema_visibilidad.getValue().endsWith("co"), DB_Main.session.getIdUsuario(), idSeccion);
		Interfaz.centralinator(NAVTO.TEMA, true, idTema);
	}

	private void setIcon(char i) {
		this.icon = i;
	}

	public void cancelar() {
		Interfaz.centralinator(NAVTO.INICIO, true, idSeccion);
	}

	public Crear_tema(long idSeccion) {
		super();
		crear_tema_sup.setVisible(true);
		crear_tema_mid.setVisible(true);
		crear_tema_inf.setVisible(true);

		this.idSeccion = idSeccion;

		boton_crear_tema_icono1.addClickListener(l -> setIcon('*'));
		boton_crear_tema_icono2.addClickListener(l -> setIcon('!'));
		boton_crear_tema_icono3.addClickListener(l -> setIcon('?'));
		boton_crear_tema_icono4.addClickListener(l -> setIcon('x'));
		boton_crear_tema_icono5.addClickListener(l -> setIcon('+'));
		boton_crear_tema_icono6.addClickListener(l -> setIcon('-'));

		boton_crear_tema_cancelar.addClickListener(l -> cancelar());
		boton_crear_tema_aceptar.addClickListener(l -> crear());
	}
}