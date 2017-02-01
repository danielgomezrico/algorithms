package sort;


public class QuickSort {

    static void quickSort(int[] items, int left, int right) {
        if (left < right) {
            int lastPivotPosition = partition(items, left, right);

            quickSort(items, left, lastPivotPosition - 1);
            quickSort(items, lastPivotPosition + 1, right);
        }
    }

    private static int partition(int[] items, int left, int right) {
        int i = left - 1;
        int pivot = items[right];

        for (int j = left; j < right; j++) {
            if (items[j] <= pivot) {
                i++;
                swap(items, i, j);
            }
        }

        i++;
        swap(items, i, right);

        return i;
    }

    private static void swap(int[] items, int source, int target) {
        int sourceTemp = items[source];
        items[source] = items[target];
        items[target] = sourceTemp;
    }

    static void quickSort(int[] items) {
        quickSort(items, 0, items.length - 1);
    }

    public static void main(String[] args) {
        int[] items = new int[]{6, 1, 5, 3, 0, 9, 2, 90};

        QuickSort.quickSort(items);

        for (int item : items) {
            System.out.print(item + " ");
        }
    }
}
