package com.jaskulski.app.UI;

import com.jaskulski.app.Controller.SGBackListener;
import com.jaskulski.app.Controller.SGSaveListener;
import com.jaskulski.app.Controller.ShowSCListener;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;
import java.awt.*;

public class SquareGridPanel extends JPanel {
    private UILauncherFrame UILauncher;
    private int sizeX, sizeY;
    private JTextField[][] txtSquares;
    private JLabel[][] lblIndex;
    private GridBagConstraints GBC;
    private StartingConditions startingConditions;
    private SquareGrid squareGrid;

    public SquareGridPanel(StartingConditions startingConditions1, UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
        this.startingConditions = startingConditions1;

        initializeSquareGridPanel();
    }

    public SquareGridPanel(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public void setStartingConditionsAndInitiate(StartingConditions startingConditions) {
        this.startingConditions = startingConditions;
        initializeSquareGridPanel();
    }

    public void initializeSquareGridPanel(){
        this.sizeX = startingConditions.getSizeX();
        this.sizeY = startingConditions.getSizeY();

        GridBagLayout gridBagLayout = new GridBagLayout();
        GBC = new GridBagConstraints();
        this.setLayout(gridBagLayout);
        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.fill = GridBagConstraints.BOTH;
        GBC.weightx = 1;
        GBC.weighty = 1;

        txtSquares = new JTextField[sizeX][sizeY];
        lblIndex = new JLabel[sizeX][sizeY];

        addTextFields();

        WhiteButton btnPrevious = new WhiteButton("Cofnij");
        btnPrevious.addActionListener(new SGBackListener(UILauncher, new NewProjectInitiatorPanel(UILauncher)));

        WhiteButton btnShowCS = new WhiteButton("Założenia");
        btnShowCS.addActionListener(new ShowSCListener());

        WhiteButton btnSave = new WhiteButton("Zapisz zmiany");
        btnSave.addActionListener(new SGSaveListener(squareGrid));

        WhiteButton btnNext = new WhiteButton("Dalej");


        JPanel pnlButtons = new JPanel();
        pnlButtons.setLayout(new GridBagLayout());

        GBC.gridy++;
        GBC.gridx = 0;

        int[][] dim = gridBagLayout.getLayoutDimensions();
        int columns = dim[0].length;

        GBC.gridwidth = columns;
        GBC.fill = GridBagConstraints.BOTH;

        this.add(pnlButtons, GBC);
        GBC.gridwidth = 1;
        pnlButtons.add(btnPrevious, GBC);
        GBC.gridx++;
        pnlButtons.add(btnShowCS, GBC);
        GBC.gridx++;
        pnlButtons.add(btnSave, GBC);
        GBC.gridx++;
        pnlButtons.add(btnNext, GBC);

        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        UIParameters.setFontToAll(pnlButtons, UIParameters.fontMedium);
    }

    public void addTextFields() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                GBC.gridx = i;
                GBC.gridy = j;
                txtSquares[i][j] = new JTextField();
                this.add(txtSquares[i][j], GBC);

                String index = (i + 1) + "-" + (j + 1);
                lblIndex[i][j] = new JLabel(index);
                this.add(lblIndex[i][j], GBC);
                lblIndex[i][j].setVisible(true);
            }
        }
    }
}
