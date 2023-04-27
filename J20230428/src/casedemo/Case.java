package casedemo;

/**
 * this在匿名内部类中的作用
 */
public class Case {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.say();
    }
}

class Animal {
    protected String result = "gitee";

    protected void say() {
        //匿名内部类
        new Dog() {
            @Override
            public void say() {
                //当前的this代表animal对象，即代表外部类的引用
                System.out.println(Animal.this.result);
                super.say();
            }
        }.say();//调用
    }
}

class Dog {
    public void say() {
        System.out.println("够在叫~");
    }
}