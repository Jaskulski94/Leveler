package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterPanel;
import com.jaskulski.app.UI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.io.*;


public class StartingConditionsHandler extends SerializationHanlder{
    private UILauncherFrame UILauncher;

    public StartingConditionsHandler(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public StartingConditionsHandler() {
    }

    public void serializeStartingConditions(StartingConditions startingConditions1) {
        super.serialize(startingConditions1, "/StartingConditions.ser");
    }

    public StartingConditions deserializeSCFromChooser() {
        StartingConditions startingConditions = (StartingConditions) super.deserializeFromChooser();
        return startingConditions;
    }

    public StartingConditions deserializeSCFromFixedPath() {
        StartingConditions startingConditions = (StartingConditions) super.deserializeFromFixedPath("/StartingConditions.ser");
        return startingConditions;
    }

    public StartingConditions deserializeWithUI(File selectedFile) {
        newPanel = new SquareGridPanel(UILauncher);
        errorPanel = new ProjectStarterPanel(UILauncher);

        StartingConditions startingConditions = (StartingConditions) super.deserializeWithUI(selectedFile);
        ((SquareGridPanel)newPanel).setStartingConditionsAndInitiate(startingConditions);
        super.changeToNextPanel(UILauncher);
        return startingConditions;
    }

    public boolean isDivisible(StartingConditions startingConditions1, StartingConditions.Slope slope1) {
        double checkedSize = slope1.getSide() / startingConditions1.getSquareSide();
        boolean divisible;
        if (checkedSize == Math.floor(checkedSize)) {
            divisible = true;
        } else {
            divisible = false;
        }
        return divisible;
    }

}
