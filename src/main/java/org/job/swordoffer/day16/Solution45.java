package org.job.swordoffer.day16;

/**
 * 这一题的核心在于 选择任意两个数字字符，进行拼接。对得到的数字进行大小比对
 * 例如 10，2
 * 102 < 210 也就是 2 > 10
 * * @author Superman
 */
public class Solution45 {
    public String minNumber(int[] nums) {
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = String.valueOf(nums[i]);
        }
        // return bubbleSort(strings);
        // return bubbleSort2(strings);
        // return bubbleSort3(strings);
        // return selectionSort(strings);
        // return insertSort(strings);
        singleQuickSort(strings, 0, strings.length - 1);
        // doubleQuickSort(strings, 0, strings.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strings) {
            res.append(s);
        }
        return res.toString();
    }

    /**
     * 双边循环快排（不完全等价于 hoare 霍尔分区方案）
     * 选择最左元素作为基准点元素
     * j 指针负责从右向左找比基准点小的元素，i 指针负责从左向右找比基准点大的元素，一旦找到二者交换，直至 i，j 相交
     * 最后基准点与 i（此时 i 与 j 相等）交换，i 即为分区位置
     *
     * @param strings
     * @return
     */
    private void doubleQuickSort(String[] strings, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        String tmp = strings[i];
        while (i < j) {
            while ((strings[j] + strings[l]).compareTo(strings[l] + strings[j]) >= 0 && i < j) {
                j--;
            }
            while ((strings[i] + strings[l]).compareTo(strings[l] + strings[i]) <= 0 && i < j) {
                i++;
            }
            tmp = strings[i];
            strings[i] = strings[j];
            strings[j] = tmp;
        }
        strings[i] = strings[l];
        strings[l] = tmp;
        doubleQuickSort(strings, l, i - 1);
        doubleQuickSort(strings, i + 1, r);
    }

    /**
     * 单边循环快排（lomuto 洛穆托分区方案）
     * 选择最右元素作为基准点元素
     * j 指针负责找到比基准点小的元素，一旦找到则与 i 进行交换
     * i 指针维护小于基准点元素的边界，也是每次交换的目标索引
     * 最后基准点与 i 交换，i 即为分区位置
     *
     * @param strings
     * @param l
     * @param r
     */
    private void singleQuickSort(String[] strings, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l;
        String baseEle = strings[r];
        String tmp;
        for (int j = l; j < r; j++) {
            if ((baseEle + strings[j]).compareTo(strings[j] + baseEle) > 0) {
                tmp = strings[j];
                strings[j] = strings[i];
                strings[i] = tmp;
                i++;
            }
        }
        if (i != r){
            tmp = strings[i];
            strings[i] = strings[r];
            strings[r] = tmp;
        }
        singleQuickSort(strings, 0, i - 1);
        singleQuickSort(strings, i + 1, r);
    }

    /**
     * 插入排序
     * 将数组分为两个区域，排序区域和未排序区域，每一轮从未排序区域中取出第一个元素，插入到排序区域（需保证顺序）
     * 重复以上步骤，直到整个数组有序
     *
     * @param strings
     * @return
     */
    private String insertSort(String[] strings) {
        for (int i = 1; i < strings.length; i++) {
            if ((strings[i] + strings[i - 1]).compareTo(strings[i - 1] + strings[i]) > 0) {
                continue;
            }
            String tmp = strings[i];
            int flag = -1;
            for (int j = i - 1; j >= 0; j--) {
                if ((tmp + strings[j]).compareTo(strings[j] + tmp) <= 0) {
                    flag = j;
                    strings[j + 1] = strings[j];
                } else {
                    break;
                }
            }
            if (flag != -1) {
                strings[flag] = tmp;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    /**
     * 选择排序
     * 将数组分为两个子集，排序的和未排序的，每一轮从未排序的子集中选出最小的元素，放入排序子集
     * 重复以上步骤，直到整个数组有序
     *
     * @param strings
     * @return
     */
    private String selectionSort(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < strings.length; j++) {
                if ((strings[min] + strings[j]).compareTo(strings[j] + strings[min]) > 0) {
                    min = j;
                }
            }
            if (min != i) {
                String tmp = strings[i];
                strings[i] = strings[min];
                strings[min] = tmp;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }


    /**
     * 冒泡排序
     * 常规版
     *
     * @param strings
     * @return
     */
    private String bubbleSort(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            for (int j = 0; j < strings.length - 1 - i; j++) {
                if ((strings[j] + strings[j + 1]).compareTo(strings[j + 1] + strings[j]) > 0) {
                    String tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    /**
     * 冒泡排序
     * 优化版1
     *
     * @param strings
     * @return
     */
    private String bubbleSort2(String[] strings) {
        for (int i = 0; i < strings.length - 1; i++) {
            boolean flag = false;
            for (int j = 0; j < strings.length - 1 - i; j++) {
                if ((strings[j] + strings[j + 1]).compareTo(strings[j + 1] + strings[j]) > 0) {
                    String tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    /**
     * 冒泡排序
     * 优化版2
     *
     * @param strings
     * @return
     */
    private String bubbleSort3(String[] strings) {
        int n = strings.length - 1;
        int count = 0;
        while (true) {
            // 每轮冒泡时，最后一次交换索引可以作为下一轮冒泡的比较次数，
            // 如果这个值为零，表示整个数组有序，直接退出外层循环即可
            int last = 0;
            for (int j = 0; j < n; j++) {
                if ((strings[j] + strings[j + 1]).compareTo(strings[j + 1] + strings[j]) > 0) {
                    String tmp = strings[j];
                    strings[j] = strings[j + 1];
                    strings[j + 1] = tmp;
                    last = j;
                }
                count++;
            }
            n = last;
            if (n == 0) {
                break;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (String string : strings) {
            builder.append(string);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        String minNumber = solution45.minNumber(new int[]{1, 2, 3, 1});
        System.out.println(minNumber);
    }
}
