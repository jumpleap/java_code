package thread;

// 饿汉模式
public class HungerPattern {
    private final static HungerPattern instance = new HungerPattern();

    private HungerPattern() {}

    public static HungerPattern getInstance() {
        return instance;
    }
}
