package com.mds2.d100.foro;

import javax.servlet.annotation.WebServlet;

import com.mds2.d100.foro.jdb.basededatos.DB_Main;
import com.mds2.d100.foro.vp.Interfaz;
import com.mds2.d100.foro.vp.Interfaz.NAVTO;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	public static Navigator navigator;
	public static DB_Main db = new DB_Main();

	public static enum Icon {
		A, B, C, D, E, F, G
	};

	@Override
	protected void init(VaadinRequest vaadinRequest) {
		navigator = new Navigator(this, this);
		Interfaz.centralinator(NAVTO.INICIO, true, 1);
	}

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
	}

}
