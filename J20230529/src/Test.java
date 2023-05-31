import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(30);
        System.out.println(arrayList);

        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(10);
        arrayList1.add(20);
        arrayList1.add(30);
        System.out.println(arrayList1);

        //会把含有arrayList1中的所有相同元素删掉
        arrayList.removeAll(arrayList1);
        System.out.println(arrayList);
    }
}
