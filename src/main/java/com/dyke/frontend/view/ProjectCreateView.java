package com.dyke.frontend.view;

import com.dyke.frontend.rest.ProjectController;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class ProjectCreateView extends VerticalLayout implements DykeView {

  public ProjectCreateView() {
    createForm();
  }
  
  private void createForm() {
    final VerticalLayout mainPanel = new VerticalLayout();

    final TextField nameText = new TextField();
    nameText.setCaption("Project Name");
    nameText.addStyleName(ValoTheme.TEXTFIELD_SMALL);

    final TextField descText = new TextField();
    descText.setCaption("Description");
    descText.addStyleName(ValoTheme.TEXTFIELD_SMALL);
    
    final HorizontalLayout buttonsPanel = new HorizontalLayout();

    Button createButton = new Button("Create");
    createButton.addClickListener( e -> {
      ProjectController.createProject(nameText.getValue(), descText.getValue());
    });

    Button cancelButton = new Button("Cancel");
    cancelButton.addClickListener( e -> {
    });

    buttonsPanel.addComponents(createButton, cancelButton);    
    mainPanel.addComponents(nameText, descText, buttonsPanel);
    
    addComponent(mainPanel);
    
    setComponentAlignment(mainPanel, Alignment.MIDDLE_CENTER);
  }
}
