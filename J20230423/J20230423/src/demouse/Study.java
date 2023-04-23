package demouse;

public class Study {
    public static void main(String[] args) {
        Son son = new Son();
        son.play();
    }
}

//父类
class Parent {
    private String name;
    private int age;
    private String hobby;

    public Parent() {
    }

    public Parent(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
    }

    public void say() {
        System.out.println("爸爸妈妈聊天~");
    }

    public void call() {
        System.out.println("爸爸给儿子打电话~");
    }

    public void play() {
        System.out.println("爸爸正在下象棋~");
    }
}

//子类
class Son extends Parent {
    private String name;
    private int age;

    public Son() {

    }

    public Son(String name, int age) {
        //super和this不能共存与构造器中，它们均需要放在第一行
        //this();
        super();//调用父类的构造器
        this.name = name;
        this.age = age;
    }

    //重写父类的方法
    public void play() {
        //this代表子类的引用，寻找say方法时，先从子类找，没有找到，再去父类中找……
        this.say();
        //super代表父类的引用，直接从父类中寻找call方法……
        super.call();
        System.out.println("儿子在玩游戏~");
    }
}