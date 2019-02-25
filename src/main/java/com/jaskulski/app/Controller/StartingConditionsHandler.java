package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;

import javax.swing.*;
import java.io.*;

public class StartingConditionsHandler {
    StartingConditions startingConditions;

    public StartingConditionsHandler(StartingConditions startingConditions1) {
        this.startingConditions = startingConditions1;
    }

    public void serializeStartingConditions (String name1){
        String path = "src/main/java/com/jaskulski/app/ProjectsFiles/";

        String error = "Błąd: Wystąpił problem przy zapisywaniu do pliku";
        try {
            FileOutputStream fileOStream = new FileOutputStream(name1);
            ObjectOutputStream objectOStream = new ObjectOutputStream(fileOStream);
        } catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, error);
        } catch (IOException e){

        }
    }

}
