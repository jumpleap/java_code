import static com.sun.glass.ui.Window.addFirst;

public class MySingleList {
    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int data) {
            this.value = data;
        }
    }

    public ListNode head;

    //得到单链表的长度
    public int size() throws NullPointerException {
        if (head == null) {
            throw new NullPointerException("空指针异常~");
        }
        int count = 0;
        ListNode cur = head;

        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    public boolean contains(int key) throws NullPointerException {
        ListNode cur = head;
        if (cur == null) {
            throw new NullPointerException("空指针异常~");
        }

        while (cur != null) {
            if (cur.value == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("index 不合法");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }

        ListNode node = new ListNode(data);
        ListNode cur = head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }

        node.next = cur.next;
        cur.next = node;
    }

    public void delIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("index 不合法");
            return;
        }

        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        cur.next = null;
    }


    private void addFirst(int data) {
    }

    private void addLast(int data) {

    }
}
