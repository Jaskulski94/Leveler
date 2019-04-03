package com.jaskulski.app.Data;

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
        public double ordinateX;
        public double ordinateY;
        public double ordinateH;

        public ZeroPoint(double x1, double y1, double h1){
            ordinateX = x1;
            ordinateY = y1;
            ordinateH = h1;
        }
    }

    public ZeroPoint createZeroPoints (double x1, double y1, double h1){
        return (new ZeroPoint(x1, y1, h1));
    }
}
