package com.jaskulski.app.Controller.UIControl.ProjectStarterControl;

import com.jaskulski.app.Controller.DataHandling.BasicSerializer;
import com.jaskulski.app.Controller.DataHandling.SquareGridHandling.SquareGridFiller;
import com.jaskulski.app.Controller.DataHandling.SquareGridHandling.SquareGridSerializer;
import com.jaskulski.app.Controller.DataHandling.StartingConditionsHandling.StartingConditionsSerializer;
import com.jaskulski.app.Data.SquareGrid;
import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.ProjectStarterPanel;
import com.jaskulski.app.UI.SquareGridUI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadProjectListener implements ActionListener {

    private UILauncherFrame UILauncher;
    private StartingConditions startingConditions;
    private StartingConditionsSerializer startingConditionsSerializer;
    private SquareGrid squareGrid;
    private SquareGridSerializer squareGridSerializer;
    protected JPanel newPanel;

    public LoadProjectListener(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
        startingConditionsSerializer = new StartingConditionsSerializer(UILauncher);
        squareGridSerializer = new SquareGridSerializer(UILauncher);
    }

    public void actionPerformed(ActionEvent arg0) {
        loadDataFromSelected();
    }

    private void loadDataFromSelected() {
        try {
            BasicSerializer serializer = new BasicSerializer();
            serializer.setUILauncher(UILauncher);
            Object object = serializer.deserializeFromChooser();
            if (object instanceof StartingConditions) {
                startingConditions = startingConditionsSerializer.deserializeSCFromFixedPath();
                UILauncher.changePanel(new SquareGridPanel(startingConditions, UILauncher));
            } else if (object instanceof SquareGrid) {
                startingConditions = startingConditionsSerializer.deserializeSCFromFixedPath();
                squareGrid = squareGridSerializer.deserializeSCFromFixedPath();
                SquareGridPanel squareGridPanel = new SquareGridPanel(startingConditions, UILauncher);
                UILauncher.changePanel(squareGridPanel);
                SquareGridFiller squareGridFiller = new SquareGridFiller(squareGrid, squareGridPanel);
                squareGridFiller.fillSquareFields();
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Otwieranie pliku nie powiodło się");
            newPanel = new ProjectStarterPanel(UILauncher);
        //    UILauncher.changePanel(new ProjectStarterPanel(UILauncher));
        }
    }

    public void changeAction(){
        UILauncher.changePanel(newPanel);
    }
}
