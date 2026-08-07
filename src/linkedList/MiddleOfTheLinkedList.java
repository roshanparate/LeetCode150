package linkedList;

public class MiddleOfTheLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        MiddleOfTheLinkedList solution = new MiddleOfTheLinkedList();
        ListNode middleNode = solution.middleNode(head);

        System.out.println("Middle node value: " + middleNode.val);
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
