package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Path;

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
            objectOStream.close();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, error1);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, error2);
        }
    }

    public void deserializeStartingConditions (StartingConditions startingConditions){

        Path path = StartingConditions.currentProject;
        File selectedFile = new File(path+"/StartingConditions.ser");

    //    JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
     //       System.out.println(selectedFile.getAbsolutePath());
        }


        String error1 = "Błąd: Nie można wczytać danych początkowych projektu";
        String error2 = "Błąd: Wystąpił problem przy zapisywaniu do pliku";
        String message = "Stworzono nowy plik";
        try {
            File serFile = new File(path+"/StartingConditions.ser");

            FileOutputStream fileOStream = new FileOutputStream(serFile);
            ObjectOutputStream objectOStream = new ObjectOutputStream(fileOStream);

            objectOStream.writeObject(startingConditions);
            objectOStream.close();
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, error1);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, error2);
        }
    }
}
