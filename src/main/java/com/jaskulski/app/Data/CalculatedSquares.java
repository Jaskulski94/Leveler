package com.jaskulski.app.Data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CalculatedSquares {
    public SingleSquare[][] squares;

    @Data
    public class SingleSquare{
        public SingleSquare(){
            leftTopCor = new SquarePoint();
            rightTopCor = new SquarePoint();
            leftDownCor = new SquarePoint();
            rightDownCor = new SquarePoint();
        }

        int index;

        public SquarePoint leftTopCor;
        public SquarePoint rightTopCor;
        public SquarePoint leftDownCor;
        public SquarePoint rightDownCor;

        public List<SquarePoint> zeroSquarePoints = new ArrayList<>();

        /*double zeroPointX1;
        double zeroPointY1;
        double zeroPointX2;
        double zeroPointY2;*/

        double addArea;
        double addVolume;
        double subtractArea;
        double subtractVolume;

        public void setFourCornersXAndY(int x1, int y1, double squareSize1){
            leftTopCor.setPointsXAndY(x1*squareSize1, y1*squareSize1);
            rightTopCor.setPointsXAndY((x1+1)*squareSize1, y1*squareSize1);
            leftDownCor.setPointsXAndY(x1*squareSize1, (y1+1)*squareSize1);
            rightDownCor.setPointsXAndY((x1+1)*squareSize1, (y1+1)*squareSize1);
        }

        public void setFourCornersH(double h1, double h2, double h3, double h4){
            leftTopCor.setOrdinateH(h1);
            rightTopCor.setOrdinateH(h2);
            leftDownCor.setOrdinateH(h3);
            rightDownCor.setOrdinateH(h4);
        }

        public void addNewZeroPoint(double x1, double y1, double h1){
            zeroSquarePoints.add(new SquarePoint(x1, y1, h1));
        }

        @Data
        public class SquarePoint {
            double ordinateX;
            double ordinateY;
            double ordinateH;

            public SquarePoint(){}

            public SquarePoint(double x1, double y1, double h1){
                this.ordinateX = x1;
                this.ordinateY = y1;
                this.ordinateH = h1;
            }

            public void setPointsXAndY(double ordinateX1, double ordinateY1){
                this.ordinateX = ordinateX1;
                this.ordinateY = ordinateY1;
            }

           /* public SquarePoint convertSGZeroPoint(SquareGrid.ZeroPoint point){

            }*/
        }
    }
}
