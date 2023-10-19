package edu.hw2;

public class Task1 {

    public sealed interface Expr {
        double evaluate();

        String toString();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }

            public String toString() {
                return "value = " + evaluate();
            }
        }

        record Negate(Expr value) implements Expr {

            public Negate(double value) {
                this(new Constant(value));
            }

            @Override
            public double evaluate() {
                return -value.evaluate();
            }

            public String toString() {
                return "value = " + evaluate();
            }
        }

        record Exponent(Expr value, Expr value2) implements Expr {

            Exponent(double value, double value2) {
                this(new Constant(value), new Constant(value2));
            }

            Exponent(Expr value, double value2) {
                this(value, new Constant(value2));
            }

            Exponent(double value, Expr value2) {
                this(new Constant(value), value2);
            }

            @Override
            public double evaluate() {
                return Math.pow(value.evaluate(), value2.evaluate());
            }

            public String toString() {
                return  "value = " + value.evaluate() + '^' + value2.evaluate() + " = " + evaluate();
            }
        }

        record Addition(Expr value, Expr value2) implements Expr {

            Addition(double value, double value2) {
                this(new Constant(value), new Constant(value2));
            }

            Addition(Expr value, double value2) {
                this(value, new Constant(value2));
            }

            Addition(double value, Expr value2) {
                this(new Constant(value), value2);
            }

            @Override
            public double evaluate() {
                return value.evaluate() + value2.evaluate();
            }

            public String toString() {
                return  "value = " + value.evaluate() + '+' + value2.evaluate() + " = " + evaluate();
            }
        }

        record Multiplication(Expr value, Expr value2) implements Expr {

            Multiplication(double value, double value2) {
                this(new Constant(value), new Constant(value2));
            }

            Multiplication(Expr value, double value2) {
                this(value, new Constant(value2));
            }

            Multiplication(double value, Expr value2) {
                this(new Constant(value), value2);
            }

            @Override
            public double evaluate() {
                return value.evaluate() * value2.evaluate();
            }

            public String toString() {
                return  "value = " + value.evaluate() + '*' + value2.evaluate() + " = " + evaluate();
            }
        }
    }
}
