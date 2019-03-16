package com.jaskulski.app.UI.SquareGridUI;

import com.jaskulski.app.Controller.ChangePanelListener;
import com.jaskulski.app.Controller.SquareGridPanelControl.SGBackListener;
import com.jaskulski.app.Controller.SquareGridPanelControl.SGNextListener;
import com.jaskulski.app.Controller.SquareGridPanelControl.SGSaveListener;
import com.jaskulski.app.Controller.SquareGridPanelControl.ShowSCListener;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.NewProjectInitiatorPanel;
import com.jaskulski.app.UI.UILauncherFrame;
import com.jaskulski.app.UI.UIParameters;
import com.jaskulski.app.UI.WhiteButton;

import javax.swing.*;
import java.awt.*;

public class SquareGridPanel extends JPanel {
    private JLabel lblPanelName;
    private UILauncherFrame UILauncher;
    private int sizeX, sizeY;
    public JTextField[][] txtSquares;
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
        squareGrid = new SquareGrid(sizeX, sizeY);

        txtSquares = new JTextField[sizeX][sizeY];
        lblIndex = new JLabel[sizeX][sizeY];

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        lblPanelName = new JLabel();
        lblPanelName.setText("Rzędne terenowe");
        lblPanelName.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(lblPanelName);

        this.add(Box.createVerticalGlue());

        GridBagLayout gridBagLayout = new GridBagLayout();
        GBC = new GridBagConstraints();
        GBC.gridx = 0;
        GBC.gridy = 0;
        GBC.fill = GridBagConstraints.BOTH;
        GBC.weightx = 1;
        GBC.weighty = 1;

        JPanel pnlSquareGrid = new JPanel();
        pnlSquareGrid.setLayout(gridBagLayout);

        Dimension dimSquaresMax = new Dimension(UIParameters.frameWidth*sizeX/4, UIParameters.frameHeight*sizeY/10);
        pnlSquareGrid.setMaximumSize(dimSquaresMax);

        Dimension dimSquaresPref = new Dimension(UIParameters.frameWidth, UIParameters.frameHeight*sizeY/10);
        pnlSquareGrid.setPreferredSize(dimSquaresPref);

        addTextFields(pnlSquareGrid);
        this.add(pnlSquareGrid);

        this.add(Box.createVerticalGlue());

        JPanel pnlButtons = new JPanel();
        Dimension dimButtons = new Dimension(UIParameters.frameWidth, (int) Math.round(UIParameters.frameHeight*0.2));
        pnlButtons.setMaximumSize(dimButtons);
        pnlButtons.setLayout(new GridBagLayout());

        addButtons(pnlButtons);
        this.add(pnlButtons);

        UIParameters.setFontToAll(this, UIParameters.fontSmall);
        lblPanelName.setFont(UIParameters.fontBig);
        UIParameters.setFontToAll(pnlButtons, UIParameters.fontMedium);
    }

    private void addButtons(JPanel panel1){
        WhiteButton btnPrevious = new WhiteButton("Cofnij");
        btnPrevious.addActionListener(new SGBackListener(UILauncher, new NewProjectInitiatorPanel(UILauncher)));

        WhiteButton btnShowCS = new WhiteButton("Założenia");
        btnShowCS.addActionListener(new ShowSCListener());

        WhiteButton btnSave = new WhiteButton("Zapisz zmiany");
        btnSave.addActionListener(new SGSaveListener(squareGrid, startingConditions, this));

        WhiteButton btnNext = new WhiteButton("Dalej");
        btnNext.addActionListener(new SGSaveListener(squareGrid, startingConditions, this));
        btnNext.addActionListener(new SGNextListener(UILauncher, new JPanel(), startingConditions, squareGrid));

        GBC.gridy++;
        GBC.gridx = 0;

        GBC.fill = GridBagConstraints.BOTH;

        GBC.gridwidth = 1;
        panel1.add(btnPrevious, GBC);
        GBC.gridx++;
        panel1.add(btnShowCS, GBC);
        GBC.gridx++;
        panel1.add(btnSave, GBC);
        GBC.gridx++;
        panel1.add(btnNext, GBC);
    }

    private void addTextFields(JPanel panel1) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                GBC.gridx = i;
                GBC.gridy = j;
                txtSquares[i][j] = new JTextField();
                panel1.add(txtSquares[i][j], GBC);
            }
        }
    }

    private void addIdexes(JPanel panel1) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                GBC.gridx = i;
                GBC.gridy = j;
                lblIndex[i][j] = new JLabel(i + " - " + j);
                panel1.add(txtSquares[i][j], GBC);
            }
        }
    }
}
