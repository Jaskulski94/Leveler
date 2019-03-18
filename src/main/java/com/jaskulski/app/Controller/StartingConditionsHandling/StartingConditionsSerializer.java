package com.jaskulski.app.Controller.StartingConditionsHandling;

import com.jaskulski.app.Controller.BasicSerializer;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.ProjectStarterPanel;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;
import java.io.*;


public class StartingConditionsSerializer extends BasicSerializer {
    private UILauncherFrame UILauncher;

    public StartingConditionsSerializer(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public StartingConditionsSerializer() {
    }

    public void serializeStartingConditions(StartingConditions startingConditions1) {
        super.serialize(startingConditions1, "/StartingConditions.ser");
    }

    public StartingConditions deserializeSCFromChooser() {
        return ((StartingConditions) super.deserializeFromChooser());
    }

    public StartingConditions deserializeSCFromFixedPath() {
        return ((StartingConditions) super.deserializeFromFixedPath("/StartingConditions.ser"));
    }

    public StartingConditions deserializeWithUI(File selectedFile) {
        newPanel = new SquareGridPanel(UILauncher);
        errorPanel = new ProjectStarterPanel(UILauncher);

        StartingConditions startingConditions = (StartingConditions) super.deserializeWithUI(selectedFile);
        ((SquareGridPanel)newPanel).setStartingConditionsAndInitiate(startingConditions);
        super.changeToNextPanel(UILauncher);
        return startingConditions;
    }
}
