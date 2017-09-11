package lc;

/**
 * Created by samar.kumar on 9/6/17.
 */
public class GetIntersectionNode {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int firstNodeLen = getLenght(headA);
        int secondNodeLen = getLenght(headB);
        int diff = 0;
        if (firstNodeLen > secondNodeLen) {

            diff = firstNodeLen - secondNodeLen;
            while (diff != 0) {
                headA = headA.next;
                diff--;
            }
        } else {
            diff = secondNodeLen - firstNodeLen;
            while (diff != 0) {
                headB = headB.next;
                diff--;
            }


        }

        while (headA != null && headB !=null){
            if (headA.val == headB.val){
                return headA;
            }else {
                headA = headA.next;
                headB = headB.next;

            }
        }


        return null ;


    }

    private int getLenght(ListNode headNode) {
        int length = 0;
        while (headNode != null) {
            length++;
            headNode = headNode.next;
        }
        return length;

    }

}
