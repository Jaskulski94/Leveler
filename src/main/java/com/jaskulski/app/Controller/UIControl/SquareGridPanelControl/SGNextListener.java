package com.jaskulski.app.Controller.UIControl.SquareGridPanelControl;

import com.jaskulski.app.Controller.DataHandling.CalculatedSquaresHandling.CalculatedSquaresCalculator;
import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.CalculatedSquaresUI.CalculatedSquaresFrame;
import com.jaskulski.app.UI.CalculatedSquaresUI.CalculatedSquaresPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGNextListener implements ActionListener {
    public StartingConditions startingConditions;
    private SquareGrid squareGrid;
    private CalculatedSquares calculatedSquares;
    private CalculatedSquaresCalculator cSCalculator;
    private CalculatedSquaresFrame cSFrame;

    public SGNextListener(StartingConditions sC1, SquareGrid sG1) {
        this.startingConditions = sC1;
        this.squareGrid = sG1;
        this.calculatedSquares = new CalculatedSquares();
        this.cSCalculator = new CalculatedSquaresCalculator(startingConditions, squareGrid, calculatedSquares);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        calculateAction();
        initiateNewFrameAction();
    }

    private void calculateAction(){
        cSCalculator.calculateCS();
    }

    private void initiateNewFrameAction() {
        cSFrame = new CalculatedSquaresFrame();
        CalculatedSquaresPanel pnlCS = new CalculatedSquaresPanel(cSCalculator.getCSSizeX(), cSCalculator.getCSSizeY());
        JScrollPane scroller = new JScrollPane(pnlCS);
        cSFrame.add(scroller, BorderLayout.CENTER);
    }
}
