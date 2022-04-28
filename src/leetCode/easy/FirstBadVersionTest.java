package leetCode.easy;

import org.junit.Test;

/**
 * <a href="https://leetcode.com/problems/first-bad-version/">https://leetcode.com/problems/first-bad-version/</a>
 * <p>
 * 278. First Bad Version
 * <p>
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check. Since each version is developed
 * based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all
 * the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function
 * to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1, bad = 1
 * Output: 1
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= bad <= n <= 231 - 1
 */
public class FirstBadVersionTest {

    private static int badVersion;

    @Test
    public void test1() {
        int number = 1;
        int badVersion = 1;
        test(number, badVersion);
    }

    @Test
    public void test2() {
        int number = 2;
        int badVersion = 1;
        test(number, badVersion);
    }

    @Test
    public void test3() {
        int number = 5;
        int badVersion = 4;
        test(number, badVersion);
    }

    @Test
    public void test4() {
        int number = 8;
        int badVersion = 8;
        test(number, badVersion);
    }

    @Test
    public void test5() {
        int number = 8;
        int badVersion = 7;
        test(number, badVersion);
    }

    @Test
    public void test6() {
        int number = 8;
        int badVersion = 6;
        test(number, badVersion);
    }

    @Test
    public void test7() {
        int number = 8;
        int badVersion = 5;
        test(number, badVersion);
    }

    @Test
    public void test8() {
        int number = 8;
        int badVersion = 4;
        test(number, badVersion);
    }

    @Test
    public void test9() {
        int number = 8;
        int badVersion = 4;
        test(number, badVersion);
    }

    @Test
    public void test10() {
        int number = 8;
        int badVersion = 3;
        test(number, badVersion);
    }

    @Test
    public void test11() {
        int number = 8;
        int badVersion = 2;
        test(number, badVersion);
    }

    @Test
    public void test12() {
        int number = 8;
        int badVersion = 1;
        test(number, badVersion);
    }

    private static void test(int number, int expected) {
        badVersion = expected;
        int actualBadVersion = firstBadVersion(number);
        System.out.println("Number is " + number);
        System.out.println("Expected: " + badVersion);
        System.out.println("  Actual: " + actualBadVersion);
        assert actualBadVersion == badVersion;
    }


    public static int firstBadVersion(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int good = 1;
        int bad = n;
        while (good + 1 < bad) {
            int middle = good + (bad - good) / 2;
            if (isBadVersion(middle)) {
                bad = middle;
            } else {
                good = middle;
            }
        }
        return bad;
    }

    private static boolean isBadVersion(int n) {
        return n >= badVersion;
    }
}
