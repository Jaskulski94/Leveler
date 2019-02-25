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
    int sizeX, sizeY;

    public NewProjectInitiatorListener(NewProjectInitiatorPanel npiPanel1) {
        this.npiPanel = npiPanel1;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        startingConditions = new StartingConditions();
        setStartingConditions();

        getSizes();

        //serialize startingConditions
    }

    private void setStartingConditions() {
        try {
            getSlopeValues(npiPanel.getSlopeA());
            setSlopeValues(startingConditions.getSlopeX());

            getSlopeValues(npiPanel.getSlopeB());
            setSlopeValues(startingConditions.getSlopeY());

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

    private void getSizes() {
        startingConditions.setSizes();
        sizeX = startingConditions.getSizeX();
        sizeY = startingConditions.getSizeY();

        checkIfDivisible(startingConditions.slopeX);
        checkIfDivisible(startingConditions.slopeY);
    }

    private void checkIfDivisible(StartingConditions.Slope slope1) {
        double checkedSize = slope1.getSide() / startingConditions.getSquareSide();
        String slopeName = slope1.getClass().getName();
        String warningText1 = "Ostrzeżenie: Długość boku " + slopeName + " nie jest podzielna przez długość boku kwadratu siatki.";
        String warningText2 = "Ilość kwadratów siatki została zaokrąglona w dół.";
        if (!(checkedSize == Math.floor(checkedSize))) {
            JOptionPane.showMessageDialog(null, warningText1 + "\n" + warningText2);
        }
    }
}
