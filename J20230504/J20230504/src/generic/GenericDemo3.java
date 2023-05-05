package generic;

public class GenericDemo3 {
    public static void main(String[] args) {
        Person<String> stringPerson = new Person<>("fly");
        stringPerson.show();
    }
}


//E的具体数据类型在编译阶段就已经确定了，如果不匹配，那么会发生报错
class Person<E> {
    E s;

    public Person(E s) {
        this.s = s;
    }

    public E getS() {
        return s;
    }

    public void show() {
        System.out.println(s.getClass().getSimpleName());//查看s的运行类型
    }
}
