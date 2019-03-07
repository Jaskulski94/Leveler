package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

public class SquareGridHandler {
    private StartingConditions startingConditions;
    private SquareGrid squareGrid;

    public void serializeSquareGrid(){

    }

    public SquareGrid deserializeSquareGrid(){
        int sizeX = 1;
        int sizeY = 1;
        SquareGrid squareGrid = new SquareGrid(sizeX, sizeY);
        return squareGrid;
    }
}
