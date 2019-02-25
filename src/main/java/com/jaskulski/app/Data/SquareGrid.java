package com.jaskulski.app.Data;

public class SquareGrid {

    public Square[][] squares;

    public SquareGrid(int sizeX, int sizeY){
        squares = new Square[sizeX][sizeY];
        int index = 0;
        for (int i=0; i<sizeX; i++){
            for (int j=0; j<sizeY; j++) {
                squares[i][j] = new Square(index, 0);
                index++;
            }
        }
    }

    private class Square {
        public int index;

        public double initialValue;

        public Square (int index1, double value1){
            this.index = index1;
            this.initialValue = value1;
        }
    }
}
