package linkedList;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;
        ListNode result = removeNthFromEnd(head, n);

        // Print the modified linked list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fp = head, sp = head;
        for(int i = 0 ; i < n ; i++){
            fp = fp.next;
        }
        if(fp == null){
            return head.next;
        }
        while(fp.next != null){
            fp = fp.next;
            sp = sp.next;
        }

        sp.next = sp.next.next;
        return head;
    }
}
