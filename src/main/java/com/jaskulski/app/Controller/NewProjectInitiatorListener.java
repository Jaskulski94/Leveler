package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.NewProjectInitiatorPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectInitiatorListener implements ActionListener {

    private NewProjectInitiatorPanel npiPanel;
    private StartingConditions startingConditions;
    private double side, slopeWidth, slopeTilt;

    public NewProjectInitiatorListener(NewProjectInitiatorPanel npiPanel1) {
        this.npiPanel = npiPanel1;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        startingConditions = new StartingConditions();
        setStartingConditions();

        //serialize startingConditions
    }

    private void setStartingConditions() {
        try {
            getSlopeValues(npiPanel.getSlopeA());
            setSlopeValues(startingConditions.getSlopeA());

            getSlopeValues(npiPanel.getSlopeB());
            setSlopeValues(startingConditions.getSlopeB());

            startingConditions.setSquareSide(npiPanel.getTxtSquares());
            startingConditions.setFieldLean(npiPanel.getTxtField());

            startingConditions.printAll();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Błąd: Zły typ wprowadzonych danych");
        }
    }

    private void getSlopeValues(NewProjectInitiatorPanel.SlopeInitiator slope1) throws NumberFormatException {
        side = slope1.getSide();
        slopeWidth = slope1.getSlopeWidth();
        slopeTilt = slope1.getSlopeTilt();
    }

    private void setSlopeValues(StartingConditions.Slope slope1) {
        slope1.setSide(side);
        slope1.setSlopeWidth(slopeWidth);
        slope1.setSlopeTilt(slopeTilt);
    }
}
