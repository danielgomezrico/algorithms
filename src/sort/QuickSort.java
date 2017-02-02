package sort;


import java.util.Arrays;

public class QuickSort {

    static void quickSort(int[] items, int left, int right) {
        if (left < right) {
            int lastPivotPosition = partitionLeft(items, left, right);

            quickSort(items, left, lastPivotPosition - 1);
            quickSort(items, lastPivotPosition + 1, right);
        }
    }

    private static int partition(int[] items, int left, int right) {
        int i = left - 1;
        int pivot = items[right];

        for (int j = left; j < right; j++) {
            if (items[j] <= pivot) {
                swap(items, ++i, j);
            }
        }

        swap(items, ++i, right);

        return i;
    }

    private static int partitionLeft(int[] items, int left, int right) {
        int i = left - 1;
        int pivot = items[left];

        for (int j = left; j < right; j++) {
            if (items[j] <= pivot) {
                swap(items, ++i, j);
            }
        }

        swap(items, ++i, right);

        return i;
    }

    static void quickSort(int[] items) {
        quickSort(items, 0, items.length - 1);
    }

    private static void swap(int[] items, int source, int target) {
        int sourceTemp = items[source];
        items[source] = items[target];
        items[target] = sourceTemp;
    }

    public static void main(String[] args) {
        int[] items = new int[]{5, 8, 1, 3, 7, 9, 2};

        QuickSort.quickSort(items);

        for (int item : items) {
            System.out.print(item + " ");
        }
    }
}
