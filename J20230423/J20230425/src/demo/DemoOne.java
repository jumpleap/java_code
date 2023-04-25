package demo;

@SuppressWarnings({"all"})
public class DemoOne {
    public static void main(String[] args) {
        Node jack = new Node("jack");
        Node mary = new Node("mary");
        Node jerry = new Node("jerry");

        //进行连接，形成双向链表
        jack.next = mary;
        mary.next = jerry;
        jerry.pre = mary;
        mary.pre = jack;

        //使first指向第一个结点，last指向最后一个结点
        Node first = jack;
        Node last = jerry;

        //遍历
        while (true) {
            if(first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;//后继
        }

        System.out.println("--------------------------");

        //后到前进行遍历
        while (true) {
            if(last == null) {
                break;
            }
            System.out.println(last);
            last = last.pre;//前驱
        }

        //插入新元素
        Node tom = new Node("tom");
        tom.next = mary;
        mary.pre = tom;
        jack.next = tom;
        tom.pre = jack;

        first = jack;
        while (true) {
            if(first == null) {
                break;
            }
            System.out.println(first);
            first = first.next;//后继
        }

    }

}

class Node {
    public Object item;
    public Node pre;
    public Node next;

    public Node(Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item + "";
    }
}