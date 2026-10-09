package problems.problem_0058_length_of_last_word;

import java.util.Map;

import framework.annotations.Test;

public class LengthOfLastWordTest {

    private static Map<String, Integer> testCases = Map.of(
        "Hello World", 5,
        "   fly me   to   the moon  ", 4,
        "luffy is still joyboy", 6
    );

    @Test
    public void testLengthOfLastWord() {
        for (var testCase: testCases.entrySet()) {

            // GIVEN
            var input = testCase.getKey();
            var expected = testCase.getValue();

            // WHEN
            var actual = new LengthOfLastWordSolution().lengthOfLastWord(input);

            // THEN
            assert actual == expected;
        }
    }
}
