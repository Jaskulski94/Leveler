package com.jaskulski.app.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class SquareGrid implements Serializable {

    public SquareCorner[][] squareCorners;
    public ArrayList<ZeroPoint> listOfZeroPoints = new ArrayList<>();

    public SquareGrid(int sizeX, int sizeY) {
        squareCorners = new SquareCorner[sizeX][sizeY];
        int index = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                squareCorners[i][j] = new SquareCorner(index, 0);
                index++;
            }
        }
    }

    public Dimension getSquareDim(){
        Dimension dim = new Dimension(squareCorners[0].length, squareCorners[1].length);
        return dim;
    }
    @Data
    public class SquareCorner implements Serializable{
        public int index;
        public double terrainOrdinate;
        public double projectOrdinate;
        public double ordinateDifference;

        public SquareCorner(int index1, double value1) {
            this.index = index1;
            this.terrainOrdinate = value1;
        }
    }

    @Data
    public class ZeroPoint implements Serializable{
        public double indexX;
        public double indexY;
        public double ordinateH;

        public ZeroPoint(double x1, double y1, double h1){
            indexX = x1;
            indexY = y1;
            ordinateH = h1;
        }
    }

    public ZeroPoint createZeroPoints (double x1, double y1, double h1){
        ZeroPoint newPoint = new ZeroPoint(x1, y1, h1);
        return newPoint;
    }

    /*public CalculatedSquares.SingleSquare.SquarePoint convertSGZeroPoint(ZeroPoint point){
        CalculatedSquares.SingleSquare.SquarePoint newPoint = new CalculatedSquares.SingleSquare.SquarePoint();
    }*/
}
