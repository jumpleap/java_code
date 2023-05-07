package study.demo5;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person("jack", 10);
        Person person1 = (Person) person.clone();
        System.out.println(person);
        System.out.println(person1);
        person1.setName("maria");
        String name = "jack";
        char[] ch = name.toCharArray();

        System.out.println(person);
        System.out.println(person1);
    }
}

class Person implements Cloneable {
    private String name;
    private int age;

    public Person(String name, int age) {
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
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 因为是protected，所以需要重写父类的方法，使用super调用
     *
     * @return 返回父类的从clone方法
     * @throws CloneNotSupportedException 异常类型
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}