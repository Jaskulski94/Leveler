package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.StartingConditionsFiller;
import com.jaskulski.app.Data.StartingConditions;

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
