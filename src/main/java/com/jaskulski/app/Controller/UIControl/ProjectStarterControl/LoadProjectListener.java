package com.jaskulski.app.Controller.UIControl.ProjectStarterControl;

import com.jaskulski.app.Controller.DataHandling.StartingConditionsHandling.StartingConditionsSerializer;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.UILauncherFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadProjectListener implements ActionListener {

    private UILauncherFrame UILauncher;
    private StartingConditions startingConditions;
    private StartingConditionsSerializer startingConditionsSerializer;

    public LoadProjectListener(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
        startingConditionsSerializer = new StartingConditionsSerializer(UILauncher);
    }

    public void actionPerformed(ActionEvent arg0) {
        loadDataFromSelected();
    }

    private void loadDataFromSelected() {
        loadStartingConditions();
        loadTerrainMatrix();
    }

    private void loadStartingConditions() {
        startingConditions = startingConditionsSerializer.deserializeSCFromChooser();
    }

    private void loadTerrainMatrix() {

    }
}
