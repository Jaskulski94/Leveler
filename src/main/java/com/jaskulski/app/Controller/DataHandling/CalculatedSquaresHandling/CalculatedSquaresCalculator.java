package com.jaskulski.app.Controller.DataHandling.CalculatedSquaresHandling;

import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

public class CalculatedSquaresCalculator {
    private SquareGrid squareGrid;
    private CalculatedSquares calculatedSquares;
    private int cSSizeX;
    private int cSSizeY;
    private double squareSize;

    public int getCSSizeX() {
        return cSSizeX;
    }

    public int getCSSizeY() {
        return cSSizeY;
    }

    public CalculatedSquaresCalculator(StartingConditions sC1, SquareGrid sG1, CalculatedSquares cS1) {
        this.squareGrid = sG1;
        this.calculatedSquares = cS1;
        this.cSSizeX = sG1.squareCorners.length - 1;
        this.cSSizeY = sG1.squareCorners[0].length - 1;
        this.squareSize = sC1.getSquareSide();
    }

    public void calculateCS() {
        setCSSizes();
        setAllSquares();
        checkAndSetZeroPoints();
    }

    private void setCSSizes() {
        calculatedSquares.squares = new CalculatedSquares.SingleSquare[cSSizeX][cSSizeY];
    }

    private void setAllSquares() {
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
            double notSimX = point.getOrdinateX();
            double notSimY = point.getOrdinateY();

            int simX = (int) (notSimX / squareSize);
            int simY = (int) (notSimY / squareSize);

            double newH = point.getOrdinateH();

            if ((notSimX % squareSize) == 0) {
                if (simX == 0) {
                    calculatedSquares.squares[simX][simY].addNewZeroPoint(notSimX, notSimY, newH, 0);
                } else {
                    calculatedSquares.squares[simX - 1][simY].addNewZeroPoint(notSimX, notSimY, newH, 0);
                    if (simX < calculatedSquares.squares.length) {
                        calculatedSquares.squares[simX][simY].addNewZeroPoint(notSimX, notSimY, newH, 0);
                    }
                }
            } else if ((notSimY % squareSize) == 0) {
                if (simX == 0) {
                    calculatedSquares.squares[simX][simY].addNewZeroPoint(notSimX, notSimY, newH, 0);
                } else {
                    calculatedSquares.squares[simX][simY - 1].addNewZeroPoint(notSimX, notSimY, newH, 0);
                    if (simX < calculatedSquares.squares.length) {
                        calculatedSquares.squares[simX][simY].addNewZeroPoint(notSimX, notSimY, newH, 0);
                    }
                }
            }
        }
    }

    public void calculateAllAreasAndVolumes() {
        double totalSumAddVolume = 0;

        double totalSumSubtractVolume = 0;

        for (int j = 0; j < cSSizeY; j++) {
            for (int i = 0; i < cSSizeX; i++) {
                calculateAreaAndVolume(calculatedSquares.squares[i][j]);
                System.out.format("Testowa wartość objętości dla %d %d : %.2f %.2f", i, j, calculatedSquares.squares[i][j].getAddVolume(), calculatedSquares.squares[i][j].getSubtractVolume());
                System.out.println("");
                System.out.println("Testowa wartość pola dla " + i + " " + j + " " + calculatedSquares.squares[i][j].getAddArea() + " -" + calculatedSquares.squares[i][j].getSubtractArea());
                System.out.println("");
                totalSumAddVolume += calculatedSquares.squares[i][j].getAddVolume();
                totalSumSubtractVolume += calculatedSquares.squares[i][j].getSubtractVolume();
            }
        }
        System.out.format("Suma nasypu wynosi: %.2f", totalSumAddVolume);
        System.out.println("");
        System.out.format("Suma wykopu wynosi: %.2f", totalSumSubtractVolume);
        System.out.println("");

    }

    private void calculateAreaAndVolume(CalculatedSquares.SingleSquare square1) {
        if (square1.zeroSquarePoints.isEmpty()) {
            double area = squareSize * squareSize;
            double diffH = calculateAvgHDiff(square1);
            if (diffH > 0) {
                square1.setAreasAndVolumes(area, area * diffH, 0, 0);
            } else if (diffH < 0) {
                square1.setAreasAndVolumes(0, 0, area, area * diffH);
            }
        } else {
            calculateWithZP(square1);
        }
    }

    private void calculateWithZP(CalculatedSquares.SingleSquare square1) {
        double step = squareSize / 100;

        double sumAddArea = 0;
        double sumAddVolume = 0;

        double sumSubtractArea = 0;
        double sumSubtractVolume = 0;

        double localDiff;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                localDiff = calculateLocalHDiff(square1, i * step, j * step);
                if (localDiff > 0) {
                    sumAddArea += step * step;
                    sumAddVolume += step * step * calculateLocalHDiff(square1, i * step, j * step);
                } else if (localDiff < 0) {
                    sumSubtractArea += step * step;
                    sumSubtractVolume += step * step * calculateLocalHDiff(square1, i * step, j * step);
                }
            }
        }

        square1.setAddArea(sumAddArea);
        square1.setAddVolume(sumAddVolume);
        square1.setSubtractArea(sumSubtractArea);
        square1.setSubtractVolume(sumSubtractVolume);
        System.out.format("Punkt ZP - Nasyp P: %.2f V: %.2f  Wykop P: %.2f V: %.2f", sumAddArea, sumAddVolume, sumSubtractArea, sumSubtractVolume);
        System.out.println("");
    }

    private double calculateLocalHDiff(CalculatedSquares.SingleSquare square1, double x1, double y1) {
        double partOfX = x1 / squareSize;
        double partOfY = y1 / squareSize;
        double[] partsOfProjectH = new double[4];
        double[] partsOfTerrainH = new double[4];

        partsOfProjectH[0] = square1.rightDownCor.getOrdinateH() * partOfX * partOfY;
        partsOfTerrainH[0] = square1.rightDownCor.getTerrainH() * partOfX * partOfY;

        partsOfProjectH[1] = square1.leftDownCor.getOrdinateH() * (1 - partOfX) * partOfY;
        partsOfTerrainH[1] = square1.leftDownCor.getTerrainH() * (1 - partOfX) * partOfY;

        partsOfProjectH[2] = square1.rightTopCor.getOrdinateH() * partOfX * (1 - partOfY);
        partsOfTerrainH[2] = square1.rightTopCor.getTerrainH() * partOfX * (1 - partOfY);

        partsOfProjectH[3] = square1.leftTopCor.getOrdinateH() * (1 - partOfX) * (1 - partOfY);
        partsOfTerrainH[3] = square1.leftTopCor.getTerrainH() * (1 - partOfX) * (1 - partOfY);

        double sumProjectH = 0;
        double sumTerrainH = 0;
        for (int i = 0; i < 4; i++) {
            sumProjectH += partsOfProjectH[i];
            sumTerrainH += partsOfTerrainH[i];
        }
        return ((sumProjectH - sumTerrainH) / 4);
    }

    private double calculateAvgHDiff(CalculatedSquares.SingleSquare square1) {
        double sumProjectH = 0;
        double sumTerrainH = 0;

        sumProjectH += square1.leftTopCor.getOrdinateH();
        sumProjectH += square1.rightTopCor.getOrdinateH();
        sumProjectH += square1.leftDownCor.getOrdinateH();
        sumProjectH += square1.rightDownCor.getOrdinateH();

        sumTerrainH += square1.leftTopCor.getTerrainH();
        sumTerrainH += square1.rightTopCor.getTerrainH();
        sumTerrainH += square1.leftDownCor.getTerrainH();
        sumTerrainH += square1.rightDownCor.getTerrainH();

        return ((sumProjectH - sumTerrainH) / 4);
    }
}
