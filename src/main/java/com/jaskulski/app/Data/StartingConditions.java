package com.jaskulski.app.Data;

import lombok.Data;

@Data
public class StartingConditions {

    private Slope slopeA = new Slope();
    private Slope slopeB = new Slope();

    private double squareSide = 0;
    private double fieldLean = 0;

    class Slope{
        private double side = 0;
        private double slopeWidth = 0;
        private double slopeTilt = 0;
    }
}
