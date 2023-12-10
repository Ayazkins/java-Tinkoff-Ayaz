package edu.project4.Transformations;

import edu.project4.Entities.Point;

public class SphericalTransformation implements FinalTransformation {
    @Override
    public Point transform(Point point) {
        double r = point.x() * point.x() + point.y() * point.y();
        return new Point(point.x() / r, point.y() / r);

    }
}
