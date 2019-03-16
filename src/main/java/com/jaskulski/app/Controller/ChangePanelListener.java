package com.jaskulski.app.Controller;

import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePanelListener implements ActionListener {

    protected UILauncherFrame UILauncher;
    protected JPanel newPanel;

    public ChangePanelListener(UILauncherFrame UILauncher1, JPanel newPanel1) {
        this.UILauncher = UILauncher1;
        this.newPanel = newPanel1;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        changeAction();
    }

    public void changeAction(){
        UILauncher.changePanel(newPanel);
    }
}
