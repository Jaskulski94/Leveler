package com.jaskulski.app.UI;

import com.jaskulski.app.UI.ProjectStarterUI.ProjectStarterPanel;

import javax.swing.*;

public class UILauncherFrame extends JFrame {

    public void initializeUI() {
        this.setSize(UIParameters.dimFrame);

        ProjectStarterPanel projectStarter = new ProjectStarterPanel(this);
        this.add(projectStarter);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void changePanel(JPanel panel1) {
        this.getContentPane().removeAll();
        this.add(panel1);
        this.repaint();
        this.setVisible(true);
    }

}
