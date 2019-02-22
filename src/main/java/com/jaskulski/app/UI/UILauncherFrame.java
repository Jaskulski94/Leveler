package com.jaskulski.app.UI;

import javax.swing.*;

public class UILauncherFrame extends JFrame {

    public void initializeUI(){
        this.setSize(UIParameters.dimFrame);

        ProjectStarterPanel projectStarter = new ProjectStarterPanel();
        this.add(projectStarter);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
