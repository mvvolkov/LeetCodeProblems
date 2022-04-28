package leetCode.easy;

import org.junit.Test;

public class ReduceNumberToZeroTest {

    @Test
    public void test1() {
        int number = 14;
        int steps = 6;
        test(number, steps);
    }

    private static void test(int number, int expectedSteps) {
        int actualSteps = numberOfSteps(number);
        System.out.println("number is " + number);
        System.out.println("expected: " + expectedSteps);
        System.out.println("  actual: " + actualSteps);
        assert actualSteps == expectedSteps;


    }

    private static int numberOfSteps(int num) {
        int steps = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num--;
            }
            steps++;
        }
        return steps;
    }
}
