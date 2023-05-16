package blog;

/**
 * 浅拷贝（只拷贝一个对象，不拷贝对象中的对象）
 * 步骤：
 * 1.重写Object类的clone方法
 * 2.让要克隆对象的类实现Cloneable接口
 * 3.抛出CloneNotSupportedException异常
 * 4.向下转型【clone的方法返回值是Object类型】
 */
public class ShallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal = new Animal(12);
        Animal animal1 = (Animal) animal.clone();

        animal.setAge(100);
        System.out.println(animal.getAge());//100
        System.out.println(animal1.getAge());//12

        animal.getTiger().setNum(10);
        //说明animal和animal1两个引用均指向同一个tiger对象
        System.out.println(animal.getTiger().getNum());//10
        System.out.println(animal1.getTiger().getNum());//10
        animal1.getTiger().setNum(100);
        System.out.println(animal.getTiger().getNum());//100
        System.out.println(animal1.getTiger().getNum());//100
    }
}

class Animal implements Cloneable {
    private int age;
    private Tiger tiger;

    public Animal(int age) {
        tiger = new Tiger();
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Tiger getTiger() {
        return tiger;
    }

    public void setTiger(Tiger tiger) {
        this.tiger = tiger;
    }

    //重写父类的clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Tiger implements Cloneable {
    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}