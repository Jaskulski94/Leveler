package com.jaskulski.app.Controller.SquareGridPanelControl;

import com.jaskulski.app.Controller.ProjectCalculator;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import java.awt.event.ActionEvent;

public class SGNextListener extends SGSaveListener {

    private ProjectCalculator projectCalculator;

    public SGNextListener (SquareGrid squareGrid1, SquareGridPanel sGPanel1, StartingConditions startingConditions1){
        super(squareGrid1, sGPanel1);
        projectCalculator = new ProjectCalculator(startingConditions1, squareGrid1);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        serializeAction();
        calculateFromSquareGrid();
    }

    private void calculateFromSquareGrid(){
        projectCalculator.setSGProjectOrdinates();
        projectCalculator.findZeroPoints();
    }
}
