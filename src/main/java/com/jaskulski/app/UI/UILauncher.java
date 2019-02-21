package com.jaskulski.app.UI;

import javax.swing.*;

public class UILauncher extends JFrame {

    public void initializeUI(){
        this.setSize(UIParameters.dimFrame);

        ProjectStarter projectStarter = new ProjectStarter();
        projectStarter.newOrLoadProject();
        this.add(projectStarter);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
