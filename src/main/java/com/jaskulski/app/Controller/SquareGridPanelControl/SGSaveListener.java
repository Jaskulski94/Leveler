package com.jaskulski.app.Controller.SquareGridPanelControl;

import com.jaskulski.app.Controller.SquareGridHanding.SquareGridSerializer;
import com.jaskulski.app.Controller.SquareGridHanding.SquareGrindUIDataGetter;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGSaveListener implements ActionListener {

    protected SquareGridSerializer sQSerializer;
    protected SquareGrid squareGrid;
    protected SquareGridPanel sGPanel;
    protected SquareGrindUIDataGetter sGUIDGetter;

    public SGSaveListener (SquareGrid squareGrid1, SquareGridPanel sGPanel1){
        this.squareGrid = squareGrid1;
        this.sGPanel = sGPanel1;
        this.sGUIDGetter = new SquareGrindUIDataGetter(sGPanel, squareGrid);
        this.sQSerializer = new SquareGridSerializer();
    }

    public void actionPerformed(ActionEvent actionEvent) {
        serializeAction();
    }

    protected void serializeAction(){
        sGUIDGetter.setSquareGridFromUI();
        sQSerializer.serializeSquareGrid(squareGrid);
    }
}
