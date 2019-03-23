package com.jaskulski.app.UI.CalculatedSquaresUI;

import com.jaskulski.app.Data.CalculatedSquares;

import javax.swing.*;
import java.awt.*;

public class CalculatedSquaresFrame extends JFrame {
    public CalculatedSquaresFrame(CalculatedSquares cS1) {
        Dimension dim = new Dimension(330 * cS1.getSizeX(), 130 * cS1.getSizeY());
        this.setSize(dim);

        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

}
