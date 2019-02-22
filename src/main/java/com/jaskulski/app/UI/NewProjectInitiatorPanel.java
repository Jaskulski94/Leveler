package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.NewProjectInitiatorListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.zip.DataFormatException;

public class NewProjectInitiatorPanel extends JPanel {

    SlopeInitiator pnlASlope;
    SlopeInitiator pnlBSlope;
    JTextField txtSquares;
    JTextField txtField;

    public NewProjectInitiatorPanel(){
        this.setLayout(new BoxLayout(this,  BoxLayout.PAGE_AXIS ));
        JLabel lblTitle = new JLabel("Założenia techniczne");
        this.add(lblTitle);
        this.add(new JLabel(" "));

        JLabel lblSides = new JLabel("Boki boiska");
        this.add(lblSides);

        JPanel pnlSlopes = new JPanel();
        pnlSlopes.setLayout(new BoxLayout(pnlSlopes, BoxLayout.X_AXIS));

        pnlASlope = new SlopeInitiator();
        pnlSlopes.add(pnlASlope);
        pnlBSlope = new SlopeInitiator();
        pnlSlopes.add(pnlBSlope);

        this.add(pnlSlopes);

        this.add(new JLabel(" "));
        JLabel lblSquares = new JLabel("Bok kwadratu siatki");
        this.add(lblSquares);
        txtSquares = new JTextField("10");
        this.add(txtSquares);

        this.add(new JLabel(" "));
        JLabel lblLean = new JLabel("Pochylenie płaszczyzny boiska");
        this.add(lblLean);
        txtField = new JTextField("1");
        this.add(txtField);

        WhiteButton btnStartingConditions= new WhiteButton("Dalej");
        this.add(btnStartingConditions);

        btnStartingConditions.addActionListener(new NewProjectInitiatorListener(this));

        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        lblTitle.setFont(UIParameters.fontBig);
        lblSides.setFont(UIParameters.fontMedium);
        /*titleLabel.setFont(Scheme.fontBig);
        sidesLabel.setFont(Scheme.fontMedium);
        squaresLabel.setFont(Scheme.fontMedium);
        leanLabel.setFont(Scheme.fontMedium);
        startingConditionsButton.setFont(Scheme.fontBig);*/

    //    this.setVisible(true);
    }

    public SlopeInitiator getSlopeA(){
        return pnlASlope;
    }

    public SlopeInitiator getSlopeB(){
        return pnlBSlope;
    }

    public double getTxtSquares(){
        return Double.parseDouble(txtSquares.getText());
    }

    public double getTxtField(){
        return Double.parseDouble(txtField.getText());
    }

    public class SlopeInitiator extends JPanel {
        JTextField txtSide;
        JTextField txtSlopeValue;
        ButtonGroup btnGroup;
        JRadioButton rBtnSlopeWidth;
        JRadioButton rBtnSlopeTilt;

        public SlopeInitiator() {
            Border blackBorder = BorderFactory.createLineBorder(Color.lightGray);
            this.setBorder(blackBorder);

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            this.add(new JLabel("Zbocze"));

            txtSide = new JTextField("100");
            this.add(txtSide);
            this.add(new JLabel(" "));
            this.add(new JLabel("Rodzaj skarpy:"));

            btnGroup = new ButtonGroup();
            rBtnSlopeWidth = new JRadioButton("Szerokość skarpy");
            rBtnSlopeTilt = new JRadioButton("Kąt nachylenia");
            btnGroup.add(rBtnSlopeTilt);
            btnGroup.add(rBtnSlopeWidth);

            this.add(rBtnSlopeWidth);
            this.add(rBtnSlopeTilt);
            this.add(new JLabel("Wartość:"));

            txtSlopeValue = new JTextField("1");
            this.add(txtSlopeValue);
        }

        public double getSide() throws DataFormatException {
            return Double.parseDouble(txtSide.getText());
        }

        public double getSlopeValue(JRadioButton jrButton1) throws DataFormatException {
            double value;
            if (jrButton1.isSelected()) {
                value = Double.parseDouble(txtSlopeValue.getText());
            } else {
                value = 0;
            }
            return value;
        }

        public double getSlopeWidth() throws DataFormatException {
            return getSlopeValue(rBtnSlopeWidth);
        }

        public double getSlopeTilt() throws DataFormatException {
            return getSlopeValue(rBtnSlopeTilt);
        }
    }
}
