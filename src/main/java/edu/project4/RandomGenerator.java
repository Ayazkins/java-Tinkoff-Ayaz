package edu.project4;

import edu.project4.Entities.PixelColor;
import edu.project4.Entities.Point;
import edu.project4.Transformations.AffineCoeffs;
import edu.project4.Transformations.FinalTransformation;
import java.util.Random;

public final class RandomGenerator {

    private RandomGenerator() {

    }

    private static final Random RANDOM = new Random();

    public static AffineCoeffs generateAffineTransformation() {
        double a;
        double b;
        double c;
        double d;
        double e;
        double f;
        double check1;
        double check2;
        double check3;
        double check4;
        do {
            a = RANDOM.nextDouble(-1, 1);
            b = RANDOM.nextDouble(-1, 1);
            c = RANDOM.nextDouble(-1, 1);
            d = RANDOM.nextDouble(-1, 1);
            e = RANDOM.nextDouble(-1, 1);
            f = RANDOM.nextDouble(-1, 1);
            check1 = a * a + d * d;
            check2 = b * b + e * e;
            check3 = check1 + check2;
            check4 = 1 + (a * e - b * d) * (a * e - b * d);
        } while (
            check1 >= 1 || check2 >= 1 || check3 >= check4
        );
        return new AffineCoeffs(a, b, c, d, e, f,
            new PixelColor(
                RANDOM.nextDouble(),
                RANDOM.nextDouble(),
                RANDOM.nextDouble()
            )
        );
    }

    public static Point generatePoint(double xMin, double xMax, double yMin, double yMax) {
        return new Point(
            RANDOM.nextDouble(xMin, xMax),
            RANDOM.nextDouble(yMin, yMax)
        );
    }

    public static AffineCoeffs getAffine(AffineCoeffs[] affineCoeffs) {
        return affineCoeffs[RANDOM.nextInt(0, affineCoeffs.length)];
    }

    public static FinalTransformation getFinal(FinalTransformation[] finalTransformations) {
        return finalTransformations[RANDOM.nextInt(0, finalTransformations.length)];
    }
}
