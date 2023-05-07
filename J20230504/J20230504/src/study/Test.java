package study;

import java.util.Arrays;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("jack", 12);
        people[1] = new Person("maria", 9);
        people[2] = new Person("jerry", 19);

        Arrays.sort(people);
        System.out.println(Arrays.toString(people));
    }
}

class Person implements Comparable<Person> {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
