package edu.hw2;

public class Task1 {

    public sealed interface Expr {
        double evaluate();

        public record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        public record Negate(Expr value) implements Expr {

            @Override
            public double evaluate() {
                return -value.evaluate();
            }
        }

        public record Exponent(Expr value, Expr value2) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(value.evaluate(), value2.evaluate());
            }
        }

        public record Addition(Expr value, Expr value2) implements Expr {

            @Override
            public double evaluate() {
                return value.evaluate() + value2.evaluate();
            }
        }

        public record Multiplication(Expr value, Expr value2) implements Expr {
            @Override
            public double evaluate() {
                return value.evaluate() * value2.evaluate();
            }
        }
    }
}
