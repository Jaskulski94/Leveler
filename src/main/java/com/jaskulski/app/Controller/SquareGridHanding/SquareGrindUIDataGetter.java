package com.jaskulski.app.Controller.SquareGridHanding;

import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;

import javax.swing.*;

public class SquareGrindUIDataGetter {
    private SquareGridPanel sGPanel;
    private SquareGrid squareGrid;

    public SquareGrindUIDataGetter(SquareGridPanel sGPanel1, SquareGrid squareGrid1){
        this.sGPanel = sGPanel1;
        this.squareGrid = squareGrid1;
    }

    public void setStartingConditionsFromUI() {
        String message1 = "SquareGrindUIDataGetter Error: Niezgody rozmiar tablic danych";
        String message2 = "SquareGrindUIDataGetter Error: Zły typ wprowadzonych danych";
        String message3 = "SquareGrindUIDataGetter Error: Problem z rozmiarem tablicy";

        try {
            if(compareSizes(sGPanel, squareGrid)){
                saveAllSquares(sGPanel, squareGrid);
            } else{
                JOptionPane.showMessageDialog(null, message1);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, message2);
        } catch (ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, message3);
        }
    }

    private void saveAllSquares(SquareGridPanel sGPanel1, SquareGrid squareGrid1){
        int sizeX, sizeY;
        String squareValue;
        double convertedValue;
        sizeX = squareGrid1.squares[0].length;
        sizeY = squareGrid1.squares[1].length;

        for (int i = 0; i < sizeX; i++){
            for (int j = 0; j < sizeY; j++){
                squareValue = sGPanel1.txtSquares[i][j].getText();
                if (squareValue.isEmpty()){
                    convertedValue = 0;
                }
                else{
                    convertedValue = Double.parseDouble(squareValue);
                }
                squareGrid1.squares[i][j].terrainOrdinate = convertedValue;
                System.out.format("%.3f ", convertedValue);
            }
            System.out.println("");
        }
    }

    private boolean compareSizes(SquareGridPanel sGPanel1, SquareGrid squareGrid1){
        int txtSizeX = sGPanel1.txtSquares[0].length;
        int squareSizeX = squareGrid1.squares[0].length;
        int txtSizeY = sGPanel1.txtSquares[1].length;
        int squareSizeY = squareGrid1.squares[1].length;

        if((txtSizeX == squareSizeX) &&  (txtSizeY == squareSizeY)){
            return true;
        } else {
            return false;
        }
    }
}
