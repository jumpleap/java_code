package blog;

public class StringBufferMethod {
    public static void main(String[] args) {
        //增加：append()；
        StringBuffer s = new StringBuffer();
        s.append("jack").append(true).append(10012).append("货物");
        System.out.println(s);

        //删除：delete(int start, int end);
        s.delete(1, 3);
        System.out.println(s);

        //插入：insert(int index);
        s.insert(3, "love");
        System.out.println(s);

        //改：replace();
        s.replace(1, 3, "maria");
        System.out.println(s);

        //求长度：length();
        System.out.println(s.length());//20
    }
}
