package com.dyke.frontend.view;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.ListSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class TicketCreateView extends VerticalLayout implements DykeView {

  public TicketCreateView() {
    createForm();
  }
  
  private void createForm() {
    final VerticalLayout mainPanel = new VerticalLayout();

    final ListSelect<String> projectsList = new ListSelect<String>();
    projectsList.setCaption("Project");
    projectsList.setItems("Choose project");
        
    final TextField descText = new TextField();
    descText.setCaption("Description");
    descText.addStyleName(ValoTheme.TEXTFIELD_SMALL);

    final ListSelect<String> priorityList = new ListSelect<String>();;
    priorityList.setCaption("Priority");
    priorityList.setItems("Choose priority");
    
    
    final HorizontalLayout buttonsPanel = new HorizontalLayout();

    Button createButton = new Button("Create");
    createButton.addClickListener( e -> {
      
    });

    Button cancelButton = new Button("Cancel");
    cancelButton.addClickListener( e -> {
    });

    buttonsPanel.addComponents(createButton, cancelButton);    
    mainPanel.addComponents(projectsList, descText, priorityList, buttonsPanel);
    
    addComponent(mainPanel);
    
    setComponentAlignment(mainPanel, Alignment.MIDDLE_CENTER);
  }
}
