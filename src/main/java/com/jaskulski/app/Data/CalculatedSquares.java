package com.jaskulski.app.Data;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CalculatedSquares {
    public SingleSquare[][] squares;
    public int sizeX;
    public int sizeY;

    public CalculatedSquares() {
    }

    public void setSizes(int x1, int y1) {
        this.sizeX = x1;
        this.sizeY = y1;
        squares = new SingleSquare[x1][y1];
        for (int i = 0; i < x1; i++) {
            for (int j = 0; j < x1; j++) {
                squares[i][j] = new SingleSquare();
            }
        }
    }

    @Data
    public class SingleSquare {
        public SingleSquare() {
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

        double addArea;
        double addVolume;
        double subtractArea;
        double subtractVolume;

        public void setFourCornersXAndY(int x1, int y1, double squareSize1) {
            leftTopCor.setPointsXAndY(x1 * squareSize1, y1 * squareSize1);
            rightTopCor.setPointsXAndY((x1 + 1) * squareSize1, y1 * squareSize1);
            leftDownCor.setPointsXAndY(x1 * squareSize1, (y1 + 1) * squareSize1);
            rightDownCor.setPointsXAndY((x1 + 1) * squareSize1, (y1 + 1) * squareSize1);
        }

        public void setFourCornersH(double h1, double h2, double h3, double h4) {
            leftTopCor.setOrdinateH(h1);
            rightTopCor.setOrdinateH(h2);
            leftDownCor.setOrdinateH(h3);
            rightDownCor.setOrdinateH(h4);
        }

        public void setFourTerrainH(double h1, double h2, double h3, double h4) {
            leftTopCor.setTerrainH(h1);
            rightTopCor.setTerrainH(h2);
            leftDownCor.setTerrainH(h3);
            rightDownCor.setTerrainH(h4);
        }

        public void addNewZeroPoint(double x1, double y1, double h1, double tH1) {
            zeroSquarePoints.add(new SquarePoint(x1, y1, h1, tH1));
        }

        public void setAreasAndVolumes(double addA1, double addV1, double subA1, double subV1) {
            this.addArea = addA1;
            this.addVolume = addV1;
            this.subtractArea = subA1;
            this.subtractVolume = subV1;
        }

        @Data
        public class SquarePoint {
            double ordinateX;
            double ordinateY;
            double ordinateH;
            double terrainH;

            public SquarePoint() {
            }

            public SquarePoint(double x1, double y1, double h1, double tH1) {
                this.ordinateX = x1;
                this.ordinateY = y1;
                this.ordinateH = h1;
                this.terrainH = tH1;
            }

            public void setPointsXAndY(double ordinateX1, double ordinateY1) {
                this.ordinateX = ordinateX1;
                this.ordinateY = ordinateY1;
            }
        }
    }
}
