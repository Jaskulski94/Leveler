package com.jaskulski.app.UI;

import javax.swing.*;

public class NewProjectNamer extends JFrame {

    public NewProjectNamer(){
        this.setSize(200, 100);

        JTextField txtProjectName = new JTextField("Podaj nazwę nowego projektu");
        this.add(txtProjectName);

        WhiteButton btnSetName = new WhiteButton("Nowy projekt");
        this.add(btnSetName);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
