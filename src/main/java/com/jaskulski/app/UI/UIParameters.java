package com.jaskulski.app.UI;

import java.awt.*;

public class UIParameters {
    public static Font fontBig;
    public static Font fontMedium;
    public static Font fontSmall;
    public static Font fontTiny;

    public static Dimension dimScreen;
    public static Dimension dimFrame;
    public static int frameWidth;
    public static int frameHeight;

    public static void setScreenDim(){
        dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
    }

    public static void setFrameSize(){
        frameWidth = dimScreen.width/3;
        frameHeight = dimScreen.height*2/3;
        dimFrame = new Dimension(frameWidth, frameHeight);
    }

    public static void initializeFonts(){
        int fontSize = frameHeight/14;
        fontBig = new Font ("Palatino", Font.BOLD, fontSize);
        fontMedium = new Font ("Palatino", Font.BOLD, fontSize/2);
        fontSmall = new Font ("Arial", Font.PLAIN, fontSize/2);
        fontTiny = new Font ("Arial", Font.PLAIN, fontSize/3);
    }

    public static void initializeParameters(){
        setScreenDim();
        setFrameSize();
        initializeFonts();
    }
}
