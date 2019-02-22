package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.LoadProjectListener;
import com.jaskulski.app.Controller.NewProjectListener;

import javax.swing.*;

public class ProjectStarter extends JPanel {

    public ProjectStarter(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = new JLabel("Niwelator");
        lblTitle.setFont(UIParameters.fontMedium);
        this.add(lblTitle);

        WhiteButton btnNewProject = new WhiteButton("Stwórz nowy projekt");
        btnNewProject.addActionListener(new NewProjectListener());
        this.add(btnNewProject);

        WhiteButton btnLoadProject = new WhiteButton("Otwórz istniejący projekt");
        btnLoadProject.addActionListener(new LoadProjectListener());
        this.add(btnLoadProject);

        this.setVisible(true);
    }

}
