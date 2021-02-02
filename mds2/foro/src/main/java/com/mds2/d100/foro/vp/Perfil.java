package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.db.Usuario;
import com.mds2.d100.foro.ventana.Perfil_ventana;
import com.vaadin.server.ExternalResource;

public class Perfil extends Perfil_ventana {
	protected long idUsuario;
	protected Usuario actual;

	public Perfil(long id) {
		super();

		boton_perfil_ascender.setVisible(false);
		boton_perfil_notificar.setVisible(false);
		boton_perfil_restringir.setVisible(false);
		grid_perfil_modificar.setVisible(false);
		tab_perfil_usuario.getTab(2).setVisible(false);

		this.idUsuario = id;
		this.actual = MyUI.db.getUsuario(idUsuario);

		image_perfil.setSource(new ExternalResource(actual.getFotoPerfil().getUrl()));
		label_perfil_usuario.setValue(actual.getApodo());
		label_perfil_descripcion.setValue(actual.getDescripcion());

		setContribuciones(id);
		setAmigos(id);
	}

	public void setContribuciones(long idUsuario) {
		grid_perfil_contribuciones.removeAllComponents();

		for (com.mds2.d100.foro.db.Mensaje mensaje : actual.mensajes.toArray()) {
			grid_perfil_contribuciones.addComponent(new Respuesta(mensaje, true));
		}
	}

	public void setAmigos(long idUsuario) {
		grid_perfil_amigos.removeAllComponents();

		for (com.mds2.d100.foro.db.Usuario amigo : actual.amigos.toArray()) {
			grid_perfil_amigos.addComponent(new Amigo(amigo));
		}
	}
}