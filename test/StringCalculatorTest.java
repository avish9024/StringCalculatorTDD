import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {
    @Test
    public void testEmptyString() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testStringHavingOneNumber() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testStringHavingTwoNumbers() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(3, calculator.add("1,2"));
    }
}
