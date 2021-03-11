package SortingAlgorithm;
//时间复杂度:O(nlog(n)) 空间复杂度:O(logn) 不稳定
public class QuickSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
    }
    private int partition(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }
    public static void main(String[] args) {
        int[] arr = {4,1,3,7,5,9};
        QuickSort oj = new QuickSort();
        oj.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
