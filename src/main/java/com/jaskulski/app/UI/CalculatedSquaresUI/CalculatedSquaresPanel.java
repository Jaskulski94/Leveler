package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;
import java.awt.*;

public class CalculatedSquaresPanel extends JPanel {
    private SingleCalculatedSquare singleCS[][];

    public CalculatedSquaresPanel(int size1, int size2){
/*
        JScrollPane scroller = new JScrollPane(this);
        this.add(scroller, BorderLayout.CENTER);
*/

        GridBagLayout GBL = new GridBagLayout();
        GridBagConstraints GBC = new GridBagConstraints();
        this.setLayout(GBL);

        this.setSize(UIParameters.dimFrame2);

        singleCS = new SingleCalculatedSquare[size1][size2];

        for (int i = 0; i<size1; i++){
            for (int j = 0; j<size2; j++){
                singleCS[i][j] = new SingleCalculatedSquare(1, 2, 3, 4);
                /*singleCS[i][j].setPreferredSize(UIParameters.dimFrameSmall);
                singleCS[i][j].setMaximumSize(new Dimension(150, 150));*/
                GBC.gridx = i;
                GBC.gridy = j;
                this.add(singleCS[i][j], GBC);
            }
        }
    }

}
