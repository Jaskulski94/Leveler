package com.jaskulski.app.Controller;

import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackListener implements ActionListener {

    UILauncherFrame UILauncher;
    JPanel newPanel;

    public BackListener(UILauncherFrame UILauncher1, JPanel panel1){
        this.UILauncher = UILauncher1;
        this.newPanel = panel1;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        UILauncher.changePanel(newPanel);
    }
}
