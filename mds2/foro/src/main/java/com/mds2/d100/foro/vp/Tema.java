package com.mds2.d100.foro.vp;

import java.util.Date;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Tema_ventana;

public class Tema extends Tema_ventana {
	public long idTema;
	public com.mds2.d100.foro.db.Usuario propietario;

	public Tema(com.mds2.d100.foro.db.Tema tema) {
		super();

		String lastAuthor = tema.getAutor_ult_mens();
		Date d = new Date(tema.getFecha_ult_mens());
		boolean esAdmin = DB_Main.session != null && DB_Main.session.getImportancia() > 2;

		if (d.getTime() < 1300000000) {
			d = new Date(tema.getFecha_creacion());
			lastAuthor = tema.getCreado_por().getApodo();
		}

		this.idTema = tema.getIdTema();
		this.propietario = tema.getCreado_por();

		label_tema_nombre.setValue(tema.getTitulo());
		label_tema_likes.setValue(tema.getNum_likes() + "");
		label_tema_tiempo.setValue(d.toString());
		label_tema_ultimo_usuario.setValue(lastAuthor);
		label_tema_descripcion.setValue(tema.getSubtitulo());
		label_tema_icono.setValue(tema.getIcono() + "");

		boton_tema_eliminar.setVisible(esAdmin);
		boton_tema_modificar.setVisible(esAdmin);

		if (esAdmin) {
			MyUI.navigator.addView("modificar-tema", new Modificar_tema(tema.getIdTema()));
			boton_tema_eliminar.addClickListener(l -> MyUI.db.eliminarTema(tema.getIdTema()));
			boton_tema_modificar.addClickListener(l -> MyUI.navigator.navigateTo("modificar-tema"));
		}
	}
}