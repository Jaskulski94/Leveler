package com.jaskulski.app.UI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewProjectInitiatorPanel extends JPanel {

    public NewProjectInitiatorPanel(){
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS ));

        JLabel titleLabel = new JLabel("Założenia techniczne");
        this.add(titleLabel);
        this.add(new JLabel(" "));

        JLabel sidesLabel = new JLabel("Boki boiska");
        this.add(sidesLabel);

        JPanel slopesPanel = new JPanel();
        slopesPanel.setLayout(new BoxLayout(slopesPanel, BoxLayout.X_AXIS));

        SlopeInitiator aSlopePanel = new SlopeInitiator();
        slopesPanel.add(aSlopePanel);
        SlopeInitiator bSlopePanel = new SlopeInitiator();
        slopesPanel.add(bSlopePanel);

        this.add(slopesPanel);

        this.add(new JLabel(" "));
        JLabel squaresLabel = new JLabel("Bok kwadratu siatki");
        this.add(squaresLabel);
        JTextField squaresField = new JTextField("10");
        this.add(squaresField);

        this.add(new JLabel(" "));
        JLabel leanLabel = new JLabel("Pochylenie płaszczyzny boiska");
        this.add(leanLabel);
        JTextField leanField = new JTextField("1");
        this.add(leanField);

        WhiteButton startingConditionsButton = new WhiteButton("Dalej");
        this.add(startingConditionsButton);

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
            this.add(new JLabel("slope"));

            JTextField sideField = new JTextField("100");
            this.add(sideField);
            this.add(new JLabel(" "));
            this.add(new JLabel("Rodzaj skarpy:"));

            ButtonGroup buttonGroup = new ButtonGroup();
            JRadioButton slopeWidthButton = new JRadioButton("Szerokość skarpy");
            JRadioButton slopeTiltButton = new JRadioButton("Kąt nachylenia");
            buttonGroup.add(slopeTiltButton);
            buttonGroup.add(slopeWidthButton);

            this.add(slopeWidthButton);
            this.add(slopeTiltButton);
            this.add(new JLabel("Wartość:"));

            JTextField slopeValueField = new JTextField("1");
            this.add(slopeValueField);
        }
        
    }
}
