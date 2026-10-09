package problems.problem_0009_palindrome_number;

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
        for (var testCase : testCases.entrySet()) {

            // GIVEN
            var input = testCase.getKey();
            var expected = testCase.getValue();

            // WHEN
            var actual = new PalindromeNumberSolution().isPalindrome(input);

            // THEN
            assert actual == expected;
        }
    }
}
