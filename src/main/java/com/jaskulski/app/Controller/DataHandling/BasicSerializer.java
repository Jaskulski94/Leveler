package com.jaskulski.app.Controller.DataHandling;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.ProjectStarterUI.ProjectStarterPanel;
import com.jaskulski.app.UI.UILauncherFrame;

import javax.swing.*;
import java.io.*;

import static com.jaskulski.app.Data.StartingConditions.projectsDir;

public class BasicSerializer {

    protected JPanel newPanel;
    protected JPanel errorPanel;
    private JPanel nextPanel;

    public BasicSerializer() {
        errorPanel = new ProjectStarterPanel();
    }

    public void setUILauncher(UILauncherFrame UILauncher1) {
        ((ProjectStarterPanel) errorPanel).startEmptyProjectStarter(UILauncher1);
    }

    protected void serialize(Object object, String fileName) {
        String path = StartingConditions.currentProject;

        String error1 = "BasicSerializer Error: Wystąpił problem przy tworzeniu nowego pliku";
        String error2 = "BasicSerializer Error: Wystąpił problem przy zapisywaniu do pliku";
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
        File selectedFile = new File(projectsDir);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        StartingConditions.currentProject = projectsDir + selectedFile.getParentFile().getName();
        return (deserializeWithUI(selectedFile));
    }

    protected Object deserializeFromFixedPath(String fileName) {
        String pathString = StartingConditions.currentProject + fileName;
        File selectedFile = new File(pathString);

        return (deserializeWithoutUI(selectedFile));
    }

    public Object deserializeWithUI(File selectedFile) {
        String error1 = "BasicSerializer Error: Nie można wczytać danych tego projektu";
        String error2 = "BasicSerializer Error: Nie wybrano pliku";
        String error3 = "BasicSerializer Error: Wystąpił problem przy odczytywaniu z pliku";
        String message = "Odczytano dane z pliku";
        Object object = new Object();
        try {
            object = tryDeserialization(selectedFile);

            JOptionPane.showMessageDialog(null, message);
            nextPanel = newPanel;

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, error1);
            nextPanel = errorPanel;
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, error2);
            nextPanel = errorPanel;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, error3);
            nextPanel = errorPanel;
        }

        return object;
    }

    protected void changeToNextPanel(UILauncherFrame UILauncher1) {
        UILauncher1.changePanel(nextPanel);
    }

    private Object deserializeWithoutUI(File selectedFile) {
        String error = "BasicSerializer Error: Błąd odczytu danych";
        Object object = new Object();
        try {
            object = tryDeserialization(selectedFile);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, error);
        }
        return object;
    }

    private Object tryDeserialization(File selectedFile) throws IOException, ClassNotFoundException {
        Object outputObject;
        try (FileInputStream fileIStream = new FileInputStream(selectedFile);
             ObjectInputStream objectIStream = new ObjectInputStream(fileIStream)) {
            outputObject = objectIStream.readObject();
        }

        return outputObject;
    }
}
