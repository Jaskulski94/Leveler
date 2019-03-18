package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;
import java.awt.*;

public class CalculatedSquaresPanel extends JPanel {
    private SingleCalculatedSquare singleCS[][];
    private CalculatedSquares calculatedSquares;

    public CalculatedSquaresPanel(CalculatedSquares calculatedSquares1){
        this.calculatedSquares = calculatedSquares1;

        GridBagLayout GBL = new GridBagLayout();
        GridBagConstraints GBC = new GridBagConstraints();
        this.setLayout(GBL);

        this.setSize(UIParameters.dimFrame2);

        int size1 = calculatedSquares.getSizeX();
        int size2 = calculatedSquares.getSizeY();
        singleCS = new SingleCalculatedSquare[size1][size2];

        int index;
        double x, y, h;
        for (int i = 0; i<size1; i++){
            for (int j = 0; j<size2; j++){
                index = calculatedSquares.squares[i][j].getIndex();
                x = calculatedSquares.squares[i][j].leftTopCor.getOrdinateX();
                y = calculatedSquares.squares[i][j].leftTopCor.getOrdinateY();
                h = calculatedSquares.squares[i][j].leftTopCor.getOrdinateH();
                singleCS[i][j] = new SingleCalculatedSquare(index, x, y, h);
                GBC.gridx = i;
                GBC.gridy = j;
                this.add(singleCS[i][j], GBC);
            }
        }
    }

}
