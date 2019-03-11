package com.jaskulski.app.Controller.SquareGridPanelControl;

import com.jaskulski.app.Controller.BasicBackListener;
import com.jaskulski.app.Controller.StartingConditionsHandling.StartingConditionsFiller;
import com.jaskulski.app.Controller.StartingConditionsHandling.StartingConditionsSerializer;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.NewProjectInitiatorPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;

public class SGBackListener extends BasicBackListener {
    public SGBackListener(UILauncherFrame UILauncher1, JPanel panel1) {
        super(UILauncher1, panel1);
    }

    public void backAction(){
        StartingConditionsSerializer sCSerializer = new StartingConditionsSerializer();
        StartingConditions startingConditions = sCSerializer.deserializeSCFromFixedPath();
        StartingConditionsFiller sCFiller = new StartingConditionsFiller(startingConditions, (NewProjectInitiatorPanel) newPanel);
        sCFiller.fillFields();
        super.backAction();

    }
}

