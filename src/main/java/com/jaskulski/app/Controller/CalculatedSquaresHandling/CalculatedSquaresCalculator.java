package com.jaskulski.app.Controller.CalculatedSquaresHandling;

import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

public class CalculatedSquaresCalculator {
    private SquareGrid squareGrid;
    private StartingConditions startingConditions;
    private CalculatedSquares calculatedSquares;
    private int sGSizeX;
    private int sGsizeY;
    private int cSSizeX;
    private int cSSizeY;
    private double squareSize;

    public CalculatedSquaresCalculator(StartingConditions sC1, SquareGrid sG1, CalculatedSquares cS1) {
        this.startingConditions = sC1;
        this.squareGrid = sG1;
        this.calculatedSquares = cS1;
        this.cSSizeX = sG1.squareCorners.length - 1;
        this.cSSizeY = sG1.squareCorners[0].length - 1;
        this.squareSize = startingConditions.getSquareSide();
    }

    public void calculateCS(){
        setCSSizes();
        setAllSquares();
        checkAndSetZeroPoints();

    }

    private void setCSSizes() {
        calculatedSquares.squares = new CalculatedSquares.SingleSquare[cSSizeX][cSSizeY];
    }

    private void setAllSquares(){
        double LeftTop, RightTop, LeftDown, RightDown;
        int index = 1;
        for (int j = 0; j < cSSizeY; j++) {
            for (int i = 0; i < cSSizeX; i++) {
                LeftTop = squareGrid.squareCorners[i][j].getProjectOrdinate();
                RightTop = squareGrid.squareCorners[i][j + 1].getProjectOrdinate();
                LeftDown = squareGrid.squareCorners[i + 1][j].getProjectOrdinate();
                RightDown = squareGrid.squareCorners[i + 1][j + 1].getProjectOrdinate();
                calculatedSquares.squares[i][j] = calculatedSquares.new SingleSquare();
                calculatedSquares.squares[i][j].setIndex(index++);
                calculatedSquares.squares[i][j].setFourCornersXAndY(i, j, squareSize);
                calculatedSquares.squares[i][j].setFourCornersH(LeftTop, RightTop, LeftDown, RightDown);
            }
        }
    }

    private void checkAndSetZeroPoints() {
        for (SquareGrid.ZeroPoint point : squareGrid.listOfZeroPoints) {
            int simplifiedX = (int) point.getIndexX();
            int simplifiedY = (int) point.getIndexY();
            double newX = point.getIndexX() * squareSize;
            double newY = point.getIndexY() * squareSize;
            double newH = point.getOrdinateH();
            calculatedSquares.squares[simplifiedX][simplifiedY].addNewZeroPoint(newX, newY, newH);
        }
    }
}
