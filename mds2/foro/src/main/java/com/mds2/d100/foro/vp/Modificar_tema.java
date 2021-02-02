package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Modificar_tema_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.navigator.View;

public class Modificar_tema extends Modificar_tema_ventana implements View {
	public Panel_de_temas_Administrador panel_de_temas_Administrador;
	private char icon;
	private com.mds2.d100.foro.db.Tema tema;

	public void aceptar() {
		MyUI.db.modificarTema(tema.getIdTema(), text_modificar_tema_nomobre.getValue(),
				text_modificar_tema_descripcion.getValue(), icon,
				select_modificar_tema_visibilidad.getValue().endsWith("co"));
		Interfaz.centralinator(NAVTO.TEMA, tema.getCreado_por().equals(DB_Main.session), tema.getIdTema());
	}

	public void cancelar() {
		Interfaz.centralinator(NAVTO.TEMA, tema.getCreado_por().equals(DB_Main.session), tema.getIdTema());
	}

	private void setIcon(char i) {
		this.icon = i;
	}

	public Modificar_tema(long idTema) {
		super();
		mod_tema_sup.setVisible(true);
		mod_tema_mid.setVisible(true);
		mod_tema_inf.setVisible(true);

		this.tema = MyUI.db.getTema(idTema);

		text_modificar_tema_nomobre.setValue(tema.getTitulo());
		text_modificar_tema_descripcion.setValue(tema.getSubtitulo());
		select_modificar_tema_visibilidad.setSelectedItem(tema.getOculto() ? "Privado" : "Público");

		boton_modificar_tema_icono1.addClickListener(l -> setIcon('*'));
		boton_modificar_tema_icono2.addClickListener(l -> setIcon('!'));
		boton_modificar_tema_icono3.addClickListener(l -> setIcon('?'));
		boton_modificar_tema_icon4.addClickListener(l -> setIcon('x'));
		boton_modificar_tema_icono5.addClickListener(l -> setIcon('+'));
		boton_modificar_tema_icono6.addClickListener(l -> setIcon('-'));

		boton_modificar_tema_icono_aceptar.addClickListener(l -> aceptar());
		boton_modificar_tema_cancelar.addClickListener(l -> cancelar());
	}
}