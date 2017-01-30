package sort;

public class BubbleSort {

    private static int swapsCount; // SMELL: HORRIBLE!

    static int[] bubbleSort(int[] numbers) {
        int limit = numbers.length - 1;
        boolean isSorted = false;
        swapsCount = 0;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < limit; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int first = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = first;

                    swapsCount++;
                    isSorted = false;
                }
            }

            if (swapsCount == 0) break;
        }

        return numbers;
    }

    public static void main(String[] args) {
        int[] items = bubbleSort(new int[]{3, 2, 1});

        System.out.println(String.format("Array is sorted in %d swaps.", swapsCount));
        System.out.println(String.format("First Element: %d", items[0]));
        System.out.println(String.format("Last Element: %d", items[items.length - 1]));
    }
}
