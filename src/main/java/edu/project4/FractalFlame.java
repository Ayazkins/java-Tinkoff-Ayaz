package edu.project4;

import edu.project4.Entities.Field;
import edu.project4.Entities.Pixel;
import edu.project4.Entities.PixelColor;
import edu.project4.Entities.Point;
import edu.project4.Transformations.AffineCoeffs;
import edu.project4.Transformations.FinalTransformation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FractalFlame {
    private final static double X_MIN = -1;
    private final static double X_MAX = 1;
    private final static double Y_MIN = -1;
    private final static double Y_MAX = 1;

    private final static int NUM_OF_THREADS = 6;
    public static final int SKIP_FIRST_TWENTY = -20;
    private Field field;

    public Image oneThreadGeneration(
        int width,
        int height,
        int amountOfPoints,
        int iterations,
        int amountOfAffine,
        int symmetry,
        FinalTransformation[] finalTransformations
    ) {
        field = new Field(width, height);
        AffineCoeffs[] affine = new AffineCoeffs[amountOfAffine];
        for (int i = 0; i < amountOfAffine; ++i) {
            affine[i] = RandomGenerator.generateAffineTransformation();
        }
        for (int i = 0; i < amountOfPoints; ++i) {
            generate(width, height, iterations, symmetry, finalTransformations, affine);
        }
        return new Image(width, height, field);
    }

    public Image multiThreadGeneration(
        int width,
        int height,
        int amountOfPoints,
        int iterations,
        int amountOfAffine,
        int symmetry,
        FinalTransformation[] finalTransformations
    ) throws InterruptedException {

        field = new Field(width, height);
        AffineCoeffs[] affine = new AffineCoeffs[amountOfAffine];
        for (int i = 0; i < amountOfAffine; ++i) {
            affine[i] = RandomGenerator.generateAffineTransformation();
        }
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_OF_THREADS);
        for (int i = 0; i < amountOfPoints; ++i) {
            executorService.submit(() -> generate(width, height, iterations, symmetry, finalTransformations, affine));
        }
        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        return new Image(width, height, field);
    }

    private void generate(
        int width,
        int height,
        int iterations,
        int sym,
        FinalTransformation[] finalTransformation,
        AffineCoeffs[] affineCoeffs
    ) {
        Point startPoint = RandomGenerator.generatePoint(X_MIN, X_MAX, Y_MIN, Y_MAX);
        for (int step = SKIP_FIRST_TWENTY; step < iterations; ++step) {
            AffineCoeffs randomCoeffs = RandomGenerator.getAffine(affineCoeffs);
            FinalTransformation randomTransformation = RandomGenerator.getFinal(finalTransformation);
            Point point = randomTransformation.transform(randomCoeffs.calcualtePoint(startPoint));
            Point rotatePoint = new Point(point.x(), point.y());
            double angle = 0.0;
            for (int j = 0; j < sym; ++j) {
                angle += (Math.PI * 2) / sym;
                Point newPoint = rotate(rotatePoint, angle);
                if (step >= 0 && newPoint.x() <= X_MAX && newPoint.x() >= X_MIN && newPoint.y() <= Y_MAX
                    && newPoint.y() >= Y_MIN) {
                    int x1 = scale(newPoint.x(), X_MIN, X_MAX, width);
                    int y1 = scale(newPoint.y(), Y_MIN, Y_MAX, height);
                    if (x1 < width && y1 < height) {
                        synchronized (field.getPixel(x1, y1)) {
                            if (field.getPixel(x1, y1).hitCount() == 0) {
                                field.updatePoint(x1, y1, new Pixel(randomCoeffs.color(), 1));
                            } else {
                                Pixel pixel = field.getPixel(x1, y1);
                                PixelColor pixelColor = changeColor(pixel.color(), randomCoeffs.color());
                                field.updatePoint(x1, y1, new Pixel(pixelColor, pixel.hitCount() + 1));
                            }
                        }
                    }
                }
            }
            startPoint = new Point(rotatePoint.x(), rotatePoint.y());
        }
    }

    private int scale(double coordinate, double min, double max, int length) {
        return (int) (length - Math.floor(((max - coordinate) / (max - min)) * length));
    }

    private Point rotate(Point point, double angle) {
        double x = point.x() * Math.cos(angle) + point.y() * Math.sin(angle);
        double y = point.y() * Math.cos(angle) - point.x() * Math.sin(angle);
        return new Point(x, y);
    }

    private PixelColor changeColor(PixelColor color, PixelColor randomColor) {
        return new PixelColor(
            (color.r() + randomColor.r()) / 2,
            (color.g() + randomColor.g()) / 2,
            (color.b() + randomColor.b()) / 2
        );
    }
}
