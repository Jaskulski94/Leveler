package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterPanel;
import com.jaskulski.app.UI.SquareGridPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.io.*;


public class StartingConditionsHandler {
    private UILauncherFrame UILauncher;
    private StartingConditions startingConditionsBU;

    public StartingConditionsHandler(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public StartingConditionsHandler() {
    }

    public void setStartingConditions(StartingConditions startingConditions1) {
        this.startingConditionsBU = startingConditions1;
    }

    public StartingConditions getStartingConditions() {
        return startingConditionsBU;
    }

    public void serializeStartingConditions(StartingConditions startingConditions) {
        String path = StartingConditions.currentProject;

        String error1 = "Błąd: Wystąpił problem przy tworzeniu nowego pliku";
        String error2 = "Błąd: Wystąpił problem przy zapisywaniu do pliku";
        String message = "Stworzono nowy plik";
        try {
            File serFile = new File(path + "/StartingConditions.ser");

            if (serFile.createNewFile()) {
                JOptionPane.showMessageDialog(null, message);
            }

            FileOutputStream fileOStream = new FileOutputStream(serFile);
            ObjectOutputStream objectOStream = new ObjectOutputStream(fileOStream);

            objectOStream.writeObject(startingConditions);
            objectOStream.flush();

            objectOStream.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, error1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, error2);
        }
    }

    public StartingConditions deserializeSCFromChooser() {
        String pathString = StartingConditions.projectsDir;
        File selectedFile = new File(pathString);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        StartingConditions.currentProject += selectedFile.getParentFile().getName();
        StartingConditions startingConditions = deserializeStartingConditions(selectedFile);
        return startingConditions;
    }

    public StartingConditions deserializeSCFromFixedPath() {
        String pathString = StartingConditions.currentProject + "/StartingConditions.ser";
        File selectedFile = new File(pathString);

        StartingConditions startingConditions = deserializeSCWithoutUI(selectedFile);
        return startingConditions;
    }

    public StartingConditions deserializeStartingConditions(File selectedFile) {
        String error1 = "Błąd: Nie można wczytać danych tego projektu";
        String error2 = "Błąd: Wystąpił problem przy odczytywaniu z pliku";
        String message = "Odczytano dane z pliku";
        StartingConditions startingConditions = new StartingConditions();
        try {
            startingConditions = tryDeserializationSC(selectedFile);

            JOptionPane.showMessageDialog(null, message);
            UILauncher.changePanel(new SquareGridPanel(startingConditions.getSizeX(), startingConditions.getSizeY()));

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, error1);
            UILauncher.changePanel(new ProjectStarterPanel(UILauncher));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, error2);
            UILauncher.changePanel(new ProjectStarterPanel(UILauncher));
        }
        return startingConditions;
    }

    public StartingConditions deserializeSCWithoutUI(File selectedFile) {
        String error = "Błąd odczytu danych";
        StartingConditions startingConditions = new StartingConditions();
        try {
            startingConditions = tryDeserializationSC(selectedFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, error);
        }
        return startingConditions;
    }

    public StartingConditions tryDeserializationSC(File selectedFile) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIStream = new FileInputStream(selectedFile);
        ObjectInputStream objectIStream = new ObjectInputStream(fileIStream);

        Object inputObject = objectIStream.readObject();
        StartingConditions startingConditions = (StartingConditions) inputObject;

        objectIStream.close();
        //    this.startingConditions = startingConditions;
        return startingConditions;
    }


    /*public boolean checkIfDivisible (StartingConditions.Slope slope1){
        double checkedSize = slope1.getSide() / startingConditions.getSquareSide();
        boolean divisible;
        if (checkedSize == Math.floor(checkedSize)) {
            divisible = true;
        } else{
            divisible = false;
        }
        return divisible;
    }*/

    public boolean isDivisible(StartingConditions startingConditions1, StartingConditions.Slope slope1) {
        double checkedSize = slope1.getSide() / startingConditions1.getSquareSide();
        boolean divisible;
        if (checkedSize == Math.floor(checkedSize)) {
            divisible = true;
        } else {
            divisible = false;
        }
        return divisible;
    }


}
