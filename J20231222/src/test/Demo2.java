package test;

public class Demo2 {
    public static void main(String[] args) {
        //使用各封装类的SIZE方法
        int byteSize = Byte.SIZE / 8;
        int shortSize = Short.SIZE / 8;
        int intSize = Integer.SIZE / 8;
        int longSize = Long.SIZE / 8;
        int floatSize = Float.SIZE / 8;
        int doubleSize = Double.SIZE / 8;
        int charSize = Character.SIZE / 8;

        //查看内存空间大小
        System.out.println(byteSize);//1
        System.out.println(shortSize);//2
        System.out.println(intSize);//4
        System.out.println(longSize);//8
        System.out.println(floatSize);//4
        System.out.println(doubleSize);//8
        System.out.println(charSize);//2
    }
}
