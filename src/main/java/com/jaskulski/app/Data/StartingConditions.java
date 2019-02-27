package com.jaskulski.app.Data;

import lombok.Data;

import java.nio.file.Path;
import java.io.Serializable;
import java.nio.file.Paths;

@Data
public class StartingConditions implements Serializable {

    public static Path currentProject = Paths.get("src/main/java/com/jaskulski/app/ProjectsFiles/");

    public Slope slopeX = new Slope();
    public Slope slopeY = new Slope();

    private double squareSide = 0;
    private double fieldLean = 0;

    public int sizeX;
    public int sizeY;

    public static void setCurrentProject(Path currentProject1){
        StartingConditions.currentProject = currentProject1;
    }

    public void setSlopeValues(Slope slope1, double side1, double slopeWidth1, double slopeTilt1) {
        slope1.side = side1;
        slope1.slopeWidth = slopeWidth1;
        slope1.slopeTilt = slopeTilt1;
    }

    public Slope getSlopeX() {
        return slopeX;
    }

    public Slope getSlopeY() {
        return slopeY;
    }

    public void setSizes() {
        sizeX = (int) (slopeX.side / squareSide);
        sizeY = (int) (slopeY.side / squareSide);
    }

    public void printAll() {
        System.out.println(squareSide + " " + fieldLean);
        System.out.println("Slope A:");
        System.out.println(slopeX.side + " " + slopeX.slopeWidth + " " + slopeX.slopeTilt);
        System.out.println("Slope B:");
        System.out.println(slopeY.side + " " + slopeY.slopeWidth + " " + slopeY.slopeTilt);
    }

    @Data
    public class Slope implements Serializable{
        private double side = 0;
        private double slopeWidth = 0;
        private double slopeTilt = 0;
    }
}
