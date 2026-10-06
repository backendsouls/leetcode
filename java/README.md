# Vanilla Java 25 Unit Testing

This repository demonstrates how to build and run the unit tests framework using **only** vanilla Java 25. 

## Why do this?
For small scripts, educational purposes, or strictly zero-dependency environments, pulling in JUnit or TestNG can be overkill. This approach provides a lightweight alternative.

## Prerequisites
* Java 25 or higher installed.

---

## 1. The `@Test` Annotation
First, we need a way to mark which methods are actually tests. We define a custom runtime annotation.

```java
// Test.java
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {}
```

## 2. Writing Test Classes
To write tests, we apply our custom `@Test` annotation and use the native Java `assert` keyword. 

> **Important:** The `assert` keyword evaluates a boolean expression. If it evaluates to `false`, it throws an `AssertionError`. You can optionally append a string message after a colon (`:`).

```java
// CalculatorTest.java
public class CalculatorTest {
    
    @Test
    public void testAddition() {
        var result = 2 + 2;
        assert result == 4 : "Expected 4, got " + result;
    }

    @Test
    public void testFailingCase() {
        var result = 2 + 2;
        assert result == 5 : "This will throw an AssertionError";
    }
}
```

## 3. The Test Runner
Vanilla Java does not automatically discover tests. To run multiple test classes, we must manually register them in a runner class, instantiate them, and use reflection to find and invoke the annotated methods.

```java
// TestRunner.java
import java.lang.reflect.Method;

public class TestRunner {
    public static void main(String[] args) throws Exception {
        // 1. Manually register all your test classes here
        Class<?>[] testSuites = { 
            CalculatorTest.class 
            // Add other test classes here, e.g., UserTest.class
        };
        
        int passed = 0, failed = 0;

        for (Class<?> suite : testSuites) {
            // Instantiate the test class (assumes a no-arg constructor)
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
        
        // Exit with status code 1 if tests fail, useful for CI/CD
        System.exit(failed > 0 ? 1 : 0); 
    }
}
```

## Execution

To run these tests, you must compile the files and run the `TestRunner`. 

**CRITICAL:** You must pass the `-ea` (Enable Assertions) flag to the `java` command. If you omit this flag, the JVM completely ignores `assert` statements, and your tests will silently pass even if they are broken.

```bash
# Run the test suite with assertions enabled
java -ea TestRunner.java
```

## Limitations
While this vanilla approach works perfectly for simple scenarios, it has limitations compared to dedicated frameworks like JUnit:
* **Manual Registration:** You must manually add every new test class to the `testSuites` array in `TestRunner`.
* **No Lifecycle Hooks:** There is no native equivalent to `@BeforeEach` or `@AfterAll` without writing more reflection boilerplate.
* **No Parallel Execution:** Tests run sequentially.
* **Basic Diffing:** You only get the simple string message provided in the `assert` statement, rather than detailed object diffs.
