package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.db.Usuario;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.Image;

public class Amigo extends Image {
	public Usuario amigo;

	public Amigo(Usuario amigo) {
		super();

		this.amigo = amigo;

		addClickListener(
				l -> Interfaz.centralinator(NAVTO.PERFIL, amigo.equals(DB_Main.session), amigo.getIdUsuario()));
		setSource(new ExternalResource(amigo.getFotoPerfil().getUrl() + "&s=48"));
	}
}