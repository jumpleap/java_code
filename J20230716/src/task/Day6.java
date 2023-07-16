package task;

public class Day6 {
    //代码题

    /*
    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
    请必须使用时间复杂度为 O(log n) 的算法。
     */

    /**
     * 法一：遍历插入【特殊情况，target比数组中的所有值都大】
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums   已排序数组
     * @param target 目标值
     * @return 返回索引
     */
    public int searchInsert1(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            //若nums[i]的值比target的值大，直接跳出循环
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }
        //若数组中的值都没有target大，则把target放在数组最好一个位置
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        return index;
    }

    /**
     * 法二：二分查找插入
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     *
     * @param nums   已排序数组
     * @param target 目标值
     * @return 返回索引
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        //判断target在最后一个位置上
        if (nums[right] < target) {
            return right + 1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    /*
    你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。
    由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
    假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
    你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。
    实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
     */

    /**
     * 二分查找：错误的版本后面都是错误的版本，正确的版本之前都是正确的版本
     * 时间复杂度：O(logn)
     * 空间复杂度：O(1)
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        //二分查找
        while (left < right) {
            int mid = left + (right - left) / 2;

            //如果这个版本为正确的版本，那么这个版本之前的都是正确的版本;
            //反之，那么这个版本之后的版本都是错误的版本
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        //此时，left==right,区间汇聚成一个点
        return left;
    }

    private boolean isBadVersion(int mid) {
        return false;
    }
}


//1、类 ABC 定义如下：
//将以下哪个方法插入行 3 是不合法的（B）
class ABC {
    public double max(double a, double b) {
        return a;
    }

    public float max(float a, float b, float c) {
        return a;
    }

    //public double max (double c, double d){ return c }
    public float max(float a, float b) {
        return a;
    }

    private int max(int a, int b, int c) {
        return a;
    }
    //解析：方法重载：方法名相同，参数列表类型、个数、顺序至少有一个不同，返回值和修饰符无要求

    /*
    2、下列关于Java类中方法的定义，正确的是（D）
    A: 若代码执行到return语句，则将当前值返回，而且继续执行return语句后面的语句。//执行return后的语句不执行
    B: 只需要对使用基本数据类型定义的属性使用getter和setter，体现类的封装性。//不止基本数据类型能进行封装
    C: 方法的返回值只能是基本数据类型。//可以返回引用类型
    D: 在同一个类中定义的方法，允许方法名称相同而形参列表不同。//方法重载


    3、下面哪个方法是 public void example(){...} 的重载方法?（D）
    A: public void Example( int m){...}
    B: public int example(){...}
    C: public void example2(){...}
    D: public int example ( int m, float f){...}
    */
}

//4、检查程序，是否存在问题，如果存在指出问题所在，如果不存在，说明输出结果（A）
class Inc {
    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.fermin(i);
        i = i++;
        System.out.println(i);
    }

    void fermin(int i) {
        i++;
    }
    //A: 0 B: 1 C: 2 D: 3
    //解析：后置++先赋值，后++

    /*
    5、下列关于while循环、do-while循环和for循环说法错误的是【多选】（BC）
    A: while循环先执行条件判断，do-while循环执行循环体
    B: do-while循环结束的条件是关键字while后的条件表达式成立 //不成立退出循环
    C: for循环结构中的3个表达式缺一不可//可以缺少
    D: while循环能够实现的操作，for循环也能实现
     */
}