package com.jaskulski.app.UI;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;

public class ShowSCFrame extends JFrame {
    private StartingConditions startingConditions;

    public ShowSCFrame(StartingConditions startingConditions1) {
        this.startingConditions = startingConditions1;

        this.setSize(UIParameters.dimFrame);

        CheckProjectInitiatorPanel checkPIPanel = new CheckProjectInitiatorPanel();
        checkPIPanel.fillFields();

        this.add(checkPIPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setEnabled(false);
    }

    public class CheckProjectInitiatorPanel extends NewProjectInitiatorPanel {

        public CheckProjectInitiatorPanel() {
        }

        public void fillFields() {
            fillSlope(this.pnlASlope, startingConditions.slopeX);
            fillSlope(this.pnlBSlope, startingConditions.slopeY);

            fillRest(this, startingConditions);
        }

        public void fillSlope(CheckProjectInitiatorPanel.SlopeInitiator slope1, StartingConditions.Slope slopeSC1) {
            slope1.txtSide.setText(Double.toString(slopeSC1.getSide()));

            if (slopeSC1.getSlopeTilt() > 0) {
                slope1.rBtnSlopeTilt.setSelected(true);
                slope1.txtSlopeValue.setText(Double.toString(slopeSC1.getSlopeTilt()));
            } else if (slopeSC1.getSlopeWidth() > 0) {
                slope1.rBtnSlopeWidth.setSelected(true);
                slope1.txtSlopeValue.setText(Double.toString(slopeSC1.getSlopeWidth()));
            }
        }

        public void fillRest(CheckProjectInitiatorPanel CPIPanel1, StartingConditions startingConditions1) {
            CPIPanel1.txtSquares.setText(Double.toString(startingConditions1.getSquareSide()));
            CPIPanel1.txtField.setText(Double.toString(startingConditions1.getFieldLean()));
        }
    }


}
