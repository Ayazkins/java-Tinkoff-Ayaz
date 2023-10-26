package edu.hw2.Task2;

public class Rectangle {
    private final int height;
    private final int width;

    public Rectangle(int height, int width) {
        if (height <= 0 || width <= 0) {
            throw new IllegalArgumentException();
        }
        this.height = height;
        this.width = width;
    }

    public Rectangle setHeight(int val) {
        return new Rectangle(val, width);
    }

    public Rectangle setWidth(int val) {
        return new Rectangle(height, val);
    }

    public int area() {
        return height * width;
    }

    public String toString() {
        return "height = " + height + " width " + width;
    }
}
