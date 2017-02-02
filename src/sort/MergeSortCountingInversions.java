package sort;

import java.util.Scanner;

public class MergeSortCountingInversions {
    public static class IntWrapper {
        private long count;

        public IntWrapper() {
            count = 0;
        }

        public long getCount() {
            return count;
        }

        public void plus(int n) {
            count += n;
        }
    }

    private static void merge(int[] items, int[] tempItems, int lowerIndex, int middle, int higherIndex, IntWrapper swapCount) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempItems[i] = items[i];
        }

        int k = lowerIndex;
        int i = lowerIndex;
        int j = middle + 1;

        while (i <= middle && j <= higherIndex) {
            if (tempItems[i] <= tempItems[j]) {
                items[k] = tempItems[i];
                i++;
            } else {
                items[k] = tempItems[j];
                j++;
                swapCount.plus(middle - i + 1);
            }
            k++;
        }

        while (i <= middle) {
            items[k] = tempItems[i];
            k++;
            i++;
        }
    }

    public static void mergesort(int[] items, int[] tempItems, int left, int right, IntWrapper swapCount) {
        if (left < right) {
            int middle = (right + left) / 2;

            mergesort(items, tempItems, left, middle, swapCount);
            mergesort(items, tempItems, middle + 1, right, swapCount);

            merge(items, tempItems, left, middle, right, swapCount);
        }
    }

    public static long countInversions(int[] arr) {
        IntWrapper swapCount = new IntWrapper();
        int[] tempArr = new int[arr.length];

        mergesort(arr, tempArr, 0, arr.length - 1, swapCount);

        return swapCount.getCount();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            int n = in.nextInt();
            int arr[] = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            System.out.println(countInversions(arr));
        }
    }


}
