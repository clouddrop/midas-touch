package lc;

/**
 * Created by samar.kumar on 9/4/17.
 */
public class MaxSubArray {

    public int maxSubArray(int[] nums) {

        int tempSum = 0;
        int finalSum = Integer.MIN_VALUE;
        for (int eachElement : nums){
            tempSum += eachElement;
            if(tempSum > finalSum){
                finalSum = tempSum;
            }
            if (tempSum <0){
                tempSum = 0;
            }
        }

        return finalSum;

    }


}
