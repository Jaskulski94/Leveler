package com.jaskulski.app.Controller.StartingConditionsHandling;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.NewProjectInitiatorPanel;

public class StartingConditionsFiller {
    private StartingConditions startingConditions;
    private NewProjectInitiatorPanel nPIPanel;

    public StartingConditionsFiller(StartingConditions startingConditions1, NewProjectInitiatorPanel nPIPanel1){
        this.startingConditions = startingConditions1;
        this.nPIPanel = nPIPanel1;
    }

    public void fillFields() {
        fillSlope(nPIPanel.pnlASlope, startingConditions.slopeX);
        fillSlope(nPIPanel.pnlBSlope, startingConditions.slopeY);

        fillRest();
    }

    public void fillSlope(NewProjectInitiatorPanel.SlopeInitiator slope1, StartingConditions.Slope slopeSC1) {
        slope1.txtSide.setText(Double.toString(slopeSC1.getSide()));

        if (slopeSC1.getSlopeTilt() > 0) {
            slope1.rBtnSlopeTilt.setSelected(true);
            slope1.txtSlopeValue.setText(Double.toString(slopeSC1.getSlopeTilt()));
        } else if (slopeSC1.getSlopeWidth() > 0) {
            slope1.rBtnSlopeWidth.setSelected(true);
            slope1.txtSlopeValue.setText(Double.toString(slopeSC1.getSlopeWidth()));
        }
    }

    public void fillRest() {
        nPIPanel.txtSquares.setText(Double.toString(startingConditions.getSquareSide()));
        nPIPanel.txtField.setText(Double.toString(startingConditions.getFieldLean()));
    }
}
