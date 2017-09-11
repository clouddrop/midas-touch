package lc;

/**
 * Created by samar.kumar on 8/29/17.
 */



public class RemoveElements {


    public static void main(String[] args) {
      ListNode head =   new ListNode(1);
      head.next = new ListNode(2);
      head.next.next = new ListNode(2);
      head.next.next.next = new ListNode(1);
      new RemoveElements().removeElements(head , 2);
    }




    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return head;
            }
        }

        if (head.next == null) {
            return head;
        }

        ListNode returnhead = head;

        while (head != null && head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return returnhead;

    }


}
