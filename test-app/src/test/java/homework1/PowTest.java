package homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class PowTest extends CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "3,5",
            "2,2.3",
            "3.3,4",
            "4.5,9.3",
            "-3,5",
            "3,-5",
            "-2.3,5",
            "2.3,-5",
            "5,-5.3"})
    void testEquivalenceClasses(double base, double rank) {
        assertEquals(Math.pow(base, rank), calc.pow(base, rank), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Double.MAX_VALUE, Double.MIN_VALUE, -Double.MAX_VALUE})
    void testBoundaries(double num) {
        assertEquals(Math.pow(num, num), calc.pow(num, num), DELTA);
    }

    @Test
    void testInvalidVal() {
        double base = -5;
        double rank = 5.3;
        assertThrows(NumberFormatException.class, () -> calc.pow(base, rank));
    }
}
