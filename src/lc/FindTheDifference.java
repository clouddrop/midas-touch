package lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samar.kumar on 8/24/17.
 */
public class FindTheDifference {

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j < 1; j--) {
                if (nums[j - 1] == 0) {
                    int temp = nums[j];
                    nums[j] = 0;
                    nums[j - 1] = temp;
                }
            }
        }
    }


    public char findTheDifference(String s, String t) {
        Map<Character, Boolean>  cache = new HashMap<>();

        for (char eachStringChar: s.toCharArray()){
            cache.put(eachStringChar, true);
        }

        for (char eachChar : t.toCharArray()){
            if (!cache.containsKey(eachChar)){
                return eachChar;
            }
        }
        return 'a';
    }



}
