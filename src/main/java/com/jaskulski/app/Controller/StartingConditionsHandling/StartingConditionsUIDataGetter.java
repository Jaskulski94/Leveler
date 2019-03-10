package com.jaskulski.app.Controller.StartingConditionsHandling;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.NewProjectInitiatorPanel;

import javax.swing.*;

public class StartingConditionsUIDataGetter {
    private NewProjectInitiatorPanel nPIPanel;
    private StartingConditions startingConditions;

    public StartingConditionsUIDataGetter(NewProjectInitiatorPanel nPIPanel1, StartingConditions startingConditions1){
        this.nPIPanel = nPIPanel1;
        this.startingConditions = startingConditions1;
    }

    public void setStartingConditionsFromUI() {
        try {
            saveAllValues(nPIPanel, startingConditions);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Błąd: Zły typ wprowadzonych danych");
        }
    }

    private void saveAllValues(NewProjectInitiatorPanel nPIPanel1, StartingConditions startingConditions1){
        saveSlopeValues(nPIPanel.getSlopeA(), startingConditions.getSlopeX());
        saveSlopeValues(nPIPanel.getSlopeB(), startingConditions.getSlopeY());
        saveSlopeValues(nPIPanel, startingConditions);
        startingConditions.setSizes();
    }

    private void saveSlopeValues (NewProjectInitiatorPanel.SlopeInitiator nPISlope1, StartingConditions.Slope sCSlope1){
        sCSlope1.setSide(nPISlope1.getSide());
        sCSlope1.setSlopeWidth(nPISlope1.getSlopeWidth());
        sCSlope1.setSlopeTilt(nPISlope1.getSlopeTilt());
    }

    private void saveSlopeValues (NewProjectInitiatorPanel nPIPanel1, StartingConditions startingConditions1){
        startingConditions1.setSquareSide(nPIPanel1.getTxtSquares());
        startingConditions1.setFieldLean(nPIPanel1.getTxtField());
    }
}
