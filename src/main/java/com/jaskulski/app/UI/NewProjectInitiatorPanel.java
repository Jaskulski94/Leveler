package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.NewProjectInitiatorListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class NewProjectInitiatorPanel extends JPanel {

    public SlopeInitiator pnlASlope;
    public SlopeInitiator pnlBSlope;
    public JTextField txtSquares;
    public JTextField txtField;
    public UILauncherFrame UILauncher;

    public NewProjectInitiatorPanel(UILauncherFrame UILauncher1) {
        initiateProjectWithUILauncher(UILauncher1);
    }

    public NewProjectInitiatorPanel(){
        initiateProject();
    }

    public void initiateProjectWithUILauncher(UILauncherFrame UILauncher1){
        this.UILauncher = UILauncher1;

        initiateProject();

        WhiteButton btnStartingConditions = new WhiteButton("Dalej");
        btnStartingConditions.addActionListener(new NewProjectInitiatorListener(UILauncher, this));
        this.add(btnStartingConditions);
        setCenterAlignment(this);

    }

    public void initiateProject(){
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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

        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        lblTitle.setFont(UIParameters.fontBig);
        lblSides.setFont(UIParameters.fontMedium);

        setCenterAlignment(this);
    }

/*    public void initiateProject(UILauncherFrame UILauncher1){
        this.UILauncher = UILauncher1;

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
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

        WhiteButton btnStartingConditions = new WhiteButton("Dalej");
        btnStartingConditions.addActionListener(new NewProjectInitiatorListener(UILauncher, this));
        this.add(btnStartingConditions);

        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        lblTitle.setFont(UIParameters.fontBig);
        lblSides.setFont(UIParameters.fontMedium);

        setCenterAlignment(this);
    }*/

    public SlopeInitiator getSlopeA() {
        return pnlASlope;
    }

    public SlopeInitiator getSlopeB() {
        return pnlBSlope;
    }

    public double getTxtSquares() {
        return Double.parseDouble(txtSquares.getText());
    }

    public double getTxtField() {
        return Double.parseDouble(txtField.getText());
    }

    private void setCenterAlignment(JComponent component) {
        component.setAlignmentX(Component.CENTER_ALIGNMENT);
        component.setAlignmentY(Component.CENTER_ALIGNMENT);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setCenterAlignment((JComponent) child);
            }
        }
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

        public double getSide() throws NumberFormatException {
            return Double.parseDouble(txtSide.getText());
        }

        public double getSlopeValue(JRadioButton jrButton1) throws NumberFormatException {
            double value;
            if (jrButton1.isSelected()) {
                value = Double.parseDouble(txtSlopeValue.getText());
            } else {
                value = 0;
            }
            return value;
        }

        public double getSlopeWidth() throws NumberFormatException {
            return getSlopeValue(rBtnSlopeWidth);
        }

        public double getSlopeTilt() throws NumberFormatException {
            return getSlopeValue(rBtnSlopeTilt);
        }
    }
}
