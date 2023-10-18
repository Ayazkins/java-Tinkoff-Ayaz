package edu.hw2;

import edu.hw2.Task2.Rectangle;
import edu.hw2.Task2.Square;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Task2Test {
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
