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
            var expected = testCase.expected();
            var result = new TwoSumSolution().twoSum(testCase.input(), testCase.target());

            assert expected[0] == result[0] && expected[1] == result[1];
        }
    }
}
