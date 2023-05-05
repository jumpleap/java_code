package study.demo3;

import java.util.Objects;

public class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //重写toString方法
    public String toString() {
        return "姓名：" + name + ", 年龄：" + age;
    }


    //重写equals方法
    public boolean equals(Object obj) {
        //判断地址是否相等
        if (this == obj)
            return true;
        if (obj == null || !(obj instanceof Person))
            return false;
        Person person = (Person)obj;
        return age == person.age && name.equals(person.name);
    }

    //重写hashCode方法
    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
