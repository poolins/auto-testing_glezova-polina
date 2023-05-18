package homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MultDoubleTest extends CalculatorTest {
    @ParameterizedTest
    @CsvSource({
            "3,0",
            "2,5",
            "5, 13.3",
            "-5,6",
            "-12,-34",
            "-56.78, 4",
            "-3.4, -56.7"})
    void testEquivalenceClasses(double num1, double num2) {
        assertEquals(num1 * num2, calc.mult(num1, num2), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0, Double.MAX_VALUE, Double.MIN_VALUE})
    void testBoundaries(double num) {
        assertEquals(num * num, calc.mult(num, num), DELTA);
    }
}
