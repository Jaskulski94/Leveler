package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.LoadProjectListener;
import com.jaskulski.app.Controller.NewProjectListener;

import javax.swing.*;
import java.awt.*;

public class ProjectStarter extends JPanel {

    public ProjectStarter(){
        this.setLayout(new GridLayout(3, 1));
        JLabel lblTitle = new JLabel("Niwelator");
        lblTitle.setFont(UIParameters.fontBig);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
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
