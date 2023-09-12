package practice;

/**
 * 时间复杂度分析
 */
public class Demo2 {
    public int binarySearch(int array[], int target) {
        int left = 0;
        int right = array.length;

        while (left < right) {
            //取中值
            int mid = left + (right - left) / 2;

            if (array[mid] > target) {
                left = mid + 1;
            } else if (array[mid] < target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        //没找到
        return -1;
    }


    public long factorial(int n) {
        return n < 2 ? n : factorial(n - 1) * n;
    }


    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            if (!flag) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubbleSort(array);
        System.out.println();
    }

    public long[] fibonacci(int n) {
        long[] fibArray = new long[n + 1];
        fibArray[0] = 0;
        fibArray[1] = 1;

        for (int i = 2; i < fibArray.length; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }
}

