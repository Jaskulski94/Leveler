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
        System.out.println("Rzędna płaszczyzny bilansowej: " + finalOrdinate);
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
    //    System.out.println("Rzędne projektowe i różnice:");
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
                System.out.format("%.3f | %.3f   ", calculatedOrdiante, calculatedDif);
            }
            System.out.println("");
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
        /*double firstDif;
        double secondDif;
        double calculatedZero;
        double copiedZero;
        double hOfZero;
        double squareSide = startingConditions.getSquareSide();

        for(int i = 0; i<sizeX-1; i++) {
            for (int j = 0; j < sizeY-1; j++) {
                firstDif = squareGrid.squares[i][j].getOrdinateDifference();
                secondDif = squareGrid.squares[i+1][j].getOrdinateDifference();
                if((firstDif*secondDif)<0){
                    calculatedZero = i*squareSide+(firstDif * squareSide)/(firstDif * secondDif);
                    copiedZero = j * squareSide;
                    hOfZero = ordinateOfBalanceSheet()+startingConditions.getFieldLean()*calculatedZero;
                    squareGrid.ListOfZeroPoints.add(squareGrid.getNewZeroPoints(calculatedZero, copiedZero, hOfZero));
                }
            }
        }*/

        for(int i = 0; i<sizeX-1; i++) {
            for (int j = 0; j < sizeY - 1; j++) {
                checkAndAddZeroPoint(i, j, 1, 0);
                checkAndAddZeroPoint(i, j, 0, 1);
            }
        }

        for(SquareGrid.ZeroPoints points : squareGrid.ListOfZeroPoints){
            System.out.println("Punkt zerowy: "+points.xOrdinate+" "+points.yOrdinate+" "+points.hOrdinate);
        }
    }

    private void checkAndAddZeroPoint(int i1, int j1, int x1, int y1){
        double firstDif = squareGrid.squares[i1][j1].getOrdinateDifference();
        double secondDif = squareGrid.squares[i1+x1][j1+y1].getOrdinateDifference();
        double squareSide = startingConditions.getSquareSide();

        if((firstDif*secondDif)<0){
            double calculatedZero = i1 * squareSide + (firstDif * squareSide) / (firstDif * secondDif);
            double copiedZero = j1 * squareSide;
            double hOfZero = ordinateOfBalanceSheet() + startingConditions.getFieldLean() * calculatedZero;
            if(x1 == 1) {
                squareGrid.ListOfZeroPoints.add(squareGrid.getNewZeroPoints(calculatedZero, copiedZero, hOfZero));
            } else if (y1 == 1){
                squareGrid.ListOfZeroPoints.add(squareGrid.getNewZeroPoints(copiedZero, calculatedZero, hOfZero));
            }
        }
    }
}
