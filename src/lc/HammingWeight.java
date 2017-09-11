package lc;

/**
 * Created by samar.kumar on 9/5/17.
 */
public class HammingWeight {

    public static void main(String[] args) {

        System.out.println(new HammingWeight().hammingWeight(  5 ));
    }

    public int hammingWeight(int n) {

        if (n == 0) {
            return 0;
        }
        return n & 2 + hammingWeight(n >> 1);
    }

    public int _hammingWeight(int n) {

        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;

    }


}
