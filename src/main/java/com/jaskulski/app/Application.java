package com.jaskulski.app;

import com.jaskulski.app.UI.UILauncher;
import com.jaskulski.app.UI.UIParameters;

public class Application {
    public static void main(String[] args) {

        UIParameters.initializeParameters();

        UILauncher launcher = new UILauncher();
        launcher.initializeUI();

    }

}
