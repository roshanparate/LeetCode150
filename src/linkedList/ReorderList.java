package linkedList;

public class ReorderList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        reorderList(head);

        // Print the modified linked list
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }


    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split the list into two halves
        ListNode secondHalf = slow.next;
        slow.next = null;

        // Step 2: Reverse the second half
        secondHalf = reverseList(secondHalf);

        // Step 3: Merge the first half with the reversed second half
        ListNode current = head;
        while(secondHalf != null){
            ListNode nextFirst = current.next;
            ListNode nextSecond = secondHalf.next;

            current.next = secondHalf;
            secondHalf.next = nextFirst;

            current = nextFirst;
            secondHalf = nextSecond;
        }
    }


    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
}
