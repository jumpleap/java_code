package practice;

import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        //Alg2<Integer> integerAlg = new Alg2<>();
        Integer[] array = {1, 13, 131, 32, 3};
        Integer ret = Alg2.findMax(array);//131
        System.out.println(ret);
    }

    public static void main3(String[] args) {
        Alg<Integer> integerAlg = new Alg<Integer>();
        Integer[] arr = {1, 3, 5, 2, 3, 554, 221};
        Integer ret = integerAlg.findMax(arr);
        System.out.println(ret);//554
    }

    public static void main2(String[] args) {
        //泛型是如何编译的：它会把所有的泛型在编译阶段换为特定的类型
        MyArray<String> stringMyArray = new MyArray<>();
        stringMyArray.set(0, "hello");
        Object[] ret = stringMyArray.getArray();
        System.out.println(Arrays.toString(ret));
    }

    public static void main1(String[] args) {
        MyArray<String> arr = new MyArray<>();
        arr.set(0, "hello");
        //设置特定的泛型后，只能放那个数据类型
        String str = arr.get(0);
        System.out.println(str);//hello

        MyArray<Integer> integerMyArray = new MyArray<>();
        integerMyArray.set(0, 1);
        integerMyArray.set(1, 10);
        //integerMyArray.set(2,"10");

        Integer a = integerMyArray.get(0);
        System.out.println(a);
    }
}

class MyArray<T> {
    public Object[] array = new Object[10];
    //public T[] = new T[10];//不允许实例化一个泛型数组
    //public T[] arr = (T[])new Object[10];//也不要这样写

    public void set(int pos, T val) {
        array[pos] = val;
    }

    public T get(int pos) {
        return (T) array[pos];
    }

    public Object[] getArray() {
        return array;
    }
}

//泛型的上限
class Alg<T extends Comparable<T>> {
    public T findMax(T[] array) {
        T max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}

class Alg2 {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        T max = array[0];

        for (int i = 0; i < array.length; i++) {
            if(array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }
        return max;
    }
}