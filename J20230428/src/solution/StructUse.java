package solution;

/**
 * 构造器的作用
 */
public class StructUse {
    public static void main(String[] args) {
        //构造器的作用是给对象进行初始化：给human对象初始化
        Human human = new Human("jack", 9);

    }
}

class Human {
    public String name;
    public int age;
    public char gender;

    //构造器
    //这四个构造器进行了方法重载：方法名相同，参数列表不同【个数、顺序、类型】,返回类型无要求
    public Human() {
        //构造器之间可以相互调用【不能形成环】
        this("小红");
    }

    public Human(String name) {
        this("小明", 19);
        this.name = name;
    }

    public Human(String name, int age) {
        this("小兰", 19, '女');
        this.name = name;
        this.age = age;
    }

    public Human(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}