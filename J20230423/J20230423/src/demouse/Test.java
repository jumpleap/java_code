package demouse;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stu stu = new Stu("jack", 10);
        System.out.println(stu);

        System.out.println(add(1, 3));
    }

    public static int add(int a, int b) {
        return a + b;
    }
}


class Stu {
    private String name;
    private int age;

    public Stu(String name, int age) {
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
        return "姓名：" + this.name + "年龄：" + this.age;
    }
}
