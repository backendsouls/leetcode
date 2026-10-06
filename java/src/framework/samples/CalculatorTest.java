package framework.samples;

import framework.annotations.Test;

public class CalculatorTest {

    @Test
    public void testAddition() {
        var result = 2 + 2;
        assert result == 4 : "Expected 4, got " + result;
    }

    @Test
    public void testFailingCase() {
        var result = 2 + 2;
        assert result == 5 : "This will throw an AssertionError";
    }
}
