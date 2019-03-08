package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.UILauncherFrame;
import javax.swing.*;
import java.io.*;

public class SerializationHanlder {

    private UILauncherFrame UILauncher;
    public JPanel newPanel;
    public JPanel errorPanel;
    public JPanel nextPanel;

    public SerializationHanlder(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    public SerializationHanlder() {
    }

    public void serialize(Object object, String fileName) {
        String path = StartingConditions.currentProject;

        String error1 = "Błąd: Wystąpił problem przy tworzeniu nowego pliku";
        String error2 = "Błąd: Wystąpił problem przy zapisywaniu do pliku";
        String message = "Stworzono nowy plik";
        try {
            File serFile = new File(path + fileName);

            if (serFile.createNewFile()) {
                JOptionPane.showMessageDialog(null, message);
            }

            FileOutputStream fileOStream = new FileOutputStream(serFile);
            ObjectOutputStream objectOStream = new ObjectOutputStream(fileOStream);

            objectOStream.writeObject(object);
            objectOStream.flush();

            objectOStream.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, error1);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, error2);
        }
    }

    public Object deserializeFromChooser() {
        String pathString = StartingConditions.projectsDir;
        File selectedFile = new File(pathString);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        StartingConditions.currentProject += selectedFile.getParentFile().getName();
        Object object = deserializeWithUI(selectedFile);
        return object;
    }

    public Object deserializeFromFixedPath(String fileName) {
        String pathString = StartingConditions.currentProject + fileName;
        File selectedFile = new File(pathString);

        Object object = deserializeWithoutUI(selectedFile);
        return object;
    }

    public Object deserializeWithUI(File selectedFile) {
        String error1 = "Błąd: Nie można wczytać danych tego projektu";
        String error2 = "Błąd: Wystąpił problem przy odczytywaniu z pliku";
        String message = "Odczytano dane z pliku";
        Object object = new Object();
        try {
            object = tryDeserialization(selectedFile);

            JOptionPane.showMessageDialog(null, message);
            nextPanel = newPanel;

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, error1);
            nextPanel = errorPanel;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, error2);
            nextPanel = errorPanel;
        }
        return object;
    }

    public void changeToNextPanel(UILauncherFrame UILauncher1){
        UILauncher1.changePanel(nextPanel);
    }

    public Object deserializeWithoutUI(File selectedFile) {
        String error = "Błąd odczytu danych";
        Object object = new Object();
        try {
            object = tryDeserialization(selectedFile);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, error);
        }
        return object;
    }


    public Object tryDeserialization (File selectedFile) throws IOException, ClassNotFoundException {
        FileInputStream fileIStream = new FileInputStream(selectedFile);
        ObjectInputStream objectIStream = new ObjectInputStream(fileIStream);

        Object outputObject = objectIStream.readObject();

        objectIStream.close();
        return outputObject;
    }
}
