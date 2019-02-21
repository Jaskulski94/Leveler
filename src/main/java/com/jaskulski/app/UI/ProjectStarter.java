package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.LoadProjectListener;
import com.jaskulski.app.Controller.NewProjectListener;

import javax.swing.*;

public class ProjectStarter extends JPanel {

    public void newOrLoadProject(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = new JLabel("Niwelator");
        this.add(lblTitle);

        JButton btnLoadProject = new JButton("Otwórz istniejący projekt");
        btnLoadProject.addActionListener(new LoadProjectListener());
        this.add(btnLoadProject);

        JButton btnNewProject = new JButton("Otwórz istniejący projekt");
        btnNewProject.addActionListener(new NewProjectListener());
        this.add(btnNewProject);

        this.setVisible(true);
    }
}
