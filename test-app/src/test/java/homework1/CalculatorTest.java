package homework1;

import com.epam.tat.module4.Calculator;
import org.junit.jupiter.api.BeforeAll;

class CalculatorTest {
    protected static Calculator calc;
    protected static final double DELTA = 1e-15;

    @BeforeAll
    static void init() {
        calc = new Calculator();
    }
}
