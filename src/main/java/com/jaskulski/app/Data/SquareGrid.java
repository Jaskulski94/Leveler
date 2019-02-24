package com.jaskulski.app.Data;

import java.util.ArrayList;
import java.util.List;

public class SquareGrid {

    public List<Square> squares  = new ArrayList<>();;

    public SquareGrid(int size1){
        for (int i = 0; i<size1; i++){
            squares.add(new Square(i, 0));
        }
    }

    public void setAllSquares(){

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
