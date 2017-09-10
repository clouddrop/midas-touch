package threads.lc;

import java.util.Arrays;

/**
 * Created by samar.kumar on 8/30/17.
 */
public class SetMisMatch {

    public static void main(String[] args) {

        int[] nums  = {1,2,2,4};

        Arrays.stream(findErrorNums(nums)).forEach(x -> System.out.print(x + " : "));

    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) {
                res[0] = Math.abs(i);
            } else {
                nums[Math.abs(i) - 1] *= -1;
            }
        }

        System.out.println();
        Arrays.stream(nums).forEach(x -> System.out.print(x + " : "));
        System.out.println();

        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i+1;
        }
        return res;
    }

}
