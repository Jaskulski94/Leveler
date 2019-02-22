package com.jaskulski.app;

import com.jaskulski.app.UI.UILauncherFrame;
import com.jaskulski.app.UI.UIParameters;

public class Application {
    public static void main(String[] args) {

        UIParameters.initializeParameters();

        UILauncherFrame launcher = new UILauncherFrame();
        launcher.initializeUI();

    }

}
