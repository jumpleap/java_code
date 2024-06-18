package ee.basic.simply;


// toString方法
public class Demo1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.id = 1;
        person.name = "jack";
        System.out.println(person.toString());
    }
}

class Person {
    int id;
    String name;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}