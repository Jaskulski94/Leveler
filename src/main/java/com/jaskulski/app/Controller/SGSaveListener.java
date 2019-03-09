package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.SquareGrid;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SGSaveListener implements ActionListener {

    SquareGridSerializer sQSerializer;
    SquareGrid squareGrid;

    public SGSaveListener (SquareGrid squareGrid1){
        this.sQSerializer = new SquareGridSerializer();
        this.squareGrid = squareGrid1;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        sQSerializer.serializeSquareGrid(squareGrid);
        JOptionPane.showMessageDialog(null, "Zapisywanie skończone");
    }
}
