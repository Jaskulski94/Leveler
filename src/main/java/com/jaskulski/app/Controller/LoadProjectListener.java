package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.UILauncherFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadProjectListener implements ActionListener {

    UILauncherFrame UILauncher;
    StartingConditions startingConditions = new StartingConditions();
    StartingConditionsHandler startingConditionsHandler;

    public LoadProjectListener (UILauncherFrame UILauncher1){
        this.UILauncher = UILauncher1;
        startingConditionsHandler = new StartingConditionsHandler(UILauncher);
    }

    public void actionPerformed(ActionEvent arg0) {
        loadDataFromSelected();
    }

    private void loadDataFromSelected() {
        loadStartingConditions();
        loadTerrainMatrix();
    }

    private void loadStartingConditions() {
        startingConditionsHandler.deserializeStartingConditions(startingConditions);
    }

    private void loadTerrainMatrix() {

    }
}
