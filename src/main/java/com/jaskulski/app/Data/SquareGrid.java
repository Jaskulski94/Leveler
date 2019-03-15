package com.jaskulski.app.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

import lombok.Data;

@Data
public class SquareGrid implements Serializable {

    public SquareCorner[][] squareCorners;
    public ArrayList<ZeroPoints> listOfZeroPoints = new ArrayList<>();

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
    public class ZeroPoints implements Serializable{
        public double xOrdinate;
        public double yOrdinate;
        public double hOrdinate;

        public ZeroPoints (double x1, double y1, double h1){
            xOrdinate = x1;
            yOrdinate = y1;
            hOrdinate = h1;
        }
    }

    public ZeroPoints createZeroPoints (double x1, double y1, double h1){
        ZeroPoints newPoint = new ZeroPoints(x1, y1, h1);
        return newPoint;
    }
}
