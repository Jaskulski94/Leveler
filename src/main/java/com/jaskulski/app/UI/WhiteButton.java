package com.jaskulski.app.UI;

import javax.swing.*;
import java.awt.*;

public class WhiteButton extends JButton {
    public WhiteButton (String txt){
        this.setText(txt);
        Dimension dimWhiteButton = new Dimension(UIParameters.frameWidth/4, UIParameters.frameHeight/10);
        this.setBackground(Color.white);
        this.setMinimumSize(dimWhiteButton);
        this.setFont(UIParameters.fontSmall);
    }
}
