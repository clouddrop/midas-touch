package threads.lc;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by samar.kumar on 9/4/17.
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    /** initialize your data structure here. */
    private List<Integer> stack ;

    private Integer min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new LinkedList<>();
    }

    public void push(int x) {

        stack.add(0 , x);
        if (x < min){
            min = x;
        }


    }

    public void pop() {

        if (stack.size()!= 0){
            Integer removedElement = stack.remove(0);
            if(stack.isEmpty()){
                min = Integer.MAX_VALUE;
            }else {
                if (min == removedElement) {
                    min = Integer.MAX_VALUE;
                    for (Integer eachElement : stack) {
                        if (eachElement < min) {
                            min = eachElement;
                        }
                    }
                }
            }
        }
    }

    public int top() {

        return stack.get(0);
    }

    public int getMin() {

        return min;
    }

    public boolean isValidBST(TreeNode root) {
        if(root ==null){
            return true;
        }
        return false;

    }


}
