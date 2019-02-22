package com.jaskulski.app.Data;

import lombok.Data;

@Data
public class StartingConditions {

    public Slope slopeA = new Slope();
    public Slope slopeB = new Slope();

    private double squareSide = 0;
    private double fieldLean = 0;

    public void setSlopeValues (Slope slope1, double side1, double slopeWidth1, double slopeTilt1){
        slope1.side = side1;
        slope1.slopeWidth = slopeWidth1;
        slope1.slopeTilt = slopeTilt1;
    }

    public Slope getSlopeA(){
        return slopeA;
    }

    public Slope getSlopeB(){
        return slopeB;
    }

    @Data
    public class Slope{
        private double side = 0;
        private double slopeWidth = 0;
        private double slopeTilt = 0;

        /*public void setSlopeValues (double side1, double slopeWidth1, double slopeTilt1){
            this.side = side1;
            this.slopeWidth = slopeWidth1;
            this.slopeTilt = slopeTilt1;
        }*/
    }

    public void printAll(){
        System.out.println(squareSide+" "+fieldLean);
        System.out.println("Slope A:");
        System.out.println(slopeA.side+" "+slopeA.slopeWidth+" "+slopeA.slopeTilt);
        System.out.println("Slope B:");
        System.out.println(slopeB.side+" "+slopeB.slopeWidth+" "+slopeB.slopeTilt);

    }
}
