package lc;

import java.util.Arrays;

/**
 * Created by samar.kumar on 9/11/17.
 */
public class LengthOfLIS {

    public static void main(String[] args) {

        int[] array = {10,9,2,5,3,7,101,18};
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        System.out.println(lengthOfLIS.lengthOfLIS(array));
    }


    String print(int[] aray){
        StringBuffer resultString = new StringBuffer("[");
        Arrays.stream(aray).forEach(x -> resultString.append(" , " + x));
        resultString.append("]");
        return resultString.toString();
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            System.out.println(" pre x : " + x  + "  i : " +i + "  result:" +print(dp) + " len : " + len);

            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;

            System.out.println("post x : " + x  + "  i : " +i + "  result:" +print(dp) + " len : " + len);
            System.out.println("_------------------------");

        }

        return len;
    }

}
