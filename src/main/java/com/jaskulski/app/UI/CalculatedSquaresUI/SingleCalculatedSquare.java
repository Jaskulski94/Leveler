package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

import static org.apache.commons.lang3.StringUtils.rightPad;

public class SingleCalculatedSquare extends JPanel {
    private JLabel lblIndex;

    private JLabel lblOrdXYText;

    private JLabel lblAddAText;
    private JLabel lblAddVText;

    private JLabel lblSubAText;
    private JLabel lblSubVText;

    private GridBagConstraints GBC;

    public SingleCalculatedSquare(int index1) {
        GridBagLayout GBL = new GridBagLayout();
        GBC = new GridBagConstraints();
        GBC.insets = new Insets(1, 3, 1, 5);
        this.setLayout(GBL);

        initiateSingleSquareLabels();

        lblIndex.setText("Nr " + index1);

        setSquareStyle();
    }

    public void setXYText(double x1, double y1) {
        String xY = String.format("%.2f-%.2f", x1, y1);
        xY = rightPad(xY, 10, ' ');
        lblOrdXYText.setText(xY);
    }

    public void setAddAText(double addA1) {
        String addArea = String.format("P = %.1f", addA1);
        addArea = rightPad(addArea, 8, ' ');
        lblAddAText.setText(addArea);
    }

    public void setAddVText(double addV1) {
        String addVolume = String.format("V = %.2f", addV1);
        addVolume = rightPad(addVolume, 15, ' ');
        lblAddVText.setText(addVolume);
    }

    public void setSubAText(double subA1) {
        String subArea = String.format("P = %.2f", subA1);
        subArea = rightPad(subArea, 8, ' ');
        lblSubAText.setText(subArea);
    }

    public void setSubVText(double subV1) {
        String subVolume = String.format("V = %.2f", subV1);
        subVolume = rightPad(subVolume, 15, ' ');
        lblSubVText.setText(subVolume);
    }

    private void initiateSingleSquareLabels() {
        lblIndex = new JLabel("Nr: ");
        JLabel lblOrdXY = new JLabel("X - Y: ");
        JLabel lblAdd = new JLabel("Nasyp");
        JLabel lblSub = new JLabel("Wykop");

        JLabel lblIndexText = new JLabel();
        lblOrdXYText = new JLabel();

        lblAddAText = new JLabel();
        lblAddVText = new JLabel();

        lblSubAText = new JLabel();
        lblSubVText = new JLabel();

        GBC.anchor = GridBagConstraints.WEST;

        GBC.gridx = 0;
        GBC.gridy = 0;
        this.add(lblIndex, GBC);

        GBC.gridx = 1;
        this.add(lblIndexText);

        GBC.gridx = 2;
        this.add(lblOrdXY, GBC);

        GBC.gridx = 3;
        this.add(lblOrdXYText, GBC);

        GBC.gridwidth = 2;
        GBC.gridx = 0;
        GBC.gridy = 1;
        this.add(lblAdd, GBC);

        GBC.gridx = 2;
        this.add(lblSub, GBC);

        GBC.gridx = 0;
        GBC.gridy = 2;
        this.add(lblAddAText, GBC);

        GBC.gridy = 3;
        this.add(lblAddVText, GBC);

        GBC.gridx = 2;
        GBC.gridy = 2;
        this.add(lblSubAText, GBC);

        GBC.gridy = 3;
        this.add(lblSubVText, GBC);

    }

    private void setSquareStyle() {
        this.setBackground(Color.white);
        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        this.setBorder(new LineBorder(Color.black));
    }
}
