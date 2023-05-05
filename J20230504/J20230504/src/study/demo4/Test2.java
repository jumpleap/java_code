package study.demo4;

/**
 * 完成对象的浅拷贝和深拷贝
 */
public class Test2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person(12);
        Person person1 = (Person) person.clone();

        //浅拷贝完成
        System.out.println(person);
        System.out.println(person1);

        //打印看看前是不是19.9
        person1.getMoney().setMoneyTotal(9.9);
        System.out.println(person.getMoney().getMoneyTotal());//9.9
        System.out.println(person1.getMoney().getMoneyTotal());//9.9

    }
}

class Person implements Cloneable {
    private int age;
    private Money money;

    public Person(int age) {
        this.money = new Money();
        this.age = age;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //重写clone方法
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //在此处完成深拷贝
        Person tmp = (Person) super.clone();//获得Person的拷贝
        //获得Money的拷贝
        tmp.setMoney((Money) this.getMoney().clone());
        return tmp;
    }

    @Override
    public String toString() {
        return "age=" + age;
    }
}

class Money implements Cloneable {
    private double moneyTotal = 19.9;

    public double getMoneyTotal() {
        return moneyTotal;
    }

    public void setMoneyTotal(double moneyTotal) {
        this.moneyTotal = moneyTotal;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}