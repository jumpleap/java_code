package study;

public class Demo {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 98, 9, 6};
        int index = 0;
        int num = 1;

        for (int i = 0; i < arr.length; i++) {
            if (num != arr[i]) {
                arr[index] = arr[i];
                index++;
            }
        }
        for (int i = 0; i < index; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}