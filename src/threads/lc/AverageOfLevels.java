package threads.lc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by samar.kumar on 8/24/17.
 */

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class AverageOfLevels {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        System.out.println(new AverageOfLevels().averageOfLevels(root));


    }



   private Map<Integer, List<Integer>> levelSum = new HashMap<>();

    public List<Double> averageOfLevels(TreeNode root) {

        averageOfLevels(root ,0);
        List<Double> allAverage = new ArrayList<>();
        for (Integer eachKey : levelSum.keySet()) {
            long sum = 0;
            for (Integer eachNumber : levelSum.get(eachKey)) {
                sum += eachNumber;
            }
            allAverage.add((double) sum / levelSum.get(eachKey).size());

        }
        return allAverage;


    }

    private void averageOfLevels(TreeNode root, int level) {
        if (root != null) {
            if (!levelSum.containsKey(level)) {
                levelSum.put(level, new ArrayList<>());
            }
            levelSum.get(level).add(root.val);

            averageOfLevels(root.left, level + 1);
            averageOfLevels(root.right, level + 1);
        }


    }


}
