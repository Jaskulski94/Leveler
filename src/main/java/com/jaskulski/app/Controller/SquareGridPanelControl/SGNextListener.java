package com.jaskulski.app.Controller.SquareGridPanelControl;

import com.jaskulski.app.Controller.CalculatedSquaresHandling.CalculatedSquaresCalculator;
import com.jaskulski.app.Controller.ChangePanelListener;
import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;

public class SGNextListener extends ChangePanelListener {
    public StartingConditions startingConditions;
    public SquareGrid squareGrid;
    public CalculatedSquares calculatedSquares;
    public CalculatedSquaresCalculator cSCalculator;

    public SGNextListener(UILauncherFrame UILauncher1, JPanel newPanel1, StartingConditions sC1, SquareGrid sG1) {
        super(UILauncher1, newPanel1);
        this.startingConditions = sC1;
        this.squareGrid = sG1;
        this.calculatedSquares = new CalculatedSquares();
        this.cSCalculator = new CalculatedSquaresCalculator(startingConditions, squareGrid, calculatedSquares);
    }

    public void changeAction(){
        cSCalculator.calculateCS();
        super.changeAction();
        System.out.println("Zrobiono");
    }

}
