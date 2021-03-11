package SortingAlgorithm;
//时间复杂度:O(n2) 空间复杂度:O(1) 不稳定
public class SelectionSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,1,3,7,5,9};
        SelectionSort oj = new SelectionSort();
        oj.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
