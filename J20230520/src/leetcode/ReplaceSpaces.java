package leetcode;

/**
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，
 * 并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 */
public class ReplaceSpaces {

    //法一：使用StringBuilder解决
    public String replaceSpaces1(String s, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return sb.toString();
    }

    //法二：字符数组解决
    public String replaceSpaces(String s, int length) {
        char[] arr = new char[length * 3];

        int index = 0;
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ') {
                arr[index++] = '%';
                arr[index++] = '2';
                arr[index++] = '0';
            } else {
                arr[index++] = s.charAt(i);
            }
        }
        return new String(arr, 0, index);
    }
}
