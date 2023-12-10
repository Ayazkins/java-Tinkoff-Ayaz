package edu.project4.Transformations;

import edu.project4.Entities.PixelColor;
import edu.project4.Entities.Point;

public record AffineCoeffs(double a, double b, double c, double d, double e, double f, PixelColor color) {
    public Point calcualtePoint(Point point) {
        double x = point.x() * a + point.y() * b + c;
        double y = point.x() * d + point.y() * e + f;
        return new Point(x, y);
    }
}
