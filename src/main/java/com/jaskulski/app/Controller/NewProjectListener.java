package com.jaskulski.app.Controller;

import com.jaskulski.app.UI.NewProjectNamerFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewProjectListener implements ActionListener {

        public void actionPerformed(ActionEvent arg0){
                createNewProject();
        }

        private void createNewProject(){
                NewProjectNamerFrame newProjectNamer = new NewProjectNamerFrame();

        }
}
