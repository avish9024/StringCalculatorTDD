import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringCalculatorTest {

    @Test
    public void testEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void testStringHavingOneNumber() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void testStringHavingTwoNumbers() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    public void testStringHavingNewLines() {
        StringCalculator calculator = new StringCalculator();
        assertEquals(6, calculator.add("1\n2,3"));
    }
}
