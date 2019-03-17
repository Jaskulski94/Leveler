package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;

public class CalculatedSquaresFrame extends JFrame {
    public CalculatedSquaresFrame(){
        this.setSize(UIParameters.dimFrame);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        this.setEnabled(false);
    }

}
