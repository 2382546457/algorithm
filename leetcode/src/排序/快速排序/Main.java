package 排序.快速排序;

import 排序.Util;

import java.util.Arrays;

/**
 * @author : 小何
 * @Description :
 * @date : 2023-04-12 12:33
 */
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 6, 3, 10, 2};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        // 获取中间位置，中间排序好之后排序它的左边和右边
        // 原来的数组: 1, 8, 5, 6, 2, 10, 3
        // 经过这一步之后可能变为：2 1 (3) 6 5 8 10
        int mid = partition(arr, low, high);

        // 递归排序 2和1
        quickSort(arr, low, mid - 1);
        // 递归排序 6 5 8 10
        quickSort(arr, mid + 1, high);
    }

    /**
     * 以arr[high]为基准，将小于它的数放到它左边，将大于它的数放到右边，最后返回它应该在的下标
     */
    private static int partition(int[] arr, int low, int high) {
        int i = low;
        int p = arr[high];

        // 从low遍历到high，如果有比arr[high]小的，将它放在high位置左边
        // 例如，4 7 2 6 3 5
        // 此时arr[high] = 5
        // 换位后变为 2 4 3 5 7 6
        // (5两边的元素不一定有序，但一定遵守：左边比5小，右边比5大)
        for (int j = low; j < high; j++) {
            if (arr[j] < p) {
                // 交换arr[i]与arr[j]
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high);
        return i;
    }
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
