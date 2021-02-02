package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Panel_de_temas_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;

public class Panel_de_temas extends Panel_de_temas_ventana {
	public Panel_de_temas(long idSeccion) {
		super();
		panel_de_temas_centro.setVisible(false);
		boton_crear_tema.setVisible(false);

		setTemasRecientes(idSeccion);
		setTemasRelevantes(idSeccion);

		panel_temas_recientes.addLayoutClickListener(l -> Interfaz.centralinator(NAVTO.TEMA,
				((Tema) l.getChildComponent()).propietario.equals(DB_Main.session),
				((Tema) l.getChildComponent()).idTema));

		panel_temas_relevantes.addLayoutClickListener(l -> Interfaz.centralinator(NAVTO.TEMA,
				((Tema) l.getChildComponent()).propietario.equals(DB_Main.session),
				((Tema) l.getChildComponent()).idTema));
	}

	public void setTemasRecientes(long idSeccion) {
		panel_temas_recientes.removeAllComponents();
		
		for (com.mds2.d100.foro.db.Tema tema : MyUI.db.cargarTemas(true, idSeccion)) {
			if (tema.getEliminado() == false && (tema.getOculto() == false
					|| (tema.getOculto() == true && DB_Main.session != null && DB_Main.session.getImportancia() > 1))) {
				panel_temas_recientes.addComponent(new Tema(tema));
			}
		}
	}

	public void setTemasRelevantes(long idSeccion) {
		panel_temas_relevantes.removeAllComponents();
		
		for (com.mds2.d100.foro.db.Tema tema : MyUI.db.cargarTemas(false, idSeccion)) {
			if (tema.getEliminado() == false && (tema.getOculto() == false
					|| (tema.getOculto() == true && DB_Main.session != null && DB_Main.session.getImportancia() > 1))) {
				panel_temas_relevantes.addComponent(new Tema(tema));
			}
		}
	}

}