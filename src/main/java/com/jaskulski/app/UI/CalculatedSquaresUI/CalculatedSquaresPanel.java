package com.jaskulski.app.UI.CalculatedSquaresUI;

import javax.swing.*;
import java.awt.*;

public class CalculatedSquaresPanel extends JPanel {
    private SingleCalculatedSquare singleCS[][];

    public CalculatedSquaresPanel(int size1, int size2){
        GridBagLayout GBL = new GridBagLayout();
        GridBagConstraints GBC = new GridBagConstraints();
        this.setLayout(GBL);
        singleCS = new SingleCalculatedSquare[size1][size2];

        for (int i = 0; i<size1; i++){
            for (int j = 0; j<size2; j++){
                singleCS[i][j] = new SingleCalculatedSquare(1, 2, 3, 4);
                GBC.gridx = i;
                GBC.gridy = j;
                this.add(singleCS[i][j], GBC);
            }
        }
    }

}
