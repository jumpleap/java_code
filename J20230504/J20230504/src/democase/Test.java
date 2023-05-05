package democase;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(10);
        Person person1 = (Person) person.clone();
        //Object
        System.out.println(person);
        System.out.println(person1);
    }
}

class Person implements Cloneable{
    int age;

    public Person(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                '}';
    }

    //重写clone的方法

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
