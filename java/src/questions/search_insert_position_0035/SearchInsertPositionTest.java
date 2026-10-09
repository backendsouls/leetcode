package questions.search_insert_position_0035;

import java.util.List;

import framework.annotations.Test;

public class SearchInsertPositionTest {

    private record Triple(int[] input, int target, int expected) {
        public static Triple of(int[] input, int target, int expected) {
            return new Triple(input, target, expected);
        }
    }

    private static List<Triple> testCases = List.of(
        Triple.of(new int[] { -1, 0, 3, 5, 9, 12 }, 9, 4),
        Triple.of(new int[] { -1, 0, 3, 5, 9, 12 }, 2, 2),
        Triple.of(new int[] { -1, 0, 3, 5, 9, 12 }, 13, 6),
        Triple.of(new int[] { 1, 3, 5, 6 }, 5, 2),
        Triple.of(new int[] { 1, 3, 5, 6 }, 2, 1),
        Triple.of(new int[] { 1, 3, 5, 6 }, 7, 4)
    );

    @Test
    public void testSearchInsert() {
        for (Triple testCase : testCases) {

            // GIVEN
            var input = testCase.input();
            var target = testCase.target();
            var expected = testCase.expected();

            // WHEN
            var actual = new SearchInsertPositionSolution().searchInsert(input, target);

            // THEN
            assert actual == expected;
        }
    }
}
