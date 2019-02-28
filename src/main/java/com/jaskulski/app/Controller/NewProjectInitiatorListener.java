package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.NewProjectInitiatorPanel;
import com.jaskulski.app.UI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectInitiatorListener implements ActionListener {

    private NewProjectInitiatorPanel npiPanel;
    private StartingConditions startingConditions;
    private double side, slopeWidth, slopeTilt;
    private UILauncherFrame UILauncher;
    private int sizeX, sizeY;
    private StartingConditionsHandler startingConditionsHandler;

    public NewProjectInitiatorListener(UILauncherFrame UILauncher1, NewProjectInitiatorPanel npiPanel1) {
        this.npiPanel = npiPanel1;
        this.UILauncher = UILauncher1;
        startingConditionsHandler = new StartingConditionsHandler(UILauncher);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        startingConditions = new StartingConditions();
        setStartingConditions();

        getSizes();

        startingConditionsHandler.serializeStartingConditions(startingConditions);
    }

    private void setStartingConditions() {
        try {
            getSlopeValues(npiPanel.getSlopeA());
            setSlopeValues(startingConditions.getSlopeX());

            getSlopeValues(npiPanel.getSlopeB());
            setSlopeValues(startingConditions.getSlopeY());

            startingConditions.setSquareSide(npiPanel.getTxtSquares());
            startingConditions.setFieldLean(npiPanel.getTxtField());

            getSizes();
            UILauncher.changePanel(new SquareGridPanel(sizeX, sizeY));

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

        checkIfDivisible(startingConditions.slopeX, "X");
        checkIfDivisible(startingConditions.slopeY, "Y");
    }

    private void checkIfDivisible(StartingConditions.Slope slope1, String sideName) {
        String warningText1 = "Ostrzeżenie: Długość boku " + sideName + " nie jest podzielna przez długość boku kwadratu siatki.";
        String warningText2 = "Ilość kwadratów siatki została zaokrąglona w dół.";

        startingConditionsHandler.getStartingConditions(startingConditions);
        if (!startingConditionsHandler.checkIfDivisible(slope1)){
            JOptionPane.showMessageDialog(null, warningText1 + "\n" + warningText2);
        }
    }
}
