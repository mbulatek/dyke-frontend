package com.dyke.frontend.view;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

interface ViewChangetListener {
  void viewChanged(DykeView newView);
}

@SuppressWarnings("serial")
public class MenuView extends VerticalLayout implements DykeView {
  private DykeView currentView;
  private ViewChangetListener viewChangedListener;
  
  public MenuView() {
    currentView = this;
    
    createForm();
  }
  
  private void createForm() {
    final VerticalLayout mainPanel = new VerticalLayout();

    final Button createProjectButton = new Button("Create Project");
    createProjectButton.addClickListener( e -> {
      currentView = new ProjectCreateView();
      if (viewChangedListener != null) {
        viewChangedListener.viewChanged(currentView);
      }
        
        
    });

    final Button createTicketButton = new Button("Create Ticket");
    createTicketButton.addClickListener( e -> {
      currentView = new TicketCreateView();
      if (viewChangedListener != null) {
        viewChangedListener.viewChanged(currentView);
      }
    });
    
    mainPanel.addComponents(createProjectButton, createTicketButton);
    
    addComponent(mainPanel);
  }
  
  public void addViewChangedListener(ViewChangetListener listener) {
    viewChangedListener = listener;
  }
}
