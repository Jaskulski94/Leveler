package com.jaskulski.app.Controller.SquareGridPanelControl;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import java.awt.event.ActionEvent;

public class SGNextListener extends SGSaveListener {

    public SGNextListener (SquareGrid squareGrid1, SquareGridPanel sGPanel1){
        super(squareGrid1, sGPanel1);
    }

    public void actionPerformed(ActionEvent actionEvent) {
        serializeAction();
        calculateFromSquareGrid();
    }

    private void calculateFromSquareGrid(){

    }
}
