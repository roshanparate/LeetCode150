package linkedList;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        MergeTwoSortedLists merger = new MergeTwoSortedLists();
        ListNode mergedHead = merger.mergeTwoLists(l1, l2);

        while (mergedHead != null) {
            System.out.print(mergedHead.val + "->");
            mergedHead = mergedHead.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode current =  new ListNode(0);
        ListNode result =  current;

        while(list1 != null && list2 != null){
            if(list1.val  <= list2.val){
                result.next = list1;
                list1 =  list1.next;
            }else {
                result.next = list2;
                list2 =  list2.next;
            }

            result =  result.next;
        }

        while(list1 != null){
            result.next = list1;
            list1 =  list1.next;
        }

        while(list2 != null){
            result.next = list2;
            list2 =  list2.next;
        }

        return current.next;

    }
}
