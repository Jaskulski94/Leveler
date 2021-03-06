package com.jaskulski.app.UI.ProjectStarterUI;

import com.jaskulski.app.Controller.UIControl.ChangePanelListener;
import com.jaskulski.app.Controller.UIControl.ProjectStarterControl.LoadProjectListener;
import com.jaskulski.app.Controller.UIControl.ProjectStarterControl.NewProjectListener;
import com.jaskulski.app.UI.UILauncherFrame;
import com.jaskulski.app.UI.UIParameters;
import com.jaskulski.app.UI.WhiteButton;

import javax.swing.*;
import java.awt.*;

public class ProjectStarterPanel extends JPanel {

    private UILauncherFrame UILauncher;

    public ProjectStarterPanel() {
    }

    public ProjectStarterPanel(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
        initializeProject();
    }

    public void startEmptyProjectStarter(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
        initializeProject();
    }

    private void initializeProject() {
        this.setLayout(new GridLayout(3, 1));
        JLabel lblTitle = new JLabel("Niwelator");
        lblTitle.setFont(UIParameters.fontBig);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        this.add(lblTitle);

        ChangePanelListener cPListener = new ChangePanelListener(UILauncher, new NewProjectInitiatorPanel(UILauncher));

        WhiteButton btnNewProject = new WhiteButton("Stwórz nowy projekt");
        btnNewProject.addActionListener(new NewProjectListener());
        btnNewProject.addActionListener(cPListener);
        this.add(btnNewProject);

        WhiteButton btnLoadProject = new WhiteButton("Otwórz istniejący projekt");
        btnLoadProject.addActionListener(new LoadProjectListener(UILauncher));
        this.add(btnLoadProject);

        this.setVisible(true);
    }

}
