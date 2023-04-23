package demouse;

import java.util.Arrays;
@SuppressWarnings({"all"})

public class Case {
    public static void main(String[] args) {
        //那个对象调用类中的属性，this就代表谁
        Student jack = new Student("jack", 20);
        //jack对象调用Student类中的print方法，this就代表jack这个对象
        jack.print();
    }
}

//模板
class Student {
    //成员变量
    private String name;
    private int age;

    //构造器
    public Student() {}

    //this区分局部变量
    public Student(String name, int age) {
        this();//调用另外一个构造器
        this.name = name;
        this.age = age;
    }

    //打印方法
    public void print() {
        System.out.println("姓名：" + this.name + "年龄：" + this.age);
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
}

class One {
    public static void main3(String[] args) {
        //不规则的二维数组
        int[][] array = new int[3][];
        array[0] = new int[]{1, 2, 3};
        array[1] = new int[]{2, 3, 4, 5, 6};
        array[2] = new int[]{3, 4, 5, 6, 7, 8, 9};

        //输出二位数组查看并不规则
        System.out.println(Arrays.deepToString(array));
        //[[1, 2, 3], [2, 3, 4, 5, 6], [3, 4, 5, 6, 7, 8, 9]]
    }

    public static int num = 10;
    public static void main2(String[] args) {
        int num = 20;
        System.out.println(num);//20
        print();
    }

    private static void print() {
        System.out.println(num);//10
    }

    /**
     * 类和对象的联系
     * @param args
     */
    public static void main1(String[] args) {
        //实例化一个对象
        Student student = new Student();
        //一个类可以实例化多个对象
        Student student1 = new Student();
        Student student2 = new Student();
    }
}