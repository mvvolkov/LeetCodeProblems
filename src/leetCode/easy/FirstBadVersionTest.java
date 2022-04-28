package leetCode.easy;

import org.junit.Test;

public class FirstBadVersionTest {

    private int badVersion;

    @Test
    public void test1(){
        int number = 1;
        int badVersion = 1;
        test(number, badVersion);
    }

    @Test
    public void test2(){
        int number = 2;
        int badVersion = 1;
        test(number, badVersion);
    }

    @Test
    public void test3(){
        int number = 5;
        int badVersion = 4;
        test(number, badVersion);
    }

    private void test(int number, int badVersion){
        this.badVersion = badVersion;
        int actualBadVersion = firstBadVersion(number);
        System.out.println("Number is " + number);
        System.out.println("Expected: " + badVersion);
        System.out.println("  Actual: " + actualBadVersion);
        assert actualBadVersion == badVersion;
    }


    public int firstBadVersion(int n) {
        return checkBadVersion(1, n);
    }

    private boolean isBadVersion(int n){
        return n >= badVersion;
    }

    private int checkBadVersion(int startVersion, int endVersion){

        //assume that endVersion is bad

        if(startVersion==endVersion){
            return endVersion;
        }
        if(startVersion + 1 == endVersion){
            return isBadVersion(startVersion) ? startVersion : endVersion;
        }

        int middleVersion = startVersion + (endVersion - startVersion)/2;


        if(isBadVersion(middleVersion)){
            return checkBadVersion(startVersion, middleVersion);
        }else{
            return checkBadVersion(middleVersion, endVersion);
        }
    }
}
