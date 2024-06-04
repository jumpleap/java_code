package ds.compare;

import java.util.Comparator;

// 测试Comparator直接在一个类上使用
public class Demo {
    public static void main(String[] args) {
        Person p1 = new Person(1, "湛山");
        Person p2 = new Person(1, "湛山");

        // 到此，若是使用类直接基础在使用这个类， 无法完成两个实例的比较
    }
}

class Person implements Comparator<Person> {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public int compare(Person o1, Person o2) {
        if (o1 == o2) return 0;

        if (o1 == null) return o2.id;
        if (o2 == null) return o1.id;

        return o1.id - o2.id;
    }
}