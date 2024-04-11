package data_structure.sort;

import java.util.Random;
import java.util.Stack;

// 常见排序实现
public class Sort {
    /**
     * 插入排序
     * 思想: 使用当前数据, 和之前已经排序好的数据进行比较, 从后往前进行比较, 找到插入的位置进行插入
     * 时间复杂度:
     * 最后情况: 数据完全有序的时候 -> O(N)
     * 最坏情况: 数据完全无序的时候 -> O(N^2)
     * 注: 当所给数据越有序排序越快
     * 空间复杂度: O(1)
     * 稳定性: 稳定
     * 注: 一个本身就是稳定的排序, 是可以实现为不稳定的排序的; 一个本身不稳定的排序, 是不可能实现稳定的排序的
     */
    public void insertSort(int[] array) {
        // 从1开始, 因为只有一个数据不需要排序
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            // 获取当前索引的前一个索引
            int j = i - 1;
            // 使用当前数据和前面已排序的数据进行比较
            for (; j >= 0; j--) {
                // 若j索引的值大于待排序的值, 则把该索引的值后移, 一直到tmp的值大于j索引的值为止
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    // 当tmp的值比array[j]的值大, 则说明当前位置就是tmp插入位置
                    break;
                }
            }
            // 在退出循环后, j的值为待插入位置-1, 需要把tmp赋值给该索引
            array[j + 1] = tmp;
        }
    }

    /**
     * 希尔排序
     * 思想: 将待排序数据进行分组, 每组进行直接插入排序, 每组都有序后, 再进行整体数据进行插入排序
     * 时间复杂度: O(N^1.3 ~ N^1.5)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     */
    public void shellSort(int[] array) {
        // 获取数组长度, 用于分组
        int gap = array.length;
        while (gap > 1) {
            // 进行分组排序
            gap /= 2;
            // 进行排序
            shell(array, gap);
        }
    }

    private void shell(int[] array, int gap) {
        // 从 gap 开始排序
        for (int i = gap; i < array.length; i++) {
            // 获取待排序的值
            int tmp = array[i];
            // 获取已排序的下标
            int j = i - gap;

            // 用待排序的值和已排序的值进行比较
            for (; j >= 0; j -= gap) {
                // 待排序值 小于 已排序值, 当前已排序值后移
                if (array[j] > tmp) {
                    array[j + gap] = array[j];
                } else {
                    // 跳出循环, 则说明待排序值大于当前已排序值
                    break;
                }
            }
            // 把待排序值插入到当前已排序值的后一个, 因为当前待排序值大于已排序值
            // 可能当前待排序值是最大的一个, 跳出循环后, 插入在已排序序列的最后一个位置
            // 可能当前待排序值是最小的一个, 跳出循环后, 插入在已排序序列的第一个位置
            array[j + gap] = tmp;
        }
    }

    /**
     * 选择排序
     * 思想: 每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完
     * 时间复杂度: O(N^2)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     */
    public void selectSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 用于记录最小值的下标
            int minIndex = i;
            // 从 i 的后一个下标开始进行遍历, 寻找比 array[i]小的值, 记录下标
            for (int j = i + 1; j < array.length; j++) {
                // 找到最小值的下标, 赋给minIndex
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换数据
            swap(array, minIndex, i);
        }
    }

    /**
     * 交换数据
     */
    private void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }


    /**
     * 冒泡排序
     * 思想: 通过对待排序序列从前向后依次对相邻两个元素进行两两比较, 若发现逆序则交换, 大的值往后面移.
     * 时间复杂度: O(N^2) 加了优化最后O(N)
     * 空间复杂度: O(1)
     * 稳定性: 稳定
     */
    public void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            // 优化标志
            boolean flag = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 进行两两比较
                if (array[j] > array[j + 1]) {
                    // 交换数据
                    swap(array, j, j + 1);
                    // 进行交换则说明这一趟不是有序的
                    flag = true;
                }
            }
            // 有序了, 跳出循环
            if (!flag) {
                break;
            }
        }
    }


    /**
     * 堆排序: 升序创建大根堆, 降序创建小根堆
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(1)
     * 稳定性: 不稳定
     */
    public void heapSort(int[] array) {
        // 创建大根堆
        createBigHeap(array);
        // 获取最后一个下标
        int len = array.length - 1;

        // 简历大根堆, 每次把最大的一个数放在最后
        while (len > 0) {
            // 把最大值的放在最后一个数
            swap(array, 0, len);
            // 对调整后的数进行向下调整, 因为此时第一个数不是最大的
            shiftDown(array, 0, len);
            // 我们已经排序好了最后一个数, 自减, 开始排下一个数
            len--;
        }
    }

    // 创建大根堆
    private void createBigHeap(int[] array) {
        // 注: array.length - 1 - 1: 第一个-1是得到有效元素个数, 因为usedSize添加元素后, 已经往后增1
        // 注: array.length - 1 - 1: 第二个-1是获取父节点, 获取父节点的操作: (child - 1) / 2
        for (int parent = (array.length - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(array, parent, array.length);
        }
    }

    private void shiftDown(int[] array, int parent, int length) {
        // 获取左孩子下标
        int child = 2 * parent + 1;

        // 当孩子下标的长度比数组长度还长时, 说明不存在这个孩子节点
        while (child < length) {
            // 找到左右孩子中最大的孩子节点
            if (child + 1 < length && array[child + 1] > array[child]) {
                // 若是右孩子比较大, 那么就指向右孩子的下标
                child++;
            }

            // 到这个地方, 当前的孩子是最大值的孩子
            // 当孩子节点比父节点还大时, 进行交换
            if (array[child] > array[parent]) {
                swap(array, child, parent);
                // 继续判断孩子节点下面的节点
                parent = child;
                child = parent * 2 + 1;
            } else {
                // 此时堆已经建好了
                break;
            }
        }
    }


    /**
     * 快速排序
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(logN)
     * 稳定性: 不稳定
     * 思想: 分治
     *      选择基准值（pivot）：
     *          从待排序的数组中选择一个元素作为基准值。基准值的选择可以是任意的，
     *          常见的方式包括选择数组的第一个元素、最后一个元素或者中间的元素，甚至可以随机选择。
     *      分区（Partition）：
     *          将数组中小于基准值的元素放置在基准值的左边，大于基准值的元素放置在基准值的右边。这个过程称为分区。
     *          分区的具体实现可以采用多种方法，包括Hoare分区法、左右指针分区法、挖坑填数法等。
     *      递归排序：
     *          对分区后的左右两个子数组进行递归排序。
     *          即对左边子数组和右边子数组分别重复步骤1和步骤2，直到子数组的长度为1或0时停止递归。
     *      合并（Optional）：
     *          由于快速排序是原地排序（in-place sorting），所以一般情况下不需要显式的合并步骤。
     */
    public void quickSort(int[] array) {
        quick(array, 0, array.length - 1);
    }

    private void quick(int[] array, int left, int right) {
        // 左边只有一个节点或一个节点也没有
        if (left >= right) return;

        // 进行优化
        // 当节点数在这个范围内时进行插入排序优化
        if (right - left + 1 <= 7) {
            insertSortRange(array, left, right);
            return;
        }

        // 三数取中
        int index = midOfThree(array, left, right);
        // 保证了left下标的值一定是中间大的数字
        swap(array, left, index);

        // 找到基准
        int pivot = partition(array, left, right);
        // int pivot = partitionHoare(array, left, right);
        // int pivot = partitionPoint(array, left, right);

        // 对基准的左半部分进行递归
        quick(array, left, pivot - 1);
        // 对基准的右半部分进行递归
        quick(array, pivot + 1, right);
    }

    // 插入排序优化
    private void insertSortRange(int[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = array[i];
            int j = i - 1;

            for (; j >= left; j--) {
                if (array[j] > tmp) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = tmp;
        }
    }

    // 三数取中
    private int midOfThree(int[] array, int left, int right) {
        // 取中间节点
        int mid = left + (right - left) / 2;

        // 判断那个节点处于中间位置
        if (array[left] < array[right]) {
            if (array[mid] < array[left]) {
                return left;
            } else if (array[mid] > array[right]) {
                return right;
            } else {
                return mid;
            }
        } else {
            if (array[mid] > array[left]) {
                return left;
            } else if (array[mid] < array[right]) {
                return right;
            } else {
                return mid;
            }
        }
    }


    /**
     * 挖坑法
     * 分区函数: 使用挖坑法将数组分为小于基准值和大于基准值两部分
     * 关键: 先挖坑, 再填坑
     * 思路:
     *      1.选择一个基准值（pivot），通常可以是数组中的第一个元素、最后一个元素或者随机选择。
     *      2.定义两个指针：左指针（left）和右指针（right），分别指向数组的起始位置和末尾位置。
     *      3.从右边开始，向左移动右指针，直到找到一个小于基准值的元素。将右指针所指向的元素挖出一个"坑"。
     *      4.从左边开始，向右移动左指针，直到找到一个大于基准值的元素。将左指针所指向的元素填入步骤3中的"坑"中。
     *      5.重复步骤3-4，直到左右指针相遇。
     *      6.将基准值填入左右指针相遇的位置。
     *      7.返回左右指针相遇的位置作为分区点。
     */
    private int partition(int[] array, int left, int right) {
        // 选择最左边的值作为基准值
        int key = array[left];

        // 使用挖坑法进行分区
        while (left < right) {
            // 从右边开始找比基准值小的值
            while (left < right && array[right] >= key) {
                right--;
            }
            // 将小于基准值的元素填到坑中
            array[left] = array[right];

            // 从左边开始找比基准值大的值
            while (left < right && array[left] <= key) {
                left++;
            }
            // 将大于基准值的元素填到坑中
            array[right] = array[left];
        }
        // 将基准值填到最后一个坑里
        array[left] = key;
        // 返回基准值下标
        return left;
    }


    /**
     * Hoare法
     * 关键: 在于左右指针的交换, 最后再重新找到新的基准值
     * 思路:
     *      1.选择一个基准值（pivot），通常可以是数组中的第一个元素、最后一个元素或者随机选择。
     *      2.定义两个指针：左指针（left）和右指针（right），分别指向数组的起始位置和末尾位置。
     *      3.左指针向右移动，直到找到一个大于基准值的元素。
     *      4.右指针向左移动，直到找到一个小于基准值的元素。
     *      5.如果左指针小于等于右指针，则交换左右指针所指向的元素。
     *      6.重复步骤3-5，直到左指针大于右指针。
     *      7.将基准值与右指针所指向的元素进行交换，这样基准值就被放置到了正确的位置上。
     *      8.返回左指针的位置作为分区点。
     */
    private int partitionHoare(int[] array, int left, int right) {
        // 选择最左边的值作为基准值
        int key = array[left];
        // 临时保存left的下标
        int tmp = left;

        // 进行分区
        while (left < right) {
            // 从右边开始找比基准值小的值
            while (left < right && array[right] >= key) {
                right--;
            }

            // 从左边开始找比基准值大的值
            while (left < right && array[left] <= key) {
                left++;
            }

            // 交换
            swap(array, left, right);
        }
        // 最后进行交换, 得到基准值
        swap(array, tmp, left);
        // 返回基准下标
        return left;
    }

    /**
     * 左右指针法
     * 分区函数，使用左右指针法将数组分成小于基准值和大于基准值的两部分
     * 思路:
     *      1.选择一个基准值（pivot），通常可以是数组中的第一个元素、最后一个元素或者随机选择。
     *      2.定义两个指针：左指针（left）和右指针（right），分别指向数组的起始位置和末尾位置。
     *      3.从左边开始，向右移动左指针，直到找到一个大于或等于基准值的元素。
     *      4.从右边开始，向左移动右指针，直到找到一个小于或等于基准值的元素。
     *      5.如果左指针小于等于右指针，则交换左右指针所指向的元素。
     *      6.重复步骤3-5，直到左指针大于右指针。
     *      7.将基准值与右指针所指向的元素进行交换，这样基准值就被放置到了正确的位置上。
     *      8.分区完成后，递归地对基准值左边和右边的子数组进行快速排序。
     */
    private int partitionPoint(int[] arr, int low, int high) {
        // 选择最左边的元素作为基准值
        int pivot = arr[low];

        int left = low + 1; // 左指针从基准值右边的第一个元素开始
        int right = high; // 右指针从数组末尾开始

        while (left <= right) {
            // 左指针向右移动，直到找到大于基准值的元素
            while (left <= right && arr[left] <= pivot) {
                left++;
            }

            // 右指针向左移动，直到找到小于基准值的元素
            while (left <= right && arr[right] >= pivot) {
                right--;
            }

            // 如果左指针小于等于右指针，则交换两个元素
            if (left < right) {
                swap(arr, left, right);
            }
        }

        // 将基准值放置到正确的位置上
        swap(arr, low, right);

        // 返回基准值的位置
        return right;
    }


    /**
     * 快速排序非递归版本
     * 思路:
     *      1.创建一个栈，用于存放每个待排序子序列的起始和结束索引。
     *      2.将整个序列的起始索引和结束索引入栈。
     *      3.循环处理栈中的每个待排序子序列，直到栈为空。
     *      4.对每个待排序子序列进行分区操作，找到基准值的位置。
     *      5.将分区点左右两部分的子序列的起始和结束索引入栈。
     *      6.重复步骤3-5，直到所有子序列都已排序。
     */
    public void quickSortNor(int[] array) {
        // 初始化栈
        Stack<Integer> stack = new Stack<>();
        // 将整个数组的起始索引和结束索引入栈
        stack.push(0);
        stack.push(array.length - 1);

        // 循环处理栈中的每个待排序子数组，直到栈为空
        while (!stack.isEmpty()) {
            // 从栈中弹出待排序子数组的起始和结束索引
            int right = stack.pop();
            int left = stack.pop();

            // 找新的基准
            int pivot = partition(array, left, right);

            // 继续进行判断基准的左右两边是否有两个及以上元素
            // 入基准的左半部分
            if (pivot - 1 > left) {
                stack.push(left);
                stack.push(pivot - 1);
            }

            // 入基准的右半部分
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }


    /**
     * 归并排序
     * 时间复杂度: O(NlogN)
     * 空间复杂度: O(N)
     * 思想:
     *      1.分解： 将待排序的数组分解为较小的子数组，直到每个子数组只有一个元素为止。这可以通过递归实现。
     *      2.解决： 对每个子数组进行排序。对于只包含一个元素的子数组，可以视为已排序。
     *      3.合并： 合并相邻的子数组以产生新的排序数组。重复合并操作，直到最终得到完整的排序数组。
     *          1) 将两个有序子数组合并为一个临时数组。
     *          2) 将临时数组中的元素复制回原始数组的相应位置。
     * 稳定性: 稳定
     */
    public void mergeSort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(int[] array, int left, int right) {
        // 左边只有一个节点或一个节点也没有
        if (left >= right) return;

        // 取中值
        int mid = left + (right - left) / 2;
        // 分治
        // 对左半部分进行归并排序
        mergeSort(array, left, mid);
        // 对右半部分进行归并排序
        mergeSort(array, mid + 1, right);
        // 合并左右两部分排序
        merge(array, left, right, mid);

    }

    /**
     * 实现归并排序的关键
     * 将两部分数据有序合并为有序数组
     */
    private void merge(int[] array, int left, int right, int mid) {
        // 用于前半部分
        int s1 = left;
        // 用于后半部分
        int s2 = mid + 1;
        // 创建临时数组, 用于保存有序的数据
        int[] tmpArr = new int[right - left + 1];
        int index = 0;

        // 比较前后部分的数据, 把排序后的数据存储在tmpArr中
        while (s1 <= mid && s2 <= right) {
            // 谁小谁存储
            if (array[s2] <= array[s1]) {
                tmpArr[index++] = array[s2++];
            } else {
                tmpArr[index++] = array[s1++];
            }
        }

        // s2遍历完了, s1未遍历完
        while (s1 <= mid) {
            tmpArr[index++] = array[s1++];
        }

        // s1遍历完了, s2未遍历完
        while (s2 <= right) {
            tmpArr[index++] = array[s2++];
        }

        // 把临时数组存储的有序数据, 保存到array中
        for (int i = 0; i < tmpArr.length; i++) {
            array[i + left] = tmpArr[i];
        }
    }

    /**
     * 归并排序的非递归实现
     */
    public void mergeSortNor(int[] array) {
        // 分了几组
        int gap = 1;

        while (gap < array.length) {
            // 分组, 从1, 2, 4, 8...开始进行合并, 一直到最后完全合并
            for (int i = 0; i < array.length; i += 2 * gap) {
                // 左边界
                int left = i;
                // 中值
                int mid = left + gap - 1;
                // 有边界
                int right = mid + gap;

                // 当中值超过数组长度, 中值为数组最后一个元素的下标
                if (mid >= array.length) {
                    mid = array.length - 1;
                }

                // 当右边界超过数组长度, 右边界为数组最后一个元素的下标
                if (right >= array.length) {
                    right = array.length - 1;
                }

                // 合并
                merge(array, left, right, mid);
            }
            gap *= 2;
        }
    }


    /**
     * 计数排序
     * 时间复杂度: O(N+K)
     * 空间复杂度: O(K)
     * 思路:
     *      1.统计计数：
     *          遍历待排序数组，统计每个元素出现的次数，并将统计结果存储在一个计数数组中。
     *          计数数组的索引表示待排序数组的元素取值，计数数组的值表示该元素在待排序数组中出现的次数。
     *      2.累加计数：
     *          对计数数组进行顺序累加，得到每个元素在排序后的数组中的起始位置。
     *          这一步的目的是确定每个元素在排序后的数组中的位置。
     *      3.排序：
     *          创建一个与待排序数组等长的临时数组，遍历待排序数组，
     *          根据计数数组中的信息将元素放置到临时数组的相应位置上。每放置一个元素，对应的计数数组的值减一。
     *      4.复制结果：
     *          将排序后的结果复制回原始数组，完成排序过程。
     * 稳定性: 稳定
     */
    public void countSort(int[] array) {
        // 初始化最小值和最大值
        int minVal = array[0];
        int maxVal = array[0];

        // 求当前数组的最大值和最小值
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
            if (array[i] < minVal) {
                minVal = array[i];
            }
        }

        // 根据最大值和最小值得到数组的大小
        int[] count = new int[maxVal - minVal + 1];

        // 遍历原来的数组，开始计数
        for (int i = 0; i < array.length; i++) {
            count[array[i] - minVal]++;
        }

        // 遍历计数count把当前元素写回array
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            //多个数的情况
            while (count[i] > 0) {
                array[index++] = i + minVal;
                count[i]--;
            }
        }
    }
}
