package com.jaskulski.app.Controller.UIControl.SquareGridPanelControl;

import com.jaskulski.app.Controller.DataHandling.CalculatedSquaresHandling.CalculatedSquaresCalculator;
import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.CalculatedSquaresUI.CalculatedSquaresFrame;
import com.jaskulski.app.UI.CalculatedSquaresUI.CalculatedSquaresPanel;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SGNextListener extends SGSaveListener {
    public StartingConditions startingConditions;
    private CalculatedSquares calculatedSquares;
    private CalculatedSquaresCalculator cSCalculator;
    private CalculatedSquaresFrame cSFrame;

    public SGNextListener(SquareGrid sG1, StartingConditions sC1, SquareGridPanel sGPanel1) {
        super(sG1, sC1, sGPanel1);
        this.startingConditions = sC1;
        this.calculatedSquares = new CalculatedSquares();
        this.cSCalculator = new CalculatedSquaresCalculator(startingConditions, squareGrid, calculatedSquares);
        this.calculatedSquares.setSizes(cSCalculator.getCSSizeX(), cSCalculator.getCSSizeY());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        super.actionPerformed(actionEvent);
        initiateNewFrameAction();
    }

    protected void calculateAction(){
        super.calculateAction();
        cSCalculator.calculateCS();
    }

    private void initiateNewFrameAction() {
        cSFrame = new CalculatedSquaresFrame();
        CalculatedSquaresPanel pnlCS = new CalculatedSquaresPanel(calculatedSquares);
        JScrollPane scroller = new JScrollPane(pnlCS);
        cSFrame.add(scroller, BorderLayout.CENTER);
    }
}
