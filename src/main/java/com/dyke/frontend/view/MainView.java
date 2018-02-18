package com.dyke.frontend.view;

import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements DykeView {
  private DykeView currentView;
  private MenuView menuView;
  private HorizontalLayout horizontalLayout;
  
  public MainView() {
    currentView = this;
    
    createForm();
  }
  
  private void createForm() {
    final VerticalLayout verticalLayout = new VerticalLayout();
    
    
    final Label titleLabel = new Label();
    titleLabel.setCaption("DYKE");
    titleLabel.addStyleName(ValoTheme.LABEL_H1);
    
    verticalLayout.addComponent(titleLabel);
    
    
    final Label welcomeLabel = new Label();
    welcomeLabel.setCaption("Welcome");
    welcomeLabel.addStyleName(ValoTheme.LABEL_H1);
    
    menuView = new MenuView();
    menuView.addViewChangedListener(new ViewChangetListener() {
      
      @Override
      public void viewChanged(DykeView newView) {
        currentView = newView;
        updateForm();
      }
    });
    
    currentView = new ProjectCreateView();
    
    horizontalLayout = new HorizontalLayout();
    horizontalLayout.addComponent(menuView);
    horizontalLayout.addComponent((Component) currentView);
    
    verticalLayout.addComponent(horizontalLayout);

    addComponent(verticalLayout);
  }
  
  private void updateForm() {
    horizontalLayout.removeAllComponents();
    horizontalLayout.addComponent(menuView);
    horizontalLayout.addComponent((Component) currentView);
  }
}
