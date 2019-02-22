package com.jaskulski.app.Controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.nio.file.Paths;
import java.nio.file.Files;

public class NewProjectNamerListener implements ActionListener {

    String txt;

    public NewProjectNamerListener (String txt1){
        this.txt = txt1;
    }

    public void actionPerformed(ActionEvent arg0) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);

        Path path = Paths.get("src/main/java/com/jaskulski/app/ProjectsFiles/"+txt+"_"+date);

        try{
            Files.createDirectories(path);
            JOptionPane.showMessageDialog(null, "Stworzono folder nowego projektu");
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Wystąpił problem przy tworzeniu folderu");
        }



        /*File newDirecotry = new File(path + txt + "_" + date);

        if(newDirecotry.mkdir()){
            JOptionPane.showMessageDialog(null, "Stworzono folder nowego projektu");
        } else {
            JOptionPane.showMessageDialog(null, "Wystąpił problem przy tworzeniu folderu");
        }*/
    }
}
