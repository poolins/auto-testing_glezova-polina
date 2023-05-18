package homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class SqrtTest extends CalculatorTest {
    @ParameterizedTest
    @ValueSource(doubles = {0, 1, 3600, 845, 12.34, Double.MAX_VALUE, Double.MIN_VALUE})
    void testEquivalenceClasses(double num) {
        assertEquals(Math.sqrt(num), calc.sqrt(num), DELTA);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-1, -3, -2.4, -Double.MAX_VALUE})
    void testNegative(double num) {
        assertThrows(NumberFormatException.class, () -> calc.sqrt(num));
    }
}
