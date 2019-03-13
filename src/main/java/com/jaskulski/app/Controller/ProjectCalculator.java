package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

public class ProjectCalculator {
    private StartingConditions startingConditions;
    private SquareGrid squareGrid;
    private int sizeX, sizeY;
    private int squaresX, squaresY;

    public ProjectCalculator (StartingConditions startingConditions1, SquareGrid squareGrid1){
        this.startingConditions = startingConditions1;
        this.squareGrid = squareGrid1;
        sizeX = squareGrid.squares[0].length;
        sizeY = squareGrid.squares[1].length;
        squaresX = sizeX - 1;
        squaresY = sizeY - 1;
    }

    public void calculateOrdinatesOfBalanceSheet(){

    }

    public double ordinateOfBalanceSheet(){
        double finalOrdinate;
        double oneSquareOrdianate=0, twoSquaresOrdinate=0, fourSquaresOrdinate=0;
        Boolean xCurb, yCurb;
        double amountOfSquare = squaresX * squaresY;

        for(int i = 0; i<sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                xCurb = checkIfCurb(i, sizeX);
                yCurb = checkIfCurb(j, sizeY);
                if(xCurb || yCurb){
                    if(xCurb && yCurb){
                        oneSquareOrdianate += squareGrid.squares[i][j].terrainOrdinate;
                    } else{
                        twoSquaresOrdinate += squareGrid.squares[i][j].terrainOrdinate;
                    }
                } else{
                    fourSquaresOrdinate += squareGrid.squares[i][j].terrainOrdinate;
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

    public void setSGProjectOrdinates(){
        checkLeanDirection();

        double calculatedOrdiante = ordinateOfBalanceSheet();
        double calculatedLean = calculatedOrdiante*startingConditions.getFieldLean()/2/100;
        double calculatedDif;
        calculatedOrdiante += calculatedLean;
        for(int i = 0; i<sizeX; i++) {
            calculatedOrdiante -= calculatedLean*2/sizeY;
            for (int j = 0; j < sizeY; j++) {
                squareGrid.squares[i][j].setProjectOrdinate(calculatedOrdiante);
                calculatedDif = squareGrid.squares[i][j].terrainOrdinate - calculatedOrdiante;
                squareGrid.squares[i][j].setOrdinateDifference(calculatedDif);
            }
        }
    }

    private void checkLeanDirection() {
        double LeanUp = 0;
        double LeanDown = 0;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < (sizeY/2); j++) {
                LeanUp += squareGrid.squares[i][j].getTerrainOrdinate();
            }
        }

        for (int i = 0; i < sizeX; i++) {
            for (int j = (sizeY/2); j < sizeY; j++) {
                LeanDown += squareGrid.squares[i][j].getTerrainOrdinate();
            }
        }
        double newLean = Math.abs(startingConditions.getFieldLean());
        if (LeanUp > LeanDown){
            startingConditions.setFieldLean(newLean);
        } else {
            startingConditions.setFieldLean((-1)*newLean);
        }
    }

    public void findZeroPoints(){
        double firstDif;
        double secondDif;
        double calculatedZero;
        double copiedZero;
        double hOfZero;

        for(int i = 0; i<sizeX-1; i++) {
            for (int j = 0; j < sizeY-1; j++) {
                firstDif = squareGrid.squares[i][j].getOrdinateDifference();
                secondDif = squareGrid.squares[++i][j].getOrdinateDifference();
                if((firstDif*secondDif)<0){
                    calculatedZero = (firstDif * startingConditions.getSquareSide())/(firstDif * secondDif);
                    copiedZero = j * startingConditions.getSquareSide();
                    hOfZero = ordinateOfBalanceSheet()+startingConditions.getFieldLean()*calculatedZero;
                    squareGrid.ListOfZeroPoints.add(squareGrid.getNewZeroPoints(calculatedZero, copiedZero, hOfZero));
                }
            }
        }
    }
}
