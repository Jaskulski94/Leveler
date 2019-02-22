package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.NewProjectNamerListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class NewProjectNamerFrame extends JFrame {

    public JTextField txtProjectName;
 //   public ProjectStarterPanel psPanel;

    public NewProjectNamerFrame(){
 //       this.psPanel = psPanel1;

        this.setSize(600, 300);
        this.setLayout(new GridLayout(2, 1));
        txtProjectName = new JTextField("Nowy_Projekt");
        txtProjectName.setFont(UIParameters.fontSmall);
        this.add(txtProjectName);

        WhiteButton btnSetName = new WhiteButton("Stwórz projekt");
        btnSetName.addActionListener(new NewProjectNamerListener(this));
        this.add(btnSetName);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void changeWindow(){
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
