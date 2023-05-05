package generic;

import java.util.*;

public class GenericDemo4 {
    public static void main(String[] args) {
        HashSet<Student> students = new HashSet<>();
        students.add(new Student("jack", 12));
        students.add(new Student("maria", 13));
        students.add(new Student("jerry", 15));
        students.add(new Student("tom", 22));

        for (Student student : students) {
            System.out.println(student);
        }

        //使用HashMap进行泛型
        HashMap<String, Student> hashMap = new HashMap<>();
        hashMap.put("jack", new Student("jack", 12));
        hashMap.put("maria", new Student("maria", 13));
        hashMap.put("jerry", new Student("jerry", 15));
        hashMap.put("tom", new Student("tom", 22));

        //使用key来获取value
        Set<Map.Entry<String, Student>> entryMap = hashMap.entrySet();
        Iterator<Map.Entry<String, Student>> iterator = entryMap.iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Student> next = iterator.next();
            System.out.println(next.getKey() + "=" + next.getValue());

        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}