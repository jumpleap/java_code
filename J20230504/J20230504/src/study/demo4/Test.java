package study.demo4;

/*class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if(this.age - o.age > 0) {
            return 1;
        } else if(this.age - o.age < 0) {
            return -1;
        } else {
            return 0;//0则表示两个数相等
        }
        //return this.age - o.age;
    }
}


public class Test {
    public static void main(String[] args) {
        Student jack = new Student("jack", 10);
        Student mary = new Student("mary", 12);

        //只能按照特定的方式进行比较，可修改性太弱
        System.out.println(jack.compareTo(mary));
    }
}*/

//上面的代码的可修改性太差

import java.util.Arrays;
import java.util.Comparator;

class Student implements Comparable<Student> {
    public String name;
    public int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}

//对类的侵入性不强
class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        //按照年龄进行比较
        return o1.age - o2.age;
    }
}

//按照名字进行比较
class NameComparator implements Comparator<Student> {
    public int compare(Student student1, Student student2) {
        //名字进行比较
        return student1.name.compareTo(student2.name);
    }
}

public class Test {
    public static void main(String[] args) {
        Student maria = new Student("maria", 10);
        Student jerry = new Student("jerry", 18);

        AgeComparator ageComparator = new AgeComparator();
        System.out.println(ageComparator.compare(maria, jerry));

        Student[] students = new Student[3];
        students[0] = new Student("zhangsan", 10);
        students[1] = new Student("lisi", 2);
        students[2] = new Student("wangmazi", 18);

        //bubbleSort(students);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    //使用冒泡排序实现Comparable
    public static void bubbleSort(Comparable[] comparable) {
        for (int i = 0; i < comparable.length - 1; i++) {
            for (int j = 0; j < comparable.length - 1 - i; j++) {
                if (comparable[j].compareTo(comparable[j + 1]) < 0) {
                    Comparable tmp = comparable[j];
                    comparable[j] = comparable[j + 1];
                    comparable[j + 1] = tmp;
                }
            }
        }
    }
}
