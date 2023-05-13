package practice;

public class Test1 {
    public static void main(String[] args) {
        Alg<Integer> integerAlg = new Alg<>();
        for (int i = 0; i < 10; i++) {
            integerAlg.setObject(i);
        }
    }
}

class Alg<T> {
    private int count = 0;
    public Object[] objects = new Object[10];

    public void setObject(Object object) {
        objects[count] = object;
    }

    public Object getObj() {
        return objects;
    }
}