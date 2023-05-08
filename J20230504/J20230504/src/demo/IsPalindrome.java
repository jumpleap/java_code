package demo;
@SuppressWarnings({"all"})

public class IsPalindrome {
    public static void main(String[] args) {
        String str ="A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();//将所有的大写字母转化小写字母
        int len = s.length();//字符串长度
        char[] ch = new char[len];
        int count = 0;

        for(int i=0; i<len; i++) {
            //将字符和数字写入到字符数组中
            if((s.charAt(i) >= '0' && s.charAt(i) <= '9') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                ch[count] = s.charAt(i);
                count++;
            }
        }

        int left = 0;
        int right = count - 1;

        while(left < right) {
            //左边和右边进行比较，不相等则返回false
            if(ch[left] != ch[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        char[] ch = s.toLowerCase().toCharArray();
        int count = 0;

        for(int i=0; i<ch.length; i++) {
            //将字符和数字写入到字符数组中
            if((ch[i] >= '0' && ch[i] <= '9') ||
                    (ch[i] >= 'a' && ch[i] <= 'z')) {
                ch[count++] = ch[i];
            }
        }

        //左右指针进行比较
        int left = 0;
        int right = count - 1;

        while(left < right) {
            //判断前后是否相等
            if(ch[left] != ch[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}