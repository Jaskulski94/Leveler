package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.ChangePanelListener;
import com.jaskulski.app.Controller.LoadProjectListener;
import com.jaskulski.app.Controller.NewProjectListener;

import javax.swing.*;
import java.awt.*;

public class ProjectStarterPanel extends JPanel {

    UILauncherFrame UILauncher;

    public ProjectStarterPanel(UILauncherFrame UILauncher1){
        this.UILauncher = UILauncher1;

        this.setLayout(new GridLayout(3, 1));
        JLabel lblTitle = new JLabel("Niwelator");
        lblTitle.setFont(UIParameters.fontBig);
        lblTitle.setHorizontalAlignment(JLabel.CENTER);
        lblTitle.setVerticalAlignment(JLabel.CENTER);
        this.add(lblTitle);

        ChangePanelListener cpListener = new ChangePanelListener(UILauncher, new NewProjectInitiatorPanel());

        WhiteButton btnNewProject = new WhiteButton("Stwórz nowy projekt");
        btnNewProject.addActionListener(new NewProjectListener());
        btnNewProject.addActionListener(cpListener);
        this.add(btnNewProject);

        WhiteButton btnLoadProject = new WhiteButton("Otwórz istniejący projekt");
        btnLoadProject.addActionListener(new LoadProjectListener());
        btnLoadProject.addActionListener(cpListener);
        this.add(btnLoadProject);

        this.setVisible(true);
    }

}