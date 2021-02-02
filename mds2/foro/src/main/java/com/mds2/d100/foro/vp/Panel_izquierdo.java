package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Panel_izquierdo_ventana;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.data.TreeData;

@SuppressWarnings("unchecked")
public class Panel_izquierdo extends Panel_izquierdo_ventana {
	private static TreeData<String> dataSecciones = new TreeData<>();

	public void abrir_cerrar_panel() {
		this.setWidth(48, Unit.PIXELS);
	}

	public void abrir(String titulo) {
		if (!titulo.startsWith(" ")) {
			Interfaz.centralinator(NAVTO.INICIO, false, MyUI.db.getIdSeccion(titulo));
		}
	}

	public Panel_izquierdo() {
		super();
		arbol.setVisible(true);

		arbol.addItemClickListener(l -> abrir(l.getItem().toString()));

		setSecciones();
	}

	private void setSecciones() {
		String titulo, padre;

		if (!dataSecciones.contains(" #")) {
			dataSecciones.addItem(null, " #");
			dataSecciones.addItem(null, " A - D");
			dataSecciones.addItem(null, " E - H");
			dataSecciones.addItem(null, " I - M");
			dataSecciones.addItem(null, " N - Q");
			dataSecciones.addItem(null, " R - Z");
		}

		for (com.mds2.d100.foro.db.Seccion s : MyUI.db.cargarSecciones()) {
			if (s.getEliminado() == false && (s.getOculto() == false
					|| (s.getOculto() == true && DB_Main.session != null && DB_Main.session.getImportancia() > 1))) {

				titulo = s.getTitulo().strip();

				if (!dataSecciones.contains(titulo)) {
					switch (titulo.toUpperCase().charAt(0)) {
					case 'A':
					case 'B':
					case 'C':
					case 'D':
						padre = " A - D";
						break;
					case 'E':
					case 'F':
					case 'G':
					case 'H':
						padre = " E - H";
						break;
					case 'I':
					case 'J':
					case 'K':
					case 'L':
					case 'M':
						padre = " I - M";
						break;
					case 'N':
					case 'Ñ':
					case 'O':
					case 'P':
					case 'Q':
						padre = " N - Q";
						break;
					case 'R':
					case 'S':
					case 'T':
					case 'U':
					case 'V':
					case 'W':
					case 'X':
					case 'Y':
					case 'Z':
						padre = " R - Z";
						break;
					default:
						padre = " #";
						break;
					}

					dataSecciones.addItem(padre, titulo);
				}
			}
		}

		arbol.setTreeData(dataSecciones);
	}
}