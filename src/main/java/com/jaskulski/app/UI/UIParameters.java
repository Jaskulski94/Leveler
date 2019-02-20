package com.jaskulski.app.UI;

import java.awt.*;

public class UIParameters {
    public static Font fontBig;
    public static Font fontMedium;
    public static Font fontSmall;
    public static Font fontTiny;

    public static Dimension screenDim; // = Toolkit.getDefaultToolkit().getScreenSize();
    public static int frameWidth; // = Scheme.SCREEN_DIM.width/5;
    public static int frameHeight; // = Scheme.SCREEN_DIM.height*2/5;

    public static void setScreenDim(){

    }

    public static void setFrameSize(){

    }

    public static void initializeFonts(){
        int fontSize = frameHeight/14;
        fontBig = new Font ("Palatino", Font.BOLD, fontSize);
        fontMedium = new Font ("Palatino", Font.BOLD, fontSize/2);
        fontSmall = new Font ("Arial", Font.PLAIN, fontSize/2);
        fontTiny = new Font ("Arial", Font.PLAIN, fontSize/3);
    }
}
