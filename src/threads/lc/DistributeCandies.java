package threads.lc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by samar.kumar on 8/19/17.
 */
public class DistributeCandies {

    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();

        Arrays.stream(candies).forEach(x -> set.add(x));
        return Math.min(candies.length/2, set.size());


    }
}
