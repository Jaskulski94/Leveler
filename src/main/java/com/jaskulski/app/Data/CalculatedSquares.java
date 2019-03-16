package com.jaskulski.app.Data;

import lombok.Data;

@Data
public class CalculatedSquares {
    public SingleSquare[][] squares;

    @Data
    public class SingleSquare{
        int index;

        double leftTopOrd;
        double rightTopOrd;
        double leftDownOrd;
        double rightDownOrd;

        double zeroPoinX1;
        double zeroPoinY1;
        double zeroPoinX2;
        double zeroPoinY2;

        double addArea;
        double addVolume;
        double substractArea;
        double substractVolume;
    }
}
