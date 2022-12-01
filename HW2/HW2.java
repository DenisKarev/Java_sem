package HW2;

import java.util.Random;

public class HW2 {
    public static void fillArrayInts(int[] array, int low, int high) {
        /*
         * fills array with integers from [low, high)
         */
        Random r = new Random();
        if (high < low) {
            int temp = low;
            low = high;
            high = temp;
        }
        int range = high - low;
        System.out.println(range);
        for (int i = 0; i < array.length; i++) {
            array[i] = r.nextInt(range)+low;
        }
    }

    public static void printArrayInts(int[] array) {
        System.out.printf("[ ");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.printf("%d, ", array[i]);
        }
        System.out.printf("%d ", array[array.length - 1]);
        System.out.printf("]\n");
    }

    public static void sortMerge(int[] array, int start, int finish) {
        /* Merge sorts array
         * args: array, start point of sort, end point of sort 
         */
        if (start < finish) {
            int center = (finish + start) / 2;
            // System.out.printf("%d %d %d\n", start, center, finish);

            sortMerge(array, start, center);
            sortMerge(array, center + 1, finish);

            mergeArrays(array, start, center, finish);
        }
    }

    private static void mergeArrays(int[] array, int leftP, int middle, int rightP) {
        // two buffer arrays
        int leftSize = middle - leftP +1;      // +1
        int rightSize = rightP - middle;
        int[] leftArrayPart = new int[leftSize];
        int[] rightArrayPart = new int[rightSize];

        // copy left part to sort to buffer array
        for (int i = 0; i < leftSize; i++) leftArrayPart[i] = array[leftP + i];
        // copy right part to sort to buffer array
        for (int j = 0; j < rightSize; j++) rightArrayPart[j] = array[middle + 1 + j]; // +1

        int li = 0;
        int ri = 0;
        int start = leftP;

        // merging equal part of both arrays
        while (li < leftSize && ri < rightSize) {
            if (leftArrayPart[li] <= rightArrayPart[ri]) {
                array[start] = leftArrayPart[li];
                li++;
            } else {
                array[start] = rightArrayPart[ri];
                ri++;
            }
            start++;
        }

        // if one of the arrays is smaller then the other -> copy remainder
        while (li < leftSize) {
            array[start] = leftArrayPart[li];
            li++;
            start++;
        }

        while (ri < rightSize) {
            array[start] = rightArrayPart[ri];
            ri++;
            start++;
        }
    }
}
