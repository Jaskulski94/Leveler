package com.jaskulski.app.UI;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;

public class ShowSCFrame extends JFrame {
    private StartingConditions startingConditions;

    public ShowSCFrame(StartingConditions startingConditions1){
        this.startingConditions = startingConditions1;

        this.setSize(UIParameters.dimFrame);

        CheckProjectInitiatorPanel CheckPIPanel = new CheckProjectInitiatorPanel();
        this.add(CheckPIPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public class CheckProjectInitiatorPanel extends NewProjectInitiatorPanel{
        public CheckProjectInitiatorPanel(){

        }
        public void completeFields(){

        }
    }


}
