package com.jaskulski.app.UI.SquareGridUI;

import com.jaskulski.app.Controller.DataHandling.StartingConditionsHandling.StartingConditionsFiller;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.NewProjectInitiatorPanel;
import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;

public class ShowSCFrame extends JFrame {
    private StartingConditions startingConditions;
    private StartingConditionsFiller sCFiller;

    public ShowSCFrame(StartingConditions startingConditions1) {
        this.startingConditions = startingConditions1;

        this.setSize(UIParameters.dimFrame);

        CheckProjectInitiatorPanel checkPIPanel = new CheckProjectInitiatorPanel();
        checkPIPanel.fillAll();

        this.add(checkPIPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setEnabled(false);
    }

    public class CheckProjectInitiatorPanel extends NewProjectInitiatorPanel {

        public CheckProjectInitiatorPanel() {
        }

        public void fillAll(){
            sCFiller = new StartingConditionsFiller(startingConditions, this);
            sCFiller.fillFields();
        }

    }

}
