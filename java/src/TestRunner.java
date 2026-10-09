import java.lang.reflect.Method;
import java.util.List;

import framework.annotations.Test;
import problems.problem_0001_two_sum.TwoSumTest;
import problems.problem_0009_palindrome_number.PalindromeNumberTest;
import problems.problem_0035_search_insert_position.SearchInsertPositionTest;
import problems.problem_0058_length_of_last_word.LengthOfLastWordTest;
import problems.problem_0704_binary_search.BinarySearchTest;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        Class<?>[] testSuites = {
            TwoSumTest.class,
            PalindromeNumberTest.class,
            BinarySearchTest.class,
            SearchInsertPositionTest.class,
            LengthOfLastWordTest.class
        };

        List<String> targetClasses = List.of(args);

        int passed = 0, failed = 0;

        for (Class<?> suite : testSuites) {
            // Skip the loop iteration if args were provided but don't match this class
            if (!targetClasses.isEmpty() && !targetClasses.contains(suite.getSimpleName())) {
                continue;
            }

            Object instance = suite.getDeclaredConstructor().newInstance();

            for (Method method : suite.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    try {
                        method.invoke(instance);
                        System.out.println("✅ PASS: " + suite.getSimpleName() + "::" + method.getName());
                        passed++;
                    } catch (Throwable ex) {
                        System.out.println("❌ FAIL: " + suite.getSimpleName() + "::" + method.getName() + " -> " + ex.getCause().getMessage());
                        failed++;
                    }
                }
            }
        }

        System.out.printf("Results: %d passed, %d failed%n", passed, failed);
        System.exit(failed > 0 ? 1 : 0);
    }
}
