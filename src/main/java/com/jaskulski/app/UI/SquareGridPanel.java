package com.jaskulski.app.UI;

import javax.swing.*;
import java.awt.*;

public class SquareGridPanel extends JPanel {
    private int sizeX, sizeY;
    JTextField[][] txtSquares;
    JLabel[][] lblIndex;

    public SquareGridPanel(int size1, int size2){
        this.sizeX = size1;
        this.sizeY = size2;

        this.setLayout(new GridLayout(sizeY, sizeY));

        txtSquares = new JTextField[sizeX][sizeY];
        lblIndex = new JLabel[sizeX][sizeY];

        for(int i = 0; i<sizeX; i++){
            for(int j = 0; j<sizeY; j++){
                txtSquares[i][j] = new JTextField();
                this.add(txtSquares[i][j]);

                String index = (i+1) + "-" + (j+1);
                lblIndex[i][j] = new JLabel(index);
                this.add(lblIndex[i][j]);
            }
        }
        UIParameters.setFontToAll(this, UIParameters.fontMedium);

    }
}
