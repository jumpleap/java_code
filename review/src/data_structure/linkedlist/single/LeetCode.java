package data_structure.linkedlist.single;

/**
 * @Author 林沐雨
 * @Date 2025/4/28
 * @Description 单链表面试题
 */
public class LeetCode {
    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode () {

        }

        public ListNode(int val) {
            this.val = val;
        }
    }

    // https://leetcode.cn/problems/remove-linked-list-elements/description/
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        ListNode cur = head.next;
        ListNode prev = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                cur = cur.next;
            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }

        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    // https://leetcode.cn/problems/reverse-linked-list/description/
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head.next;
        // 防止形成环
        head.next = null;

        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = head;
            head = cur;
            cur = curNext;
        }
        return head;
    }

    // https://leetcode.cn/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    // https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/description/
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }

    // https://leetcode.cn/problems/merge-two-sorted-lists/description/
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (list1 != null || list2 != null) {
            if (list1 == null) {
                dummy.next = list2;
                break;
            } else if (list2 == null) {
                dummy.next = list1;
                break;
            } else if (list1.val < list2.val) {
                dummy.next = list1;
                dummy = dummy.next;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                dummy = dummy.next;
                list2 = list2.next;
            }
        }
        return head.next;
    }

    // https://leetcode.cn/problems/partition-list-lcci/description/
    public ListNode partition(ListNode head, int x) {
        ListNode prev = new ListNode();
        ListNode newHead = prev;
        ListNode last = new ListNode();
        ListNode lastHead = last;

        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                prev.next = cur;
                prev = prev.next;
            } else {
                last.next = cur;
                last = last.next;
            }
            cur = cur.next;
        }
        prev.next = null;
        last.next = null;
        prev.next = lastHead.next;

        return newHead.next;
    }

    // https://leetcode.cn/problems/aMhZSa/description/
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }

        fast = head;

        while (fast != slow) {
            if (fast.val != slow.val) {
                return false;
            }

            if (fast.next == slow) {
                return true;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    // https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode wide = headA;
        ListNode narrow = headB;
        int size1 = getSize(wide);
        int size2 = getSize(narrow);
        int size = size1 - size2;

        if (size < 0) {
            wide = headB;
            narrow = headA;
            size = -size;
        }

        for (int i = 0; i < size; i++) {
            wide = wide.next;
        }

        while (wide != narrow) {
            wide = wide.next;
            narrow = narrow.next;
        }
        return wide;
    }

    private int getSize(ListNode head) {
        ListNode cur = head;
        int count = 0;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    // https://leetcode.cn/problems/linked-list-cycle/description/
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) return true;
        }
        return false;
    }

    // https://leetcode.cn/problems/linked-list-cycle-ii/description/
    public ListNode detectCycle(ListNode head) {
        if (head == null) return head;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) break;
        }

        if (fast == null || fast.next == null) return null;

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;

        ListNode cur = head;
        ListNode dummy = new ListNode();
        ListNode newHead = dummy;

        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                dummy.next = cur;
                dummy = dummy.next;
                cur = cur.next;
            }
        }
        dummy.next = null;
        return newHead.next;
    }
}
