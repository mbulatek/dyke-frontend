package com.dyke.frontend;

import javax.servlet.annotation.WebServlet;

import com.dyke.frontend.view.DykeView;
import com.dyke.frontend.view.MainView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("defaulttheme")
public class dukeUI extends UI {
  
  DykeView currentView;

  @Override
  protected void init(VaadinRequest vaadinRequest) {
    MainView    mainView = new MainView();

    setContent(mainView);
  }

  @WebServlet(urlPatterns = "/*", name = "dukeUIServlet", asyncSupported = true)
  @VaadinServletConfiguration(ui = dukeUI.class, productionMode = false)
  public static class dukeUIServlet extends VaadinServlet {
  }
}
