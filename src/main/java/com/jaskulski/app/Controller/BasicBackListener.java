package com.jaskulski.app.Controller;

import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasicBackListener implements ActionListener {

    private UILauncherFrame UILauncher;
    public JPanel newPanel;

    public BasicBackListener(UILauncherFrame UILauncher1, JPanel panel1){
        this.UILauncher = UILauncher1;
        this.newPanel = panel1;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        backAction();
    }

    public void backAction(){
        UILauncher.changePanel(newPanel);
    }
}
