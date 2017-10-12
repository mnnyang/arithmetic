import java.util.Random;

public class Main {


    public static void main(String[] args) {
//        int[] ints = {5, 2, 8, 3, 7, 9, 6, 1, 0, 4};
        int[] ints = buildInts();

        print(ints);
//        selectionSort(ints);//选择排序
//        bubbleSort(ints);//冒泡排序
//        insertionSort(ints);//插入排序
//        heapSort(ints);//堆排序
        quickSort(ints);//快速排序
        print(ints);
    }

    /**
     * 快速排序
     * 参考博客: http://developer.51cto.com/art/201403/430986.htm
     * 快速排序的最差时间复杂度和冒泡排序是一样的都是O(N2)，它的平均时间复杂度为O(NlogN)
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int temp = array[left];
        int i = left;
        int j = right;

        while (i != j) {
            //找到>temp的坐标
            while (i < j && array[j] <= temp) j--;
            //找到小于temp的坐标
            while (i < j && array[i] >= temp) i++;

            if (i < j) {
                swap(array, i, j);
            }
        }

        array[left] = array[i];
        array[i] = temp;

        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    /**
     * 堆排序
     */
    private static void heapSort(int[] array) {
        int length = array.length;
        int temp;

        for (int i = length / 2 - 1; i >= 0; i--) {
            heapAdjust(array, i, length);
        }

        for (int k = length - 1; k > 0; k--) {
            temp = array[k];
            array[k] = array[0];
            array[0] = temp;

            heapAdjust(array, 0, k);
        }
    }

    /**
     * 堆排序调用: 堆调整
     */
    private static void heapAdjust(int[] array, int parent, int end) {
        int temp = array[parent];

        for (int child = parent * 2 + 1; child < end; child = child + 1) {
            if (child + 1 < end && array[child] > array[child + 1]) {
                child++;
            }

            if (temp < array[child]) {
                break;
            }

            array[parent] = array[child];
            parent = child;
        }

        array[parent] = temp;
    }

    /**
     * 插入排序
     */
    public static void insertionSort(int[] array) {
        int k, temp;
        int length = array.length;

        for (int i = 1; i < length; i++) {
            temp = array[i];

            for (k = i - 1; k >= 0 && temp > array[k]; k--) {
                array[k + 1] = array[k];
            }
            array[k + 1] = temp;
        }
    }

    /**
     * 选择排序
     */
    private static void selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length; i++) {
            for (int k = i + 1; k < length; k++) {
                if (array[i] > array[k]) {
                    swap(array, i, k);
                }
            }
        }
    }

    /**
     * 冒泡排序
     */
    private static void bubbleSort(int[] array) {
        int length = array.length;

        for (int i = 1; i < length; i++) {
            for (int k = 0; k < length - i; k++) {
                if (array[k] > array[k + 1]) {
                    swap(array, k, k + 1);
                }
            }
        }
    }

    /**
     * 随机生成数组
     */
    private static int[] buildInts() {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = new Random().nextInt(10);
        }
        return ints;
    }

    /**
     * 交换
     */
    private static void swap(int[] array, int j, int i) {
        array[j] = array[j] ^ array[i];
        array[i] = array[j] ^ array[i];
        array[j] = array[j] ^ array[i];
    }

    private static void print(int[] intArray) {
        for (int i : intArray) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}
