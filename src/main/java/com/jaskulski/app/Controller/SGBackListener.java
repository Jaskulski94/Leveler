package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.NewProjectInitiatorPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SGBackListener extends BackListener {
    public SGBackListener(UILauncherFrame UILauncher1, JPanel panel1) {
        super(UILauncher1, panel1);
    }

    public void backAction(){
        StartingConditionsHandler sCHandler = new StartingConditionsHandler();
        StartingConditions startingConditions = sCHandler.deserializeSCFromFixedPath();
        StartingConditionsFiller sCFiller = new StartingConditionsFiller(startingConditions, (NewProjectInitiatorPanel) newPanel);
        sCFiller.fillFields();
        super.backAction();

    }
}

