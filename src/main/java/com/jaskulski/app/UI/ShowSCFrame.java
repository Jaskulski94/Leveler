package com.jaskulski.app.UI;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;

public class ShowSCFrame extends UILauncherFrame {
    private StartingConditions startingConditions;

    public ShowSCFrame(StartingConditions startingConditions1){
        this.startingConditions = startingConditions1;
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        CheckProjectInitiatorPanel CheckPIPanel = new CheckProjectInitiatorPanel(this);
    }

    public class CheckProjectInitiatorPanel extends NewProjectInitiatorPanel{
        public CheckProjectInitiatorPanel(UILauncherFrame UILauncher1){
            this.UILauncher = UILauncher1;
        }
        public void completeFields(){

        }
    }


}
