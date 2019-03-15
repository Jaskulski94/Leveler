package com.jaskulski.app.Controller.SquareGridPanelControl;

import com.jaskulski.app.Controller.ProjectCalculator;
import com.jaskulski.app.Controller.SquareGridHanding.SquareGridSerializer;
import com.jaskulski.app.Controller.SquareGridHanding.SquareGrindUIDataGetter;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGSaveListener implements ActionListener {

    private SquareGridSerializer sQSerializer;
    private SquareGrid squareGrid;
    private SquareGridPanel sGPanel;
    private SquareGrindUIDataGetter sGUIDGetter;
    private ProjectCalculator projectCalculator;

    public SGSaveListener (SquareGrid squareGrid1, StartingConditions startingConditions1, SquareGridPanel sGPanel1){
        this.squareGrid = squareGrid1;
        this.sGPanel = sGPanel1;
        this.projectCalculator = new ProjectCalculator(startingConditions1, squareGrid1);
        this.sGUIDGetter = new SquareGrindUIDataGetter(sGPanel, squareGrid);
        this.sQSerializer = new SquareGridSerializer();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        serializeAction();
        calculateAction();
    }

    protected void serializeAction(){
        sGUIDGetter.setSquareGridFromUI();
        sQSerializer.serializeSquareGrid(squareGrid);
    }

    protected void calculateAction(){
        projectCalculator.setSGProjectOrdinates();
        projectCalculator.findZeroPoints();
    }
}
