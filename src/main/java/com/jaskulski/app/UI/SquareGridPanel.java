package com.jaskulski.app.UI;

import javax.swing.*;
import java.awt.*;

public class SquareGridPanel extends JPanel {
    private int sizeX, sizeY;
    private JTextField[][] txtSquares;
    private JLabel[][] lblIndex;
    private GridBagConstraints GBC;

    public SquareGridPanel(int size1, int size2){
        this.sizeX = size1;
        this.sizeY = size2;

        GridBagLayout gridBagLayout = new GridBagLayout();
        GBC = new GridBagConstraints();
        this.setLayout(gridBagLayout);
        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.fill = GridBagConstraints.BOTH;
        GBC.weightx = 1;
        GBC.weighty = 1;

        txtSquares = new JTextField[sizeX][sizeY];
        lblIndex = new JLabel[sizeX][sizeY];

        /*for(int i = 0; i<sizeX; i++){
            for(int j = 0; j<sizeY; j++){
                GBC.gridx = i;
                GBC.gridy = j;
                txtSquares[i][j] = new JTextField();
                this.add(txtSquares[i][j], GBC);

                String index = (i+1) + "-" + (j+1);
                lblIndex[i][j] = new JLabel(index);
                this.add(lblIndex[i][j], GBC);
                lblIndex[i][j].setVisible(true);
            }
        }*/

        addTextFields();

        WhiteButton btnPrevious = new WhiteButton("Cofnij");
        WhiteButton btnSave = new WhiteButton("Zapisz zmiany");
        WhiteButton btnNext = new WhiteButton("Dalej");

        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridBagLayout());

        GBC.gridy++;
        GBC.gridx = 0;
        GBC.gridwidth = sizeY;

        this.add(pnlButtons, GBC);
        GBC.gridwidth = 1;
        pnlButtons.add(btnPrevious, GBC);
        GBC.gridx++;
        pnlButtons.add(btnSave, GBC);
        GBC.gridx++;
        pnlButtons.add(btnNext, GBC);

        UIParameters.setFontToAll(this, UIParameters.fontMedium);

    }

    public void addTextFields(){
        for(int i = 0; i<sizeX; i++){
            for(int j = 0; j<sizeY; j++){
                GBC.gridx = i;
                GBC.gridy = j;
                txtSquares[i][j] = new JTextField();
                this.add(txtSquares[i][j], GBC);

                String index = (i+1) + "-" + (j+1);
                lblIndex[i][j] = new JLabel(index);
                this.add(lblIndex[i][j], GBC);
                lblIndex[i][j].setVisible(true);
            }
        }
    }
}
