package com.jaskulski.app.Controller.UIControl.SquareGridPanelControl;

import com.jaskulski.app.Controller.DataHandling.SquareGridHandling.SquareGridCalculator;
import com.jaskulski.app.Controller.DataHandling.SquareGridHandling.SquareGridSerializer;
import com.jaskulski.app.Controller.DataHandling.SquareGridHandling.SquareGridUIDataGetter;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGSaveListener implements ActionListener {

    private SquareGridSerializer sQSerializer;
    protected SquareGrid squareGrid;
    private SquareGridUIDataGetter sGUIDGetter;
    private SquareGridCalculator sGCalculator;

    public SGSaveListener(SquareGrid squareGrid1, StartingConditions startingConditions1, SquareGridPanel sGPanel1) {
        this.squareGrid = squareGrid1;
        this.sGCalculator = new SquareGridCalculator(startingConditions1, squareGrid1);
        this.sGUIDGetter = new SquareGridUIDataGetter(sGPanel1, squareGrid);
        this.sQSerializer = new SquareGridSerializer();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        serializeAction();
        calculateAction();
    }

    private void serializeAction() {
        sGUIDGetter.setSquareGridFromUI();
        sQSerializer.serializeSquareGrid(squareGrid);
    }

    protected void calculateAction() {
        sGCalculator.setSGProjectOrdinates();
        sGCalculator.findZeroPoints();
    }
}
