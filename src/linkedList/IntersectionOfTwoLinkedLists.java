package linkedList;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        ListNode intersection = new ListNode(8);
        headA.next.next = intersection;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        ListNode result = getIntersectionNode(headA, headB);
        if (result != null) {
            System.out.println("Intersection at node with value: " + result.val);
        } else {
            System.out.println("No intersection.");
        }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode fp =  headA;
        ListNode sp =  headB;
        int m = getLength(headA);
        int n = getLength(headB);
        if(m < n){
            for(int i=0; i< n-m ; i++){
                sp = sp.next;
            }
        }else if(m > n){
            for(int i=0; i< m-n ; i++){
                fp = fp.next;
            }
        }
        return getIntersection(fp,sp);
    }


    private static int getLength(ListNode node){
        int len = 0;
        while(node !=null){
            len++;
            node = node.next;
        }
        return len;
    }

    private static ListNode getIntersection(ListNode fp, ListNode sp){
        while(fp != null && sp != null){
            if(fp == sp){
                return fp;
            }else{
                fp= fp.next;
                sp= sp.next;
            }
        }
        return null;
    }
}
