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
        assertEquals(6, StringCalculator.add("1\n2,3"));
    }

    @Test
    public void testStringHavingDifferentDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public void testStringWithNegativeNumber() {
        try {
            StringCalculator.add("-1,2");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative numbers are not allowed: -1");
        }
    }

    @Test
    public void testStringWithMultipleNegativeNumbers() {
        try {
            StringCalculator.add("-1,2,-3,-4");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "Negative numbers are not allowed: -1,-3,-4");
        }
    }

    @Test
    public void ignoreBiggerThanThousand() {
        assertEquals(1, StringCalculator.add("1000,1"));
    }
}
