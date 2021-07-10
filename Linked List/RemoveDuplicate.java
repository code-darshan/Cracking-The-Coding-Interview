import java.util.HashSet;
import java.util.List;

public class RemoveDuplicate {

    public static void main(String[] args) {

        ListNode head = new ListNode(4);
        head.next = new ListNode(4);
        head.next.next = new ListNode(11);
        head.next.next.next = new ListNode(11);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(11);
        head.next.next.next.next.next.next = new ListNode(4);

        printList(head);
        head = mergeSort(head);
        printList(head);
        head = removeDuplicatesUsingSorting(head);
        printList(head);
    }

    public static void removeDuplicatesUsingBruteForce(ListNode head) {
        ListNode outerPtr = head;

        while (outerPtr != null) {
            ListNode innerPtr = outerPtr.next;
            ListNode previous = outerPtr;
            while (innerPtr != null) {
                if (innerPtr.val == outerPtr.val) {
                    previous.next = innerPtr.next;
                } else {
                    previous = innerPtr;
                }
                innerPtr = innerPtr.next;
            }
            outerPtr = outerPtr.next;

        }
    }

    public static void removeDuplicatesUsingHashSet(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode ptr = head;
        ListNode previous = head;

        HashSet<Integer> set = new HashSet<>();

        while (ptr != null) {
            if (set.contains(ptr.val)) {
                previous.next = ptr.next;
            } else {
                set.add(ptr.val);
                previous = ptr;
            }
            ptr = ptr.next;
        }
    }

    public static ListNode removeDuplicatesUsingSorting(ListNode head) {

        ListNode ptr = head;
        while (ptr != null && ptr.next != null) {
            if (ptr.val == ptr.next.val) {
                ptr.next = ptr.next.next;
            } else {
                ptr = ptr.next;
            }
        }
        return head;
    }

    public static ListNode merge(ListNode first, ListNode second) {

        if (first == null) {
            return second;
        } else if (second == null) {
            return first;
        } else if (first.val < second.val) {
            first.next = merge(first.next, second);
            return first;
        } else {
            second.next = merge(first, second.next);
            return second;
        }
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode middle = getMiddlePtr(head);
        ListNode second = middle.next;
        middle.next = null;
        head = mergeSort(head);
        second = mergeSort(second);
        return merge(head, second);
    }

    public static ListNode getMiddlePtr(ListNode head) {

        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
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
