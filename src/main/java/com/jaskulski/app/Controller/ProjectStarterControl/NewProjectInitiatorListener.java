package com.jaskulski.app.Controller.ProjectStarterControl;

import com.jaskulski.app.Controller.StartingConditionsHandling.StartingConditionsSerializer;
import com.jaskulski.app.Controller.StartingConditionsHandling.StartingConditionsUIDataGetter;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.NewProjectInitiatorPanel;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectInitiatorListener implements ActionListener {

    private StartingConditionsUIDataGetter sCDGetter;
    private StartingConditions startingConditions;
    private UILauncherFrame UILauncher;
    private StartingConditionsSerializer startingConditionsSerializer;

    public NewProjectInitiatorListener(UILauncherFrame UILauncher1, NewProjectInitiatorPanel nPIPanel1) {
        this.UILauncher = UILauncher1;
        this.startingConditionsSerializer = new StartingConditionsSerializer(UILauncher);
        this.startingConditions = new StartingConditions();
        this.sCDGetter = new StartingConditionsUIDataGetter(nPIPanel1, startingConditions);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        sCDGetter.setStartingConditionsFromUI();

        checkSizes();

        UILauncher.changePanel(new SquareGridPanel(startingConditions, UILauncher));

        startingConditionsSerializer.serializeStartingConditions(startingConditions);
    }

    private void checkSizes() {
        checkIfDivisible(startingConditions.slopeX, "X");
        checkIfDivisible(startingConditions.slopeY, "Y");
    }

    private void checkIfDivisible(StartingConditions.Slope slope1, String sideName) {
        String warningText1 = "Ostrzeżenie: Długość boku " + sideName + " nie jest podzielna przez długość boku kwadratu siatki.";
        String warningText2 = "Ilość kwadratów siatki została zaokrąglona w dół.";

        if (!startingConditions.isDivisible(slope1)) {
            JOptionPane.showMessageDialog(null, warningText1 + "\n" + warningText2);
        }
    }
}
