package string;

/**
 * 通配符的基本使用
 */
public class Test2 {
    public static void main(String[] args) {
        Message<Fruit> message = new Message<>();
        Message<Food> foodMessage = new Message<>();
        Message<Apple> appleMessage = new Message<>();

        //funSuper(appleMessage);
        funSuper(message);
        funSuper(foodMessage);
    }

    /**
     * 通配符的下界：必须是fruit及其父类才能使用
     * 可以接收最下界的子类：可以修改上界的值
     * @param tmp
     */
    public static void funSuper(Message<? super Fruit> tmp) {
        System.out.println(tmp.getMessage());
        //这个地方可以进行修改值
        //向上转型：父类的引用指向子类的对象
        tmp.setMessage(new Banana());
        tmp.setMessage(new Apple());

        //Fruit fruit = tmp.getMessage();//错误，不知道这里是那个父类
    }

    public static void main2(String[] args) {
        Message<Apple> message = new Message<>();
        message.setMessage(new Apple());
        funExtends(message);

        Message<Banana> bananaMessage = new Message<>();
        bananaMessage.setMessage(new Banana());
        funExtends(bananaMessage);

        Message<Food> foodMessage = new Message<>();
        foodMessage.setMessage(new Banana());

        //funExtends(foodMessage);

    }

    /**
     * 通配符的上界：必须是fruit及其子类才能使用
     * 可以使用上界的父类接收其下面的子类：向上转型
     * @param tmp
     */
    public static void funExtends(Message<? extends Fruit> tmp) {
        System.out.println(tmp.getMessage());

        /*tmp.setMessage(new Apple()); 不知道接收到的是具体的那个子类型，不能修改值
        tmp.setMessage(new Banana());*/

        Fruit fruit = tmp.getMessage();//父类的引用指向子类的对象：向上转型
    }


    public static void main1(String[] args) {
        Message<String> stringMessage = new Message<>();
        stringMessage.setMessage("你好！李焕英");
        fun(stringMessage);

        Message<Integer> integerMessage = new Message<>();
        integerMessage.setMessage(1223);
        fun(integerMessage);
    }

    //？: 通配符，可以接收任意的数据类型
    public static void fun(Message<?> tmp) {
        //tmp.setMessage("heloo");//不知道接收到的是什么类型，所以不能修改接收类型的值
        System.out.println(tmp.getMessage());
    }
}

class Message<T> {
    private T message;

    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}

class Food {

}

class Fruit extends Food {

}

class Apple extends Fruit {

}

class Banana extends Fruit {

}