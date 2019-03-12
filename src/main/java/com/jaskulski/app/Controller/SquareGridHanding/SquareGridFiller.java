package com.jaskulski.app.Controller.SquareGridHanding;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import javax.swing.*;

public class SquareGridFiller {
    private SquareGrid squareGrid;
    private SquareGridPanel squareGridPanel;

    public SquareGridFiller(SquareGrid squareGrid1, SquareGridPanel squareGridPanel1){
        this.squareGrid = squareGrid1;
        this.squareGridPanel = squareGridPanel1;
    }

    public void fillSquareFields(){
        double initialValue;
        try{
            for(int i = 0; i<squareGridPanel.txtSquares[0].length; i++){
                for(int j = 0; j<squareGridPanel.txtSquares[1].length; j++){
                    initialValue = squareGrid.squares[i][j].getTerrainOrdinate();
                    squareGridPanel.txtSquares[i][j].setText(Double.toString(initialValue));
                }
            }
        } catch (NullPointerException e){
            JOptionPane.showMessageDialog(null, "Błąd przy wczytywaniu danych");
        }
    }
}
