package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {

    static Arguments[] rectangles() {
        return new Arguments[]{
            Arguments.of(new Rectangle(10, 10)),
            Arguments.of(new Square(10))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Rectangle rect) {
        rect = rect.setWidth(20);
        rect = rect.setHeight(10);

        assertThat(rect.area()).isEqualTo(200);
    }
    @Test
    @DisplayName("Rectangle area test")
    void CalculateAreaRectangleTest() {
        var rec = new Rectangle(10, 50);
        assertThat(rec.area()).isEqualTo(500);
    }

    @Test
    @DisplayName("Square area test")
    void CalculateAreaSquareTest() {
        var rec = new Square(10);
        assertThat(rec.area()).isEqualTo(100);
    }

    @Test
    @DisplayName("Try bad height or width")
    void BadValuesTest() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-10, 50));
        assertThrows(IllegalArgumentException.class, () -> new Square(-50));
    }

    @Test
    @DisplayName("Set new values")
    void SetNewValueTest() {
        var rec = new Square(10);
        var newRec = rec.setHeight(50);
        assertThat(newRec.area()).isEqualTo(500);
    }
}
