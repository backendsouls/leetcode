package framework.samples;

import framework.annotations.Test;

public class CalculatorTest2 {

    @Test
    public void testAddition2() {
        var result = 2 + 2;
        assert result == 4 : "Expected 4, got " + result;
    }

    @Test
    public void testFailingCase2() {
        var result = 2 + 2;
        assert result == 5 : "This will throw an AssertionError";
    }
}
