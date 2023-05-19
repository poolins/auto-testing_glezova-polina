package homework1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IsNegativeTest extends CalculatorTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, -1000, Integer.MIN_VALUE})
    void testNegatives(int num) {
        assertTrue(calc.isNegative(num));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 1000, Integer.MAX_VALUE})
    void testPositives(int num) {
        assertFalse(calc.isNegative(num));
    }
}
