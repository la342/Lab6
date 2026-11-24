import java.util.Arrays;

/**
 * Demonstrates Quick Sort and Merge Sort algorithms.
 *
 * @author Your Name
 * @version 1.0
 */
public class Main {

    /**
     * Main method to test sorting algorithms.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        Integer[] array1 = {12, 13, 24, 10, 3, 6, 90, 70};
        int[] array2 = {2, 6, 3, 5, 1};

        // Sort using Quick Sort
        quickSort(array1, 0, array1.length - 1);

        System.out.println("Quick Sort:");
        System.out.println(Arrays.toString(array1));

        // Sort using Merge Sort
        mergeSort(array2, array2.length);

        System.out.println("Merge Sort:");
        System.out.println(Arrays.toString(array2));

        System.out.println("Is array2 sorted? " + isSorted(array2));
    }

    /**
     * Sorts an array using Quick Sort.
     *
     * @param arr the array to sort
     * @param low starting index
     * @param high ending index
     */
    public static void quickSort(Integer[] arr, int low, int high) {

        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low;
        int j = high;

        while (i <= j) {

            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * Swaps two elements in an array.
     *
     * @param array the array
     * @param x first index
     * @param y second index
     */
    public static void swap(Integer[] array, int x, int y) {

        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * Sorts an array using Merge Sort.
     *
     * @param a the array to sort
     * @param n number of elements
     */
    public static void mergeSort(int[] a, int n) {

        if (n < 2) {
            return;
        }

        int mid = n / 2;

        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }

        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }

    /**
     * Merges two sorted arrays.
     *
     * @param a destination array
     * @param l left array
     * @param r right array
     * @param left left array size
     * @param right right array size
     */
    public static void merge(
            int[] a, int[] l, int[] r, int left, int right) {

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left && j < right) {

            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }

        while (i < left) {
            a[k++] = l[i++];
        }

        while (j < right) {
            a[k++] = r[j++];
        }
    }

    /**
     * Checks whether an array is sorted.
     *
     * @param x the array to check
     * @return true if sorted, otherwise false
     */
    private static boolean isSorted(int[] x) {

        for (int i = 0; i < x.length - 1; i++) {

            if (x[i] > x[i + 1]) {
                return false;
            }
        }

        return true;
    }
}
