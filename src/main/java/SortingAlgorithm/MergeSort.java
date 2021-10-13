package SortingAlgorithm;
//时间复杂度:O(nlog(n)) 空间复杂度:O(n) 稳定
//空间复杂度是O（n+log(n)），即为O(n)
public class MergeSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    private void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr,mid+1, high);
            merge(arr, low, mid, high);
        }
    }
    private void merge(int[] arr, int low, int mid, int high) {
        int[] tmp = new int[high-low+1];
        int i = low, j = mid + 1, k = 0;
        for (; i <= mid && j <= high; k++) {
            if (arr[i] <= arr[j]) {
                tmp[k] = arr[i++];
            } else {
                tmp[k] = arr[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = arr[i++];
        }
        while (j <= high) {
            tmp[k++] = arr[j++];
        }
        for (int l = 0; l < tmp.length; l++) {
            arr[low + l] = tmp[l];
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,1,3,7,5,9};
        MergeSort oj = new MergeSort();
        oj.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
