package thread;

public class LazyPattern {
    private volatile static LazyPattern instance = null;

    private LazyPattern() {}

    public static LazyPattern getInstance() {
        if(instance == null) {
            synchronized (LazyPattern.class) {
                if(instance == null) {
                    instance = new LazyPattern();
                }
            }
        }
        return instance;
    }
}
