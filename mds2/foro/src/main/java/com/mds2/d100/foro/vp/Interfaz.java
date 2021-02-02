package com.mds2.d100.foro.vp;

import com.mds2.d100.foro.MyUI;
import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.ventana.Interfaz_ventana;
import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

public class Interfaz extends Interfaz_ventana implements View {
	public Cabecera _Cabecera;
	public Panel_derecho _Panel_derecho;
	public Panel_de_temas_Inicio _Panel_de_temas_Inicio;
	public Panel_izquierdo _Panel_izquierdo;

	public enum NAVTO {
		INICIO, TEMA, PERFIL, US_RESTRINGIDOS, NOTIFICACIONES
	}

	public Interfaz() {
		super();
		interfaz_cabecera.setVisible(true);
		interfaz_inferior.setVisible(true);
		interfaz_panel_izq.setVisible(true);
		interfaz_panel_central.setVisible(true);
		interfaz_panel_derecho.setVisible(true);

		// Pérfido Doofenshmirtz S.L.
		extreminator();
	}

	public static void centralinator(NAVTO nav, boolean propio, long id) {
		Interfaz i = new Interfaz();
		VerticalLayout central = i.interfaz_panel_central;
		boolean perry = DB_Main.session == null;
		String ruta = "";

		central.removeAllComponents();

		switch (nav) {
		case INICIO:
			if (perry) {
				central.addComponent(new Panel_de_temas_Inicio(id));
			} else if (DB_Main.session.getImportancia() <= 3) {
				central.addComponent(new Panel_de_temas_Usuario_R(id));
			} else {
				central.addComponent(new Panel_de_temas_Administrador(id));
			}

			ruta = "seccion/" + id;
			break;
		case NOTIFICACIONES:
			if (!perry) {
				central.addComponent(new Ver_notificaciones());
				ruta = "notificaciones/" + DB_Main.session.getIdUsuario();
			}
			break;
		case PERFIL:
			if (!perry) {
				if (propio) {
					central.addComponent(new Perfil_Usuario_P());
					ruta = "perfil/" + DB_Main.session.getIdUsuario();
				} else {
					switch (DB_Main.session.getImportancia()) {
					case 1:
						central.addComponent(new Perfil_Usuario_R(id));
						break;
					case 2:
						central.addComponent(new Perfil_Moderador(id));
						break;
					case 3:
						central.addComponent(new Perfil_Administrador(id));
						break;
					}

					ruta = "perfil/" + id;
				}
			}
			break;
		case TEMA:
			if (perry) {
				central.addComponent(new Panel_de_mensajes(id));
			} else {
				if (DB_Main.session.getImportancia() == 1) {
					if (propio) {
						central.addComponent(new Panel_de_mensajes_Usuario_P(id));
					} else {
						central.addComponent(new Panel_de_mensajes_Usuario_R(id));
					}
					break;
				} else {
					central.addComponent(new Panel_de_mensajes_Moderador(id));
				}
			}

			ruta = "tema/" + id;
			break;
		case US_RESTRINGIDOS:
			central.addComponent(new Usuarios_restringidos());
			ruta = "restringidos/" + id;
			break;
		}

		MyUI.navigator.addView(ruta, i);
		MyUI.navigator.navigateTo(ruta);
	}

	/** PERRY, ADMIRA MI ÚLTIMA CREACIÓN **/
	private void extreminator() {
		interfaz_panel_izq.addComponent(new Panel_izquierdo());

		if (DB_Main.session == null) {
			interfaz_cabecera.addComponent(new Cabecera_Usuario_NR());
			interfaz_panel_derecho.addComponent(new Panel_derecho_Usuario_NR());
		} else {
			interfaz_cabecera.addComponent(new Cabecera_Usuario_R());
			interfaz_panel_derecho.addComponent(new Panel_derecho_Usuario_R());
		}
	}

}