package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterPanel;
import com.jaskulski.app.UI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartingConditionsHandler {
    private UILauncherFrame UILauncher;
    private StartingConditions startingConditions;

    public StartingConditionsHandler(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public StartingConditionsHandler(){
        //maybe useless, check later
        /*this.UILauncher = new UILauncherFrame();
        UILauncher.dispatchEvent(new WindowEvent(UILauncher, WindowEvent.WINDOW_CLOSING));*/
    }

    public void getStartingConditions (StartingConditions startingConditions1){
        this.startingConditions = startingConditions1;
    }

    public void serializeStartingConditions (StartingConditions startingConditions){
        String path = StartingConditions.currentProject;

        String error1 = "Błąd: Wystąpił problem przy tworzeniu nowego pliku";
        String error2 = "Błąd: Wystąpił problem przy zapisywaniu do pliku";
        String message = "Stworzono nowy plik";
        try {
            File serFile = new File(path+"/StartingConditions.ser");

            if(serFile.createNewFile()){
                JOptionPane.showMessageDialog(null, message);
            }

            FileOutputStream fileOStream = new FileOutputStream(serFile);
            ObjectOutputStream objectOStream = new ObjectOutputStream(fileOStream);

            objectOStream.writeObject(startingConditions);
            objectOStream.flush();

            objectOStream.close();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, error1);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, error2);
        }
    }

    public void deserializeSCFromChooser(StartingConditions startingConditions) {
        String pathString = StartingConditions.projectsDir;
        File selectedFile = new File(pathString);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        StartingConditions.currentProject += selectedFile.getParentFile().getName();
        deserializeStartingConditions(selectedFile, startingConditions);
    }

    public void deserializeSCFromFixedPath (StartingConditions startingConditions) {
        String pathString = StartingConditions.currentProject + "/StartingConditions.ser";
        File selectedFile = new File(pathString);

        deserializeStartingConditions(selectedFile, startingConditions);
    }

        public void deserializeStartingConditions (File selectedFile, StartingConditions startingConditions){
        String error1 = "Błąd: Nie można wczytać danych tego projektu";
        String error2 = "Błąd: Wystąpił problem przy odczytywaniu z pliku";
        String message = "Odczytano dane z pliku";

        try {
            FileInputStream fileIStream = new FileInputStream(selectedFile);
            ObjectInputStream objectIStream = new ObjectInputStream(fileIStream);

            Object inputObject = objectIStream.readObject();
            startingConditions = (StartingConditions) inputObject;

            objectIStream.close();
            JOptionPane.showMessageDialog(null, message);
            UILauncher.changePanel(new SquareGridPanel(startingConditions.getSizeX(), startingConditions.getSizeY()));

        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, error1);
            UILauncher.changePanel(new ProjectStarterPanel(UILauncher));
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, error2);
            UILauncher.changePanel(new ProjectStarterPanel(UILauncher));
        }

    }

    public boolean checkIfDivisible (StartingConditions.Slope slope1){
        double checkedSize = slope1.getSide() / startingConditions.getSquareSide();
        boolean divisible;
        if (checkedSize == Math.floor(checkedSize)) {
            divisible = true;
        } else{
            divisible = false;
        }
        return divisible;
    }


}
