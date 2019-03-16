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

    public CalculatedSquaresCalculator(StartingConditions startingConditions1, SquareGrid squareGrid1){
        this.startingConditions = startingConditions1;
        this.squareGrid = squareGrid1;
        this.sGSizeX = squareGrid1.squareCorners.length;
        this.sGsizeY = squareGrid1.squareCorners[0].length;
        this.cSSizeX = sGSizeX - 1;
        this.cSSizeY = sGsizeY - 1;
    }

    public void setCSSizes(){
        calculatedSquares.squares = new CalculatedSquares.SingleSquare[cSSizeX][cSSizeY];
    }

    public void setSquaresCorners(){
        double LeftTop, RightTop, LeftDown, RightDown;
        int index = 1;
        for (int j = 0; j< cSSizeY; j++){
            for (int i = 0; i< cSSizeX; i++){
                LeftTop = squareGrid.squareCorners[i][j].getProjectOrdinate();
                RightTop = squareGrid.squareCorners[i][j+1].getProjectOrdinate();
                LeftDown = squareGrid.squareCorners[i+1][j].getProjectOrdinate();
                RightDown = squareGrid.squareCorners[i+1][j+1].getProjectOrdinate();

                calculatedSquares.squares[i][j].setIndex(index);
                index++;

                calculatedSquares.squares[i][j].setLeftTopOrd(LeftTop);
                calculatedSquares.squares[i][j].setRightTopOrd(RightTop);
                calculatedSquares.squares[i][j].setLeftDownOrd(LeftDown);
                calculatedSquares.squares[i][j].setRightDownOrd(RightDown);
            }
        }
    }

    public void checkAndSetZeroPoints(){
        double LeftTop, RightTop, LeftDown, RightDown;
        for (int j = 0; j< cSSizeY; j++) {
            for (int i = 0; i < cSSizeX; i++) {
                LeftTop = calculatedSquares.squares[i][j].getLeftTopOrd();
                RightTop = calculatedSquares.squares[i][j].getRightTopOrd();
                LeftDown = calculatedSquares.squares[i][j].getLeftDownOrd();
                RightDown = calculatedSquares.squares[i][j].getRightDownOrd();

                for(SquareGrid.ZeroPoints point : squareGrid.listOfZeroPoints){
        //            if(point.)
                }
            }
        }
    }
}
