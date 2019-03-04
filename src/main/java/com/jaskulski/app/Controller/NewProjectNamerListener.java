package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.NewProjectNamerFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.nio.file.Paths;
import java.nio.file.Files;

public class NewProjectNamerListener implements ActionListener {

    private NewProjectNamerFrame npnFrame;

    public NewProjectNamerListener(NewProjectNamerFrame npnFrame1) {
        this.npnFrame = npnFrame1;
    }

    public void actionPerformed(ActionEvent arg0) {
        createDirectory();
    }

    private void createDirectory() {
        String txt;
        String basicPath = "src/main/java/com/jaskulski/app/ProjectsFiles/";
        String projectName;
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);
        txt = npnFrame.txtProjectName.getText();
        projectName = txt + "_" + date;
        String path = basicPath + projectName;

        try {
            Files.createDirectories(Paths.get(path));
            JOptionPane.showMessageDialog(null, "Stworzono folder nowego projektu");
            StartingConditions.setCurrentProject(path);
            npnFrame.closeWindow();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Wystąpił problem przy tworzeniu folderu");
        }
    }


}
