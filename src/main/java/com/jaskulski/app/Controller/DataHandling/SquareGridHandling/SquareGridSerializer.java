package com.jaskulski.app.Controller.DataHandling.SquareGridHandling;

import com.jaskulski.app.Controller.DataHandling.BasicSerializer;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.ProjectStarterPanel;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import java.io.File;

public class SquareGridSerializer extends BasicSerializer {
    private UILauncherFrame UILauncher;
    private StartingConditions startingConditions;

    public SquareGridSerializer() {
    }

    public SquareGridSerializer(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public void serializeSquareGrid(SquareGrid squareGrid1) {
        super.serialize(squareGrid1, "/SquareGrid.ser");
    }

    public SquareGrid deserializeSCFromFixedPath() {
        return ((SquareGrid) super.deserializeFromFixedPath("/SquareGrid.ser"));
    }

    public SquareGrid deserializeWithUI(File selectedFile) {
        newPanel = new SquareGridPanel(UILauncher);
        errorPanel = new ProjectStarterPanel(UILauncher);

        SquareGrid squareGrid = (SquareGrid) super.deserializeWithUI(selectedFile);
        ((SquareGridPanel) newPanel).setStartingConditionsAndInitiate(startingConditions);
        super.changeToNextPanel(UILauncher);
        return squareGrid;
    }
}
