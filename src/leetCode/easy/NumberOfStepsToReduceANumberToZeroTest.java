package leetCode.easy;

import org.junit.Assert;
import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/">https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/</a>
 * <p>
 * 1342. Number of Steps to Reduce a Number to Zero
 * <p>
 * Given an integer num, return the number of steps to reduce it to zero.
 * <p>
 * In one step, if the current number is even, you have to divide it by 2,
 * otherwise, you have to subtract 1 from it.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: num = 14
 * Output: 6
 * Explanation:
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 * <p>
 * Example 2:
 * <p>
 * Input: num = 8
 * Output: 4
 * Explanation:
 * Step 1) 8 is even; divide by 2 and obtain 4.
 * Step 2) 4 is even; divide by 2 and obtain 2.
 * Step 3) 2 is even; divide by 2 and obtain 1.
 * Step 4) 1 is odd; subtract 1 and obtain 0.
 * <p>
 * Example 3:
 * <p>
 * Input: num = 123
 * Output: 12
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 106
 */
public class NumberOfStepsToReduceANumberToZeroTest {

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
        Assert.assertEquals(expectedSteps, actualSteps);
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
