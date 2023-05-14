package homework;

public class Test {
    public static void main(String[] args) {

    }
}

class TestClass {
    private static void testMethod() {
        System.out.println("testMethod");
    }

    public static void main(String[] args) {
        ((TestClass) null).testMethod();
    }
}