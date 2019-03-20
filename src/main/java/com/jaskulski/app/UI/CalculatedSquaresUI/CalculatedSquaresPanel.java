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
        GBC.insets = new Insets(4, 4, 4, 4);
        int size1 = calculatedSquares.getSizeX();
        int size2 = calculatedSquares.getSizeY();
        singleCS = new SingleCalculatedSquare[size1][size2];

        int index;
        double x, y;
        double addA, addV;
        double subA, subV;
        for (int i = 0; i<size1; i++){
            for (int j = 0; j<size2; j++){
                index = calculatedSquares.squares[i][j].getIndex();
                x = calculatedSquares.squares[i][j].leftTopCor.getOrdinateX();
                y = calculatedSquares.squares[i][j].leftTopCor.getOrdinateY();
                addA = calculatedSquares.squares[i][j].getAddArea();
                addV = calculatedSquares.squares[i][j].getAddVolume();
                subA = calculatedSquares.squares[i][j].getSubtractArea();
                subV = calculatedSquares.squares[i][j].getSubtractVolume();

                singleCS[i][j] = new SingleCalculatedSquare(index);
                singleCS[i][j].setXYText(x, y);

                singleCS[i][j].setAddAText(addA);
                singleCS[i][j].setAddVText(addV);

                singleCS[i][j].setSubAText(subA);
                singleCS[i][j].setSubVText(subV);

                GBC.gridx = i;
                GBC.gridy = j;
                this.add(singleCS[i][j], GBC);
            }
        }
    }

}
