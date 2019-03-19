package com.jaskulski.app.Controller.DataHandling.CalculatedSquaresHandling;

import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

public class CalculatedSquaresCalculator {
    private SquareGrid squareGrid;
    private StartingConditions startingConditions;
    private CalculatedSquares calculatedSquares;
    private int cSSizeX;
    private int cSSizeY;
    private double squareSize;

    public int getCSSizeX(){
        return cSSizeX;
    }

    public int getCSSizeY(){
        return cSSizeY;
    }

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
        double LeftTopT, RightTopT, LeftDownT, RightDownT;

        int index = 1;
        for (int j = 0; j < cSSizeY; j++) {
            for (int i = 0; i < cSSizeX; i++) {
                LeftTop = squareGrid.squareCorners[i][j].getProjectOrdinate();
                RightTop = squareGrid.squareCorners[i][j + 1].getProjectOrdinate();
                LeftDown = squareGrid.squareCorners[i + 1][j].getProjectOrdinate();
                RightDown = squareGrid.squareCorners[i + 1][j + 1].getProjectOrdinate();

                LeftTopT = squareGrid.squareCorners[i][j].getTerrainOrdinate();
                RightTopT = squareGrid.squareCorners[i][j + 1].getTerrainOrdinate();
                LeftDownT = squareGrid.squareCorners[i + 1][j].getTerrainOrdinate();
                RightDownT = squareGrid.squareCorners[i + 1][j + 1].getTerrainOrdinate();

                calculatedSquares.squares[i][j] = calculatedSquares.new SingleSquare();
                calculatedSquares.squares[i][j].setIndex(index++);
                calculatedSquares.squares[i][j].setFourCornersXAndY(i, j, squareSize);
                calculatedSquares.squares[i][j].setFourCornersH(LeftTop, RightTop, LeftDown, RightDown);

                calculatedSquares.squares[i][j].setFourTerrainH(LeftTopT, RightTopT, LeftDownT, RightDownT);

            }
        }
    }

    private void checkAndSetZeroPoints() {
        for (SquareGrid.ZeroPoint point : squareGrid.listOfZeroPoints) {
            int simplifiedX = (int) (point.getIndexX()/startingConditions.getSquareSide()-0.01);
            int simplifiedY = (int) (point.getIndexY()/startingConditions.getSquareSide()-0.01);
            double newX = point.getIndexX();
            double newY = point.getIndexY();
            double newH = point.getOrdinateH();
            calculatedSquares.squares[simplifiedX][simplifiedY].addNewZeroPoint(newX, newY, newH, 0);
        }
    }

    private void calculateAreas(int x1, int y1) {
        double projectHSum = 0;
        double terrainHSum = 0;
        double diffH = 0;
        projectHSum += calculatedSquares.squares[x1][y1].leftTopCor.getOrdinateH();
        projectHSum += calculatedSquares.squares[x1][y1].rightTopCor.getOrdinateH();
        projectHSum += calculatedSquares.squares[x1][y1].leftDownCor.getOrdinateH();
        projectHSum += calculatedSquares.squares[x1][y1].rightDownCor.getOrdinateH();

        terrainHSum += calculatedSquares.squares[x1][y1].leftTopCor.getTerrainH();
        terrainHSum += calculatedSquares.squares[x1][y1].rightTopCor.getTerrainH();
        terrainHSum += calculatedSquares.squares[x1][y1].leftDownCor.getTerrainH();
        terrainHSum += calculatedSquares.squares[x1][y1].rightDownCor.getTerrainH();

        diffH = projectHSum - terrainHSum;

        if (calculatedSquares.squares[x1][y1].zeroSquarePoints.isEmpty()) {
            if(diffH > 0){
                calculatedSquares.squares[x1][y1].setAddArea(squareSize*squareSize);
                calculatedSquares.squares[x1][y1].setSubtractArea(0);

                calculatedSquares.squares[x1][y1].setAddVolume(diffH*squareSize*squareSize/4);
                calculatedSquares.squares[x1][y1].setSubtractArea(0);
            } else if (diffH < 0){
                calculatedSquares.squares[x1][y1].setSubtractArea(squareSize*squareSize);
                calculatedSquares.squares[x1][y1].setAddArea(0);

                calculatedSquares.squares[x1][y1].setSubtractArea(diffH*squareSize*squareSize/4);
                calculatedSquares.squares[x1][y1].setAddVolume(0);
            }
        } else {

        }



    }

    private double sumCornersH(int x1, int y1){
        double sum = 0;
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                sum += squareGrid.squareCorners[x1+i][y1+j].getProjectOrdinate();
            }
        }
    }
}
