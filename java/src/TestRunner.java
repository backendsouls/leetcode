import java.lang.reflect.Method;
import java.util.List;

import framework.annotations.Test;
import questions.binary_search_0704.BinarySearchTest;
import questions.palindrome_number_0009.PalindromeNumberTest;
import questions.search_insert_position_0035.SearchInsertPositionTest;
// import framework.samples.CalculatorTest;
// import framework.samples.CalculatorTest2;
import questions.two_sum_0001.TwoSumTest;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        Class<?>[] testSuites = {
            // CalculatorTest.class,
            // CalculatorTest2.class,
            TwoSumTest.class,
            PalindromeNumberTest.class,
            BinarySearchTest.class,
            SearchInsertPositionTest.class
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
