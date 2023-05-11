package blog;

public class Test2 {
    public static void main(String[] args) {
        //向上转型
        Student student1 = new Graduate();
        Student student2 = new Pupil();

        //体现了向上转型
        print(student1);
        print(student2);
    }

    public static void print(Student student) {
        //调用都有的方法
        student.exam();

        if (student instanceof Graduate) {
            //向下转型：向下转型的前提是向上转型
            ((Graduate) student).write();//向下转型后可以访问子类中特有的方法
        } else if (student instanceof Pupil) {
            ((Pupil) student).play();
        } else {
            System.out.println("错误");
        }
    }
}

class Student {
    public void exam() {
        System.out.println("学生需要考试");
    }
}

class Graduate extends Student {
    @Override
    public void exam() {
        System.out.println("大学生在考高等数学~");
    }

    //特有方法
    public void write() {
        System.out.println("大学生要写毕业论文~");
    }
}

class Pupil extends Student {
    @Override
    public void exam() {
        System.out.println("小学生在考小学数学~");
    }

    //特有方法
    public void play() {
        System.out.println("小学生在愉快的玩耍~");
    }
}