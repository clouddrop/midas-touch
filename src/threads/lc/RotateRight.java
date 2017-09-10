package threads.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by samar.kumar on 9/4/17.
 */


class ListNode {
    int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String returnString = "";
        while (next != null) {
            returnString += " (" + next.val + ")";
        }

        return returnString;
    }
}


public class RotateRight {


    public static void main(String[] args) {
        //1->2->3->4->5->NULL

        RotateRight rotateRight = new RotateRight();
        ListNode head = new ListNode(5);
        ListNode newNode = new ListNode(4);
        newNode.next = head;
        head = newNode;

        //System.out.println(head.toString());

        newNode = new ListNode(3);
        newNode.next = head;
        head = newNode;

        newNode = new ListNode(2);
        newNode.next = head;
        head = newNode;

        newNode = new ListNode(1);
        newNode.next = head;
        head = newNode;


        System.out.println(rotateRight.rotateRight(head, 2).toString());


    }

    public ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode secondNode = head;
        ListNode resutNode = null;
        while (count != k) {
            k++;
            secondNode = secondNode.next;
        }

        ListNode firstNode = head;
        while (secondNode != null) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;

        }


        firstNode.next = null;
        return head;

    }


    Map<Integer, Integer> cache = new HashMap<>();

    public int climbStairs(int n) {
        return _climbStairs(n, n);
    }


    public int _climbStairs(int n, int total) {

        if (cache.containsKey(total)) {
            return cache.get(total);
        }
        if (n == 0) {
            return 1;
        } else if (n == -1) {
            return 0;
        } else {
            int value =  climbStairs(n - 1) + climbStairs(n - 2);
            cache.put(total, value);
            return value;
        }
    }


    static int maxSubArraySum(int a[])
    {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }


}
