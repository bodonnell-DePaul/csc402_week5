package csc402.week5;

import java.util.Arrays;

public class LinearithmicTime {
    public static void main(String[] args) {
        int[] array = {5, 3, 1, 4, 2};
        String[] arrayString = {"Brian", "Alice", "David", "Cashew", "Eve", "Walnut"};
        mergeSort(arrayString, 0, arrayString.length - 1);
        System.out.println(Arrays.toString(arrayString));
    }

    public static void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Recursively sort the left and right halves
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);

            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    public static void merge(String[] array, int left, int mid, int right) {
        // Find sizes of two subarrays to be merged
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }

        // Merge the temporary arrays

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarray array
        int k = left;
        while (i < n1 && j < n2) {
            int val = leftArray[i].compareTo(rightArray[j]);
            //int val = rightArray[i].compareTo(leftArray[j]);
            //if (leftArray[i] <= rightArray[j])
            if (val <= 0) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements of leftArray[] if any
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements of rightArray[] if any
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }
}