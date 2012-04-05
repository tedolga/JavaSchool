package two.flow;

/**
 * Provides several methods to sort an array of integers
 *
 * @author Tedikova O.
 * @version 1.0
 */
public class ArraySortUtils {
    /**
     * Implements quick sort of array of integers
     *
     * @param array to sort
     * @return sorted array
     */
    public static int[] quickSort(int[] array) {
        return quickSort1(array, 0, array.length - 1);
    }

    public static int[] mergeSort(int[] array) {
        mergeSort1(array, new int[array.length], 0, array.length);
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    private static void mergeSort1(int[] array, int[] buffer, int off, int len) {
        if (len > 1) {
            int firstLen = len / 2;
            int secondLen = len - firstLen;
            mergeSort1(array, buffer, off, firstLen);
            mergeSort1(array, buffer, firstLen + off, secondLen);
            for (int i = off, j = firstLen + off, k = 0; k < firstLen + secondLen; k++) {
                if (j >= secondLen + firstLen + off || (i < firstLen + off && array[i] <= array[j])) {
                    buffer[k] = array[i];
                    i++;
                } else {
                    buffer[k] = array[j];
                    j++;
                }
            }
            System.arraycopy(buffer, 0, array, off, firstLen + secondLen);
        }
    }


    private static int[] quickSort1(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int refElement = array[(end - start) / 2 + start];
        while (i < j) {
            while (array[i] < refElement) {
                i++;
            }
            while (array[j] > refElement) {
                j--;
            }
            swap(array, i, j);
            i++;
            j--;
        }
        if (i < end) {
            quickSort1(array, i, end);
        }
        if (j > start) {
            quickSort1(array, start, j);
        }
        return array;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
}
