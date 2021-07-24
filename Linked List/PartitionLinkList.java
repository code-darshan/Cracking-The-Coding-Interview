public class PartitionLinkList {

    public static void main(String args[]) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next = new ListNode(2);

        head = partitionUsingFourPointers(head, 4);
        printLinkList(head);

        head = partitionUsingTwoPointers(head, 4);
        printLinkList(head);
    }

    public static ListNode partitionUsingFourPointers(ListNode head, int x) {

        ListNode firstStart = null;
        ListNode firstEnd = null;
        ListNode secondStart = null;
        ListNode secondEnd = null;

        ListNode ptr = head;

        while (ptr != null) {
            if (ptr.val < x) {
                if (firstStart == null) {
                    firstStart = ptr;
                    firstEnd = ptr;
                } else {
                    firstEnd.next = ptr;
                    firstEnd = ptr;
                }
                ptr = ptr.next;
                firstEnd.next = null;
            } else {
                if (secondStart == null) {
                    secondStart = ptr;
                    secondEnd = ptr;
                } else {
                    secondEnd.next = ptr;
                    secondEnd = ptr;
                }
                ptr = ptr.next;
                secondEnd.next = null;
            }
        }
        if (firstStart == null) {
            return secondStart;
        }
        firstEnd.next = secondStart;
        return firstStart;

    }

    public static ListNode partitionUsingTwoPointers(ListNode head, int x) {
        ListNode start = head;
        ListNode end = head;

        ListNode ptr = head.next;
        start.next = null;

        while (ptr != null) {
            ListNode next = ptr.next;
            if (ptr.val < x) {
                ptr.next = start;
                start = ptr;
            } else {
                end.next = ptr;
                end = ptr;
                ptr.next = null;
            }
            ptr = next;
        }

        return start;

    }

    public static void printLinkList(ListNode head) {
        ListNode ptr = head;
        while (ptr != null) {
            System.out.print(ptr.val + " ");
            ptr = ptr.next;
        }
        System.out.println();
    }
}


class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}
