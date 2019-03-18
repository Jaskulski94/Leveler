package com.jaskulski.app.Controller;

import com.jaskulski.app.Data.StartingConditions;
import com.jaskulski.app.UI.UILauncherFrame;
import javax.swing.*;
import java.io.*;

public class BasicSerializer {

    private UILauncherFrame UILauncher;
    protected JPanel newPanel;
    protected JPanel errorPanel;
    private JPanel nextPanel;

    public BasicSerializer(UILauncherFrame UILauncher1) {
        this.UILauncher = UILauncher1;
    }

    protected BasicSerializer() {
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

    protected Object deserializeFromChooser() {
        String pathString = StartingConditions.projectsDir;
        File selectedFile = new File(pathString);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(selectedFile);

        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
        }

        StartingConditions.currentProject += selectedFile.getParentFile().getName();
        return (deserializeWithUI(selectedFile));
    }

    protected Object deserializeFromFixedPath(String fileName) {
        String pathString = StartingConditions.currentProject + fileName;
        File selectedFile = new File(pathString);

        return (deserializeWithoutUI(selectedFile));
    }

    public Object deserializeWithUI(File selectedFile) {
        String error1 = "BasicSerializer Error: Nie można wczytać danych tego projektu";
        String error2 = "BasicSerializer Error: Wystąpił problem przy odczytywaniu z pliku";
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

    protected void changeToNextPanel(UILauncherFrame UILauncher1){
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
        FileInputStream fileIStream = new FileInputStream(selectedFile);
        ObjectInputStream objectIStream = new ObjectInputStream(fileIStream);

        Object outputObject = objectIStream.readObject();

        objectIStream.close();
        return outputObject;
    }
}
