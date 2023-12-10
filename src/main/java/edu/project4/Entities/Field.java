package edu.project4.Entities;

public class Field {
    private Pixel[][] space;

    public Field(int width, int height) {
        space = new Pixel[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                space[i][j] = new Pixel(new PixelColor(0, 0, 0), 0);
            }
        }
    }

    public void updatePoint(int x, int y, Pixel pixel) {
        space[x][y] = pixel;
    }

    public Pixel getPixel(int x, int y) {
        return space[x][y];
    }
}
