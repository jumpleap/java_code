package blog;

/**
 * 深拷贝（对象的对象均拷贝）
 * 步骤：
 * 1.让克隆对象的类和克隆对象中的对象所在类，两者均重写Object类的clone方法
 * 2.让克隆对象的类和克隆对象中的对象所在类，均实现Cloneable接口
 * 3.在克隆对象的类中重写父类的clone方法，并在这个克隆方法中把另外一个对象先克隆后返回【需向下转型】
 * 4.向下转型【clone的方法返回值是Object类型】
 * 5.抛出CloneNotSupportedException异常
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher = new Teacher(30);
        Teacher teacher1 = (Teacher) teacher.clone();
        teacher.setAge(10);
        System.out.println(teacher.getAge());//10
        System.out.println(teacher1.getAge());//30

        teacher.getStudent().setAge(11);
        teacher1.getStudent().setAge(12);
        System.out.println(teacher.getStudent().getAge());//11
        System.out.println(teacher1.getStudent().getAge());//12
    }
}

class Teacher implements Cloneable {
    private int age;
    private Student student;

    public Teacher(int age) {
        student = new Student();
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "age= " + age;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Teacher tmp = (Teacher) super.clone();
        tmp.student = (Student) student.clone();
        return tmp;
    }
}


class Student implements Cloneable {
    private int age = 10;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}