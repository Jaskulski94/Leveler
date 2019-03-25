package com.jaskulski.app.UI;

import java.awt.*;

public class UIParameters {
    public static Font fontBig;
    public static Font fontMedium;
    public static Font fontSmall;
    public static Font fontTiny;

    public static Dimension dimScreen;
    public static Dimension dimFrame;
    public static Dimension dimFrame2;
    public static Dimension dimFrameSmall;
    public static int frameWidth;
    public static int frameHeight;

    private static void setDimScreen() {
        dimScreen = Toolkit.getDefaultToolkit().getScreenSize();
    }

    private static void setDimFrame() {
        frameWidth = dimScreen.width / 3;
        frameHeight = dimScreen.height * 2 / 3;
        dimFrame = new Dimension(frameWidth, frameHeight);
        dimFrame2 = new Dimension(frameWidth * 2, (int) dimScreen.getHeight() - 100);
        int y = (int) dimScreen.getHeight() / 6;
        dimFrameSmall = new Dimension(y, y);
    }

    private static void initializeFonts() {
        int fontSize = frameHeight / 20;
        fontBig = new Font("Palatino", Font.BOLD, fontSize);
        fontMedium = new Font("Palatino", Font.BOLD, fontSize / 2);
        fontSmall = new Font("Arial", Font.PLAIN, fontSize / 2);
        fontTiny = new Font("Arial", Font.PLAIN, fontSize / 3);
    }

    public static void initializeParameters() {
        setDimScreen();
        setDimFrame();
        initializeFonts();
    }

    public static void setFontToAll(Component component, Font font) {
        component.setFont(font);
        if (component instanceof Container) {
            for (Component child : ((Container) component).getComponents()) {
                setFontToAll(child, font);
            }
        }
    }
}
