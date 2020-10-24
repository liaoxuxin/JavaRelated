package SortingAlgorithm;

public class HeapSort {
    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;
            heapify(arr, 0, i);
        }
    }
    private void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }
    }
    private void heapify(int[] arr, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            int tmp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = tmp;
            heapify(arr, largest, len);
        }
    }
    public static void main(String[] args) {
        int[] arr = {4,1,3,7,5,9};
        HeapSort oj = new HeapSort();
        oj.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
