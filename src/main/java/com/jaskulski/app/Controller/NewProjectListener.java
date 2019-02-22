package com.jaskulski.app.Controller;

import com.jaskulski.app.UI.NewProjectNamer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
                createNewProject();
        }

        public void createNewProject(){
                NewProjectNamer newProjectNamer = new NewProjectNamer();
        }
}
