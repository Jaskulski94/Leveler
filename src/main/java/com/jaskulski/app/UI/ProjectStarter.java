package com.jaskulski.app.UI;

import javax.swing.*;

public class ProjectStarter extends JPanel {

    public void newOrLoadProject(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel lblTitle = new JLabel("Niwelator");
        this.add(lblTitle);

        JButton btnLoadProject = new JButton("Otwórz istniejący projekt");
        this.add(btnLoadProject);

        JButton btnNewProject = new JButton("Otwórz istniejący projekt");
        this.add(btnNewProject);

        this.setVisible(true);
    }
}
