package edu.hw2;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task1Test {
    @Test
    @DisplayName("Constants test")
    void ConstantTest() {
        var two = new Task1.Expr.Constant(2);
        var negFive = new Task1.Expr.Constant(-5);
        assertThat(two.evaluate()).isEqualTo(2);
        assertThat(negFive.evaluate()).isEqualTo(-5);
    }

    @Test
    @DisplayName("Negate test")
    void NegateTest() {
        var two = new Task1.Expr.Constant(2);
        var negTwo = new Task1.Expr.Negate(two);
        var negFive = new Task1.Expr.Constant(-5);
        var five = new Task1.Expr.Negate(negFive);
        assertThat(negTwo.evaluate()).isEqualTo(-2);
        assertThat(five.evaluate()).isEqualTo(5);
    }

    @Test
    @DisplayName("Exponent test")
    void ExponentTest() {
        var two = new Task1.Expr.Constant(2);
        var two_ = new Task1.Expr.Constant(2);
        var exp = new Task1.Expr.Exponent(two_, two);
        assertThat(exp.evaluate()).isEqualTo(4);
    }

    @Test
    @DisplayName("Addition test")
    void AdditionTest() {
        var negTwo = new Task1.Expr.Constant(-2);
        var eight = new Task1.Expr.Constant(8);
        var sum = new Task1.Expr.Addition(eight, negTwo);
        assertThat(sum.evaluate()).isEqualTo(6);
    }

    @Test
    @DisplayName("Multiplication test")
    void MultiplicationTest() {
        var negTwo = new Task1.Expr.Constant(-2);
        var eight = new Task1.Expr.Constant(8);
        var mult = new Task1.Expr.Multiplication(eight, negTwo);
        assertThat(mult.evaluate()).isEqualTo(-16);
    }
}
