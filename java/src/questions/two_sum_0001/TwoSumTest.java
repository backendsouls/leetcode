package questions.two_sum_0001;

import java.util.List;

import framework.annotations.Test;

public class TwoSumTest {

    private record Triple(int target, int[] input, int[] expected) {
        public static Triple of(int target, int[] input, int[] expected) {
            return new Triple(target, input, expected);
        }
    }

    private static List<Triple> testCases = List.of(
        Triple.of(9, new int[] { 2, 7, 11, 15 }, new int[] { 0, 1 }),
        Triple.of(6, new int[] { 3, 2, 4 }, new int[] { 1, 2 }),
        Triple.of(6, new int[] { 3, 3 }, new int[] { 0, 1 }),
        Triple.of(70, new int[]{ 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 }, new int[] { 2, 3 })
    );

    @Test
    public void testTwoSum() {
        for (var testCase: testCases) {

            // GIVEN
            var input = testCase.input();
            var target = testCase.target();
            var expected = testCase.expected();

            // WHEN
            var actual = new TwoSumSolution().twoSum(input, target);

            // THEN
            assert actual[0] == expected[0];
            assert actual[1] == expected[1];
        }
    }
}
