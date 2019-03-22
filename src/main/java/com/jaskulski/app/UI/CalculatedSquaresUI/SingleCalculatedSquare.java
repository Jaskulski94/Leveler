package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.UI.UIParameters;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static org.apache.commons.lang3.StringUtils.rightPad;


public class SingleCalculatedSquare extends JPanel {
    private JLabel lblIndex;
    private JLabel lblOrdXY;
    private JLabel lblAdd;
    private JLabel lblSub;

    private JLabel lblIndexText;
    private JLabel lblOrdXYText;
    private JLabel lblAddText;
    private JLabel lblSubText;

    private GridBagConstraints GBC;

    public SingleCalculatedSquare(int index1){
        GridBagLayout GBL = new GridBagLayout();
        GBC = new GridBagConstraints();
        this.setLayout(GBL);

        initiateSingleSquareLabels();

        lblIndexText.setText(String.valueOf(index1));

        setSquareStyle();
    }

    public void setXYText(double x1, double y1){
        String xY = String.format("%.2f-%.2f", x1, y1);
        xY = rightPad(xY, 10, ' ');
        lblOrdXYText.setText(xY);
    }

    public void setAddText(double addA1, double addV1) {
        String addAreaAndVolume = String.format("Pole: %.2f Obj.: %.2f", addA1, addV1);
        addAreaAndVolume = rightPad(addAreaAndVolume, 10, ' ');
        lblAddText.setText(addAreaAndVolume);
    }

    public void setSubText(double subA1, double subV1) {
        String subAreaAndVolume = String.format("Pole: %.2f Obj.: %.2f", subA1, subV1);
        subAreaAndVolume = rightPad(subAreaAndVolume, 10, ' ');
        lblSubText.setText(subAreaAndVolume);
    }

    private void initiateSingleSquareLabels(){
        lblIndex = new JLabel("Nr: ");
        lblOrdXY = new JLabel("X - Y: ");
        lblAdd = new JLabel("Nasyp");
        lblSub = new JLabel("Wykop");

        lblIndexText = new JLabel();
        lblOrdXYText = new JLabel();
        lblAddText = new JLabel();
        lblSubText = new JLabel();

        GBC.anchor = GridBagConstraints.WEST;

        GBC.gridx = 0;
        GBC.gridy = 0;
        this.add(lblIndex, GBC);

        GBC.gridy = 1;
        this.add(lblOrdXY, GBC);

        GBC.gridy = 2;
        this.add(lblAdd, GBC);

        GBC.gridy = 3;
        this.add(lblSub, GBC);

        GBC.gridx = 1;
        GBC.gridy = 0;
        this.add(lblIndexText,GBC);

        GBC.gridy = 1;
        this.add(lblOrdXYText, GBC);

        GBC.gridy = 2;
        this.add(lblAddText, GBC);

        GBC.gridy = 3;
        this.add(lblSubText, GBC);
    }

    private void setSquareStyle(){
        this.setBackground(Color.white);
        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        this.setBorder(new LineBorder(Color.black));
    }
}
