package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.Data.CalculatedSquares;
import com.jaskulski.app.UI.UIParameters;

import javax.swing.*;
import java.awt.*;

public class CalculatedSquaresFrame extends JFrame {
    public CalculatedSquaresFrame(CalculatedSquares calculatedSquares1){
        Dimension dim = new Dimension(330*calculatedSquares1.getSizeX(), 130*calculatedSquares1.getSizeY());
        this.setSize(dim);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
