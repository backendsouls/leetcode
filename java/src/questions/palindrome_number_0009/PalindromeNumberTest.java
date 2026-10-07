package questions.palindrome_number_0009;

import java.util.Map;

import framework.annotations.Test;

public class PalindromeNumberTest {

    private static Map<Integer, Boolean> testCases = Map.of(
        121, true,
        -121, false,
        10, false,
        0, true,
        345543, true
    );

    @Test
    public void testIsPalindrome() {
        for (Map.Entry<Integer, Boolean> entry : testCases.entrySet()) {
            int input = entry.getKey();
            boolean expected = entry.getValue();
            boolean actual = new PalindromeNumberSolution().isPalindrome(input);
            assert actual == expected;
        }
    }
}
