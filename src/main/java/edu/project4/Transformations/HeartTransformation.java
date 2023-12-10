package edu.project4.Transformations;

import edu.project4.Entities.Point;

public class HeartTransformation implements FinalTransformation {
    @Override
    public Point transform(Point point) {
        double r = point.x() * point.x() + point.y() * point.y();
        return new Point(
            Math.sqrt(r) * Math.sin(Math.sqrt(r) * Math.atan2(point.y(), point.x())),
            -Math.sqrt(r) * Math.cos(Math.sqrt(r) * Math.atan2(point.y(), point.x()))
        );
    }
}
