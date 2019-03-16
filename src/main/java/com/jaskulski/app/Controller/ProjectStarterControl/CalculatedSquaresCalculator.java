package com.jaskulski.app.Controller.ProjectStarterControl;

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

    public CalculatedSquaresCalculator(StartingConditions startingConditions1, SquareGrid squareGrid1) {
        this.startingConditions = startingConditions1;
        this.squareGrid = squareGrid1;
        this.sGSizeX = squareGrid1.squareCorners.length;
        this.sGsizeY = squareGrid1.squareCorners[0].length;
        this.cSSizeX = sGSizeX - 1;
        this.cSSizeY = sGsizeY - 1;
        this.squareSize = startingConditions.getSquareSide();
    }

    public void setCSSizes() {
        calculatedSquares.squares = new CalculatedSquares.SingleSquare[cSSizeX][cSSizeY];
    }

    public void setSingleSquare(){
        double LeftTop, RightTop, LeftDown, RightDown;
        int index = 1;
        for (int j = 0; j < cSSizeY; j++) {
            for (int i = 0; i < cSSizeX; i++) {
                LeftTop = squareGrid.squareCorners[i][j].getProjectOrdinate();
                RightTop = squareGrid.squareCorners[i][j + 1].getProjectOrdinate();
                LeftDown = squareGrid.squareCorners[i + 1][j].getProjectOrdinate();
                RightDown = squareGrid.squareCorners[i + 1][j + 1].getProjectOrdinate();

                calculatedSquares.squares[i][j].setIndex(index++);
                calculatedSquares.squares[i][j].setFourCornersXAndY(i, j, squareSize);
                calculatedSquares.squares[i][j].setFourCornersH(LeftTop, RightTop, LeftDown, RightDown);
            }
        }
    }

    public void checkAndSetZeroPoints() {
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
