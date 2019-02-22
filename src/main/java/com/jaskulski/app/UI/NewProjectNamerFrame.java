package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.NewProjectNamerListener;

import javax.swing.*;
import java.awt.*;

public class NewProjectNamerFrame extends JFrame {

    public NewProjectNamerFrame(){
        this.setSize(600, 300);
        this.setLayout(new GridLayout(2, 1));
        JTextField txtProjectName = new JTextField("Nowy_Projekt");
        txtProjectName.setFont(UIParameters.fontSmall);
        this.add(txtProjectName);

        WhiteButton btnSetName = new WhiteButton("Stwórz projekt");
        btnSetName.addActionListener(new NewProjectNamerListener(txtProjectName.getText()));
        this.add(btnSetName);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
