package com.jaskulski.app.UI;

import javax.swing.*;
import java.awt.*;

public class SquareGridPanel extends JPanel {
    int sizeX, sizeY;
    JTextField[][] txtSquares;

    public SquareGridPanel(int size1, int size2){
        this.sizeX = size1;
        this.sizeY = size2;

        this.setLayout(new GridLayout(sizeY, sizeY));

        txtSquares = new JTextField[sizeX][sizeY];

        for(int i = 0; i<sizeX; i++){
            for(int j = 0; j<sizeY; j++){
                txtSquares[i][j] = new JTextField();
                this.add(txtSquares[i][j]);
            }
        }
        UIParameters.setFontToAll(this, UIParameters.fontMedium);

    }
}
