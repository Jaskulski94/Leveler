package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class SingleCalculatedSquare extends JPanel {
    private JLabel lblIndex;
    private JLabel lblOrdX;
    private JLabel lblOrdY;
    private JLabel lblOrdH;

    private JLabel lblIndexText;
    private JLabel lblOrdXText;
    private JLabel lblOrdYText;
    private JLabel lblOrdHText;

    private JLabel lblEmpty;

    GridBagLayout GBL;
    GridBagConstraints GBC;

    public SingleCalculatedSquare(int index1, double x1, double y1, double h1){
        GBL = new GridBagLayout();
        GBC = new GridBagConstraints();
        this.setLayout(GBL);

        initiateSingleSquareLabels();

        String x = String.format("%.2f", x1);
        String y = String.format("%.2f", y1);
        String h = String.format("%.2f", h1);

        lblIndexText.setText(String.valueOf(index1));
        lblOrdXText.setText(x);
        lblOrdYText.setText(y);
        lblOrdHText.setText(h);

        setSquareStyle();
    }

    private void initiateSingleSquareLabels(){
        lblIndex = new JLabel("Nr: ");
        lblOrdX = new JLabel("Rz. X: ");
        lblOrdY = new JLabel("Rz. Y: ");
        lblOrdH = new JLabel("Rz. pro: ");

        lblIndexText = new JLabel();
        lblOrdXText = new JLabel();
        lblOrdYText = new JLabel();
        lblOrdHText = new JLabel();

        lblEmpty = new JLabel("     ");

        GBC.anchor = GridBagConstraints.WEST;

        GBC.gridx = 0;
        GBC.gridy = 0;
        this.add(lblIndex, GBC);

        GBC.gridy = 1;
        this.add(lblOrdX, GBC);

        GBC.gridy = 2;
        this.add(lblOrdY, GBC);

        GBC.gridy = 3;
        this.add(lblOrdH, GBC);

        GBC.gridx = 1;
        GBC.gridy = 0;
        this.add(lblIndexText,GBC);

        GBC.gridy = 1;
        this.add(lblOrdXText, GBC);

        GBC.gridy = 2;
        this.add(lblOrdYText, GBC);

        GBC.gridy = 3;
        this.add(lblOrdHText, GBC);

        GBC.gridx = 2;
        GBC.gridy = 4;
        this.add(lblEmpty, GBC);
    }

    private void setSquareStyle(){
        this.setBackground(Color.white);
        UIParameters.setFontToAll(this, UIParameters.fontTiny);
        this.setBorder(new LineBorder(Color.black));
    }
}
