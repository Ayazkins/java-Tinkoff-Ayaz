package edu.project4.Transformations;

import edu.project4.Entities.Point;

public class SpiralTransformation implements FinalTransformation {
    @Override
    public Point transform(Point point) {
        double r = Math.sqrt(point.x() * point.x() + point.y() * point.y());
        double x = 1 / r * (Math.cos(Math.atan2(point.x(), point.y())) + Math.sin(r));
        double y = 1 / r * (Math.sin(Math.atan2(point.x(), point.y())) - Math.cos(r));
        return new Point(x, y);
    }
}
