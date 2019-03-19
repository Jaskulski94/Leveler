package com.jaskulski.app.Controller.DataHandling.SquareGridHandling;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

public class SquareGridCalculator {
    private StartingConditions startingConditions;
    private SquareGrid squareGrid;
    private int sizeX, sizeY;
    private int squaresX, squaresY;

    public SquareGridCalculator(StartingConditions startingConditions1, SquareGrid squareGrid1){
        this.startingConditions = startingConditions1;
        this.squareGrid = squareGrid1;
        sizeX = squareGrid.squareCorners.length;
        sizeY = squareGrid.squareCorners[0].length;
        squaresX = sizeX - 1;
        squaresY = sizeY - 1;
    }

    private double ordinateOfBalanceSheet(){
        double finalOrdinate;
        double oneSquareOrdianate=0, twoSquaresOrdinate=0, fourSquaresOrdinate=0;
        Boolean xCurb, yCurb;
        double amountOfSquare = squaresX * squaresY;

        for (int j = 0; j < sizeY; j++) {
            for(int i = 0; i<sizeX; i++) {
                xCurb = checkIfCurb(i, sizeX);
                yCurb = checkIfCurb(j, sizeY);
                if(xCurb || yCurb){
                    if(xCurb && yCurb){
                        oneSquareOrdianate += squareGrid.squareCorners[i][j].terrainOrdinate;
                    } else{
                        twoSquaresOrdinate += squareGrid.squareCorners[i][j].terrainOrdinate;
                    }
                } else{
                    fourSquaresOrdinate += squareGrid.squareCorners[i][j].terrainOrdinate;
                }
            }
        }

        finalOrdinate = (1/(4*amountOfSquare))*(oneSquareOrdianate + 2*twoSquaresOrdinate + 4*fourSquaresOrdinate);
        return finalOrdinate;
    }

    private boolean checkIfCurb(int index1, int size1){
        return (index1 == 0 || index1 == (size1 - 1));
    }

    public void setSGProjectOrdinates(){
        checkLeanDirection();

        double calculatedOrdiante = ordinateOfBalanceSheet();
        double calculatedLean = calculatedOrdiante*startingConditions.getFieldLean()/2/100;
        double calculatedDif;
        calculatedOrdiante += calculatedLean;
        for (int j = 0; j < sizeY; j++) {
            calculatedOrdiante -= calculatedLean*2/sizeY;
            for(int i = 0; i<sizeX; i++) {
                squareGrid.squareCorners[i][j].setProjectOrdinate(calculatedOrdiante);
                calculatedDif = calculatedOrdiante - squareGrid.squareCorners[i][j].terrainOrdinate;
                squareGrid.squareCorners[i][j].setOrdinateDifference(calculatedDif);
                System.out.format("%.2f | %.2f   ", calculatedOrdiante, calculatedDif);
            }
            System.out.println("");
        }
        System.out.println("");
    }

    private void checkLeanDirection() {
        double LeanUp = 0;
        double LeanDown = 0;

        for (int j = 0; j < (sizeY/2); j++) {
            for (int i = 0; i < sizeX; i++) {
                LeanUp += squareGrid.squareCorners[i][j].getTerrainOrdinate();
            }
        }
        for (int j = (sizeY/2); j < sizeY; j++) {
            for (int i = 0; i < sizeX; i++) {
                LeanDown += squareGrid.squareCorners[i][j].getTerrainOrdinate();
            }
        }
        double newLean = Math.abs(startingConditions.getFieldLean()/2);
        if (LeanUp > LeanDown){
            startingConditions.setFieldLean(newLean);
        } else {
            startingConditions.setFieldLean((-1)*newLean);
        }
    }

    public void findZeroPoints(){
        squareGrid.listOfZeroPoints.clear();

        for (int j = 0; j < sizeY; j++) {
            for(int i = 0; i<sizeX; i++) {
                if(i<sizeX-1){
                    checkAndAddZeroPoint(i, j, 1, 0);
                }

                if(j<sizeY-1){
                    checkAndAddZeroPoint(i, j, 0, 1);
                }
            }
        }

        for(SquareGrid.ZeroPoint points : squareGrid.listOfZeroPoints){
            System.out.format("Punkt zerowy: %.2f %.2f %.2f ", points.ordinateX, points.ordinateY, points.ordinateH);
            System.out.println("");
        }
        System.out.println("");
    }

    private void checkAndAddZeroPoint(int i1, int j1, int x1, int y1){
        double firstDif = squareGrid.squareCorners[i1][j1].getOrdinateDifference();
        double secondDif = squareGrid.squareCorners[i1+x1][j1+y1].getOrdinateDifference();
        double squareSide = startingConditions.getSquareSide();
        double calculatedZero;
        double copiedZero;
        double hOfZero;

        if((firstDif*secondDif)<0){
            firstDif = Math.abs(firstDif);
            secondDif = Math.abs(secondDif);
            if(x1 == 1) {
                calculatedZero = i1 * squareSide + ((firstDif * squareSide) / (firstDif + secondDif));
                copiedZero = j1 * squareSide;
                hOfZero = squareGrid.squareCorners[i1][j1].getProjectOrdinate();
                squareGrid.listOfZeroPoints.add(squareGrid.createZeroPoints(calculatedZero, copiedZero, hOfZero));
            } else if (y1 == 1){
                copiedZero = i1 * squareSide;
                calculatedZero = j1 * squareSide + ((firstDif * squareSide) / (firstDif + secondDif));
                hOfZero = ordinateOfBalanceSheet() + startingConditions.getFieldLean() * calculatedZero / 100;
                squareGrid.listOfZeroPoints.add(squareGrid.createZeroPoints(copiedZero, calculatedZero, hOfZero));
            }
        }
    }
}
