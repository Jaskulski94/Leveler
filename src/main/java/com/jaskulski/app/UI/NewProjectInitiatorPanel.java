package com.jaskulski.app.UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewProjectInitiatorPanel extends JPanel {

    public NewProjectInitiatorPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));

        JLabel lblTitle = new JLabel("Założenia techniczne");
        this.add(lblTitle);
        this.add(new JLabel(" "));

        JLabel sidesLabel = new JLabel("Boki boiska");
        this.add(sidesLabel);

        JPanel pnlSlopes = new JPanel();
        pnlSlopes.setLayout(new BoxLayout(pnlSlopes, BoxLayout.X_AXIS));

        SlopeInitiator pnlASlope = new SlopeInitiator();
        pnlSlopes.add(pnlASlope);
        SlopeInitiator pnlBSlope = new SlopeInitiator();
        pnlSlopes.add(pnlBSlope);

        this.add(pnlSlopes);

        this.add(new JLabel(" "));
        JLabel lblSquares = new JLabel("Bok kwadratu siatki");
        this.add(lblSquares);
        JTextField txtSquares = new JTextField("10");
        this.add(txtSquares);

        this.add(new JLabel(" "));
        JLabel lblLean = new JLabel("Pochylenie płaszczyzny boiska");
        this.add(lblLean);
        JTextField txtField = new JTextField("1");
        this.add(txtField);

        WhiteButton btnStartingConditions= new WhiteButton("Dalej");
        this.add(btnStartingConditions);

    //    startingConditionsButton.addActionListener(new StartingConditionsListener(this));

    //    setCenterAlignment(this);

        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        /*titleLabel.setFont(Scheme.fontBig);
        sidesLabel.setFont(Scheme.fontMedium);
        squaresLabel.setFont(Scheme.fontMedium);
        leanLabel.setFont(Scheme.fontMedium);
        startingConditionsButton.setFont(Scheme.fontBig);*/

    //    this.setVisible(true);
    }

    public class SlopeInitiator extends JPanel{
        
        public SlopeInitiator(){
            Border blackBorder = BorderFactory.createLineBorder(Color.lightGray);
            this.setBorder(blackBorder);

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.add(new JLabel("Zbocze"));

            JTextField txtSide = new JTextField("100");
            this.add(txtSide);
            this.add(new JLabel(" "));
            this.add(new JLabel("Rodzaj skarpy:"));

            ButtonGroup btnGroup = new ButtonGroup();
            JRadioButton rBtnSlopeWidth = new JRadioButton("Szerokość skarpy");
            JRadioButton rBtnSlopeTilt = new JRadioButton("Kąt nachylenia");
            btnGroup.add(rBtnSlopeTilt);
            btnGroup.add(rBtnSlopeWidth);

            this.add(rBtnSlopeWidth);
            this.add(rBtnSlopeTilt);
            this.add(new JLabel("Wartość:"));

            JTextField txtSlopeValue = new JTextField("1");
            this.add(txtSlopeValue);
        }
        
    }
}
