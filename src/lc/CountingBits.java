package lc;

/**
 * Created by samar.kumar on 9/5/17.
 */
public class CountingBits {

    public static void main(String[] args) {

        int nums = 10;
        int result[] = new int[nums + 1];
        for (int i = 1; i <= nums; i++) {
            int firstPart = result[i >> 1];
            int seconPart = (i & 1);
            result[i] = firstPart + seconPart;
            System.out.println(result[i] + "first :" + firstPart + " second : " + seconPart);
        }

        System.out.println(result);
    }



}
