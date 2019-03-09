package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.NewProjectInitiatorPanel;

import javax.swing.*;

public class StartingConditionsDataGetter {
    private NewProjectInitiatorPanel nPIPanel;
    private StartingConditions startingConditions;

    public StartingConditionsDataGetter(NewProjectInitiatorPanel nPIPanel1, StartingConditions startingConditions1){
        this.nPIPanel = nPIPanel1;
        this.startingConditions = startingConditions1;
    }

    public void setStartingConditions() {
        try {
            saveSlopeValues(nPIPanel.getSlopeA(), startingConditions.getSlopeX());
            saveSlopeValues(nPIPanel.getSlopeB(), startingConditions.getSlopeY());
            saveSlopeValues(nPIPanel, startingConditions);
            startingConditions.setSizes();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Błąd: Zły typ wprowadzonych danych");
        }
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
