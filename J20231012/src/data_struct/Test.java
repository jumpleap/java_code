package data_struct;

import java.util.ArrayList;

/**
 * ArrayList底层代码分析
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        /*
        public ArrayList() {
            //无参构造器, 把默认开辟空间的数组赋给elementData
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }

        //有参构造器, 给elementData开辟了initialCapacity个空间大小
        public ArrayList(int initialCapacity) {
            //判断清空, initialCapacity大于0则申请空间
            if (initialCapacity > 0) {
                this.elementData = new Object[initialCapacity];
            } else if (initialCapacity == 0) {
                //initialCapacity = 0, 把空数组赋给elementData
                this.elementData = EMPTY_ELEMENTDATA;
            } else {
                //initialCapacity < 0 抛出异常
                throw new IllegalArgumentException("Illegal Capacity: "+
                                                   initialCapacity);
            }
        }

        //Collection构造: 只要是Collection下的实现类都可以被构造
        //? extends E: 只要是E的子类及E类型的类都可以使用
        public ArrayList(Collection<? extends E> c) {
            //把c转化为数组,并使elementData数组指向c转化后的数组
            elementData = c.toArray();

            //判断elementData的长度是否为0
            if ((size = elementData.length) != 0) {
                //检查c转化后的数组是否是Object[]类型,不是的话全部转化为Object[]类型
                if (elementData.getClass() != Object[].class)
                    elementData = Arrays.copyOf(elementData, size, Object[].class);
            } else {
                // 数组长度为0的话,赋给elementData空数组
                this.elementData = EMPTY_ELEMENTDATA;
            }
        }
         */
    }
}
