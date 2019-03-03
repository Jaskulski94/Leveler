package com.jaskulski.app.UI;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;

public class ShowSCFrame extends JFrame {
    StartingConditions startingConditions;

    public ShowSCFrame(StartingConditions startingConditions1){
        this.startingConditions = startingConditions1;

        this.setSize(UIParameters.dimFrame);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        CheckProjectInitiatorPanel CheckPIPanel = new CheckProjectInitiatorPanel();
    }

    public class CheckProjectInitiatorPanel extends NewProjectInitiatorPanel{


        public void completeFields(){

        }
    }


}
