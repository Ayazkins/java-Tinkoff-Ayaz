package edu.project4;

import edu.project4.Entities.Field;
import edu.project4.Entities.Pixel;
import edu.project4.Entities.PixelColor;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Image {
    private final static int COLOR_SCALE = 255;
    private final Field field;
    private final int width;
    private final int height;

    public Image(int width, int height, Field field) {
        this.field = field;
        this.width = width;
        this.height = height;
    }

    public void createImage(String path) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                Pixel pixel = field.getPixel(x, y);
                Color awtColor = new Color(
                    (int) (pixel.color().r() * COLOR_SCALE),
                    (int) (pixel.color().g() * COLOR_SCALE),
                    (int) (pixel.color().b() * COLOR_SCALE)
                );
                image.setRGB(x, y, awtColor.getRGB());
            }
        }

        File file = new File(path + ".jpg");
        try {
            ImageIO.write(image, "jpg", file);
        } catch (IOException ignored) {
        }
    }

    public void correction(double gamma) {
        double max = 0.0;
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                if (field.getPixel(i, j).hitCount() != 0) {
                    double normal = Math.log10(field.getPixel(i, j).hitCount());
                    if (normal > max) {
                        max = normal;
                    }
                }
            }
        }
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                double normal = Math.log10(field.getPixel(i, j).hitCount());
                normal /= max;
                double r;
                double g;
                double b;
                r = field.getPixel(i, j).color().r() * Math.pow(normal, (1.0 / gamma));
                g = field.getPixel(i, j).color().g() * Math.pow(normal, (1.0 / gamma));
                b = field.getPixel(i, j).color().b() * Math.pow(normal, (1.0 / gamma));
                field.updatePoint(i, j, new Pixel(new PixelColor(r, g, b), field.getPixel(i, j).hitCount()));
            }
        }
    }
}
