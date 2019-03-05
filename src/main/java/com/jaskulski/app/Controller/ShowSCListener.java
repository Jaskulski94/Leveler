package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ShowSCFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowSCListener implements ActionListener {

    private StartingConditions startingConditions;

    public void actionPerformed(ActionEvent actionEvent) {
        StartingConditionsHandler startingConditionsHandler = new StartingConditionsHandler();
        startingConditions = startingConditionsHandler.deserializeSCFromFixedPath();
        ShowSCFrame showSCFrame = new ShowSCFrame(startingConditions);
    }
}
