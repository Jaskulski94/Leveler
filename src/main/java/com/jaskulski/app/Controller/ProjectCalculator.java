package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;

public class ProjectCalculator {
    private StartingConditions startingConditions;
    private SquareGrid squareGrid;
    private int sizeX, sizeY;

    public ProjectCalculator (StartingConditions startingConditions1, SquareGrid squareGrid1){
        this.startingConditions = startingConditions1;
        this.squareGrid = squareGrid1;
        sizeX = squareGrid.squares[0].length;
        sizeY = squareGrid.squares[1].length;

    }

    public void calculationOfOrdinatesOfBalanceSheet(){

    }

    public double ordinateOfBalanceSheet(){
        double finalOrdinate;
        double oneSquareOrdianate=0, twoSquaresOrdinate=0, fourSquaresOrdinate=0;
        Boolean xCurb, yCurb;
        double amountOfSquare = sizeX * sizeY;

        for(int i = 0; i<sizeX; i++) {
            for (int j = 0; j < sizeX; j++) {
                xCurb = checkIfCurb(i, sizeX);
                yCurb = checkIfCurb(j, sizeY);
                if(xCurb || yCurb){
                    if(xCurb && yCurb){
                        oneSquareOrdianate += squareGrid.squares[i][j].initialValue;
                    } else{
                        twoSquaresOrdinate += squareGrid.squares[i][j].initialValue;
                    }
                } else{
                    fourSquaresOrdinate += squareGrid.squares[i][j].initialValue;
                }
            }
        }

        finalOrdinate = (1/(4*amountOfSquare))*(oneSquareOrdianate + 2*twoSquaresOrdinate + 4*fourSquaresOrdinate);
        return finalOrdinate;
    }

    private boolean checkIfCurb(int index1, int size1){
        if (index1 == 0 || index1  == (size1-1)){
            return true;
        } else{
            return false;
        }
    }


}
