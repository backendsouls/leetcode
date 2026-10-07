package questions.binary_search_0704;

import java.util.List;

import framework.annotations.Test;

public class BinarySearchTest {

    private record Triple(int[] input, int target, int expected) {
        public static Triple of(int[] input, int target, int expected) {
            return new Triple(input, target, expected);
        }
    }

    private static List<Triple> testCases = List.of(
        Triple.of(new int[] { -1, 0, 3, 5, 9, 12 }, 9, 4),
        Triple.of(new int[] { -1, 0, 3, 5, 9, 12 }, 2, -1),
        Triple.of(new int[] { -1, 0, 3, 5, 9, 12 }, 13, -1)
    );

    @Test
    public void testBinarySearch() {
        for (Triple testCase : testCases) {
            int result = new BinarySearchSolution().search(testCase.input, testCase.target);
            assert result == testCase.expected;
        }
    }
}
