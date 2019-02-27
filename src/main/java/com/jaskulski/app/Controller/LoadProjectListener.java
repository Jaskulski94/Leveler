package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadProjectListener implements ActionListener {
    StartingConditions startingConditions = new StartingConditions();
    StartingConditionsHandler startingConditionsHandler = new StartingConditionsHandler();

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
