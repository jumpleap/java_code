package blog;

public class ThrowableSystem {
    public static void main(String[] args) {
        try {
            //System.out.println(10 / 0);
            System.out.println(1 + 1);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } finally {
            System.out.println("算术异常");
        }
        System.out.println("后续代码");
    }
}
