package com.jaskulski.app.Data;

import java.awt.*;
import lombok.Data;

@Data
public class SquareGrid {

    public Square[][] squares;

    public SquareGrid(int sizeX, int sizeY) {
        squares = new Square[sizeX][sizeY];
        int index = 0;
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                squares[i][j] = new Square(index, 0);
                index++;
            }
        }
    }

    public Dimension getSquareDim(){
        Dimension dim = new Dimension(squares[0].length, squares[1].length);
        return dim;
    }
    @Data
    public class Square {
        public int index;

        public double initialValue;

        public Square(int index1, double value1) {
            this.index = index1;
            this.initialValue = value1;
        }
    }
}
