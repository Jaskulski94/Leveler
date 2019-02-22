package com.jaskulski.app.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class NewProjectNamerListener implements ActionListener {

    String txt;

    public NewProjectNamerListener (String txt1){
        this.txt = txt1;
    }

    public void actionPerformed(ActionEvent arg0) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        String date = dtf.format(localDate);

        String path = "src/main/java/com/jaskulski/app/ProjectsFiles/";

        new File(path + txt + "_" + date).mkdir();
    }
}
