package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class StartingConditionsHandler {

    public StartingConditionsHandler() {
    }

    public void serializeStartingConditions (StartingConditions startingConditions){
        Path path = StartingConditions.currentProject;

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

    public void deserializeStartingConditions (StartingConditions startingConditions){

        Path path = StartingConditions.currentProject;
        String pathString = path.toString();
        File selectedFile = new File(pathString);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

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

        } catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, error1);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, error2);
        }
    }
}
