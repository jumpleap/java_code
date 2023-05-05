package study.demo3;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("小明", 13);
        Person person1 = new Person("小明", 13);
        System.out.println(person);
        System.out.println(person1);

        System.out.println(person.hashCode());
        System.out.println(person1.hashCode());
        System.out.println(person == person1);

        System.out.println(person.equals(person1));
    }
}
