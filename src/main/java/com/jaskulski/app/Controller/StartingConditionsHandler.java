package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;
import java.io.*;
import java.nio.file.Path;

public class StartingConditionsHandler {

    public StartingConditionsHandler() {
    }

    public void serializeStartingConditions (StartingConditions startingConditions){
        Path path = StartingConditions.currentProject;

        String error1 = "Błąd: Wystąpił problem przy tworzeniu nowego pliku";
        String error2 = "Błąd: Wystąpił problem przy zapisywaniu do pliku";

        try {
            File serFile = new File(path+"StartingConditions.ser");
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
