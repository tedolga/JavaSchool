package two.flow;

/**
 * Provides several methods to sort arrays
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

    /**
     * Implements merge sort
     *
     * @param array to sort
     * @return sorted array
     */
    public static int[] mergeSort(int[] array) {
        mergeSort1(array, new int[array.length], 0, array.length);
        return array;
    }

    /**
     * Implements bubble sort
     *
     * @param array to sort
     * @return sorted array
     */
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

    /**
     * Sorts an array of integers by sharing it on 2 parts. Each part is ordered by the same algorithm recursively.
     * Then 2 sorted parts merges into one.
     *
     * @param array  to sort
     * @param buffer to merge 2 sorted parts
     * @param off    start index of the part which should be sorted
     * @param len    length of the part which should be sorted
     */
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

    /**
     * Sorts an array of integers by choosing reference element and moving all the elements which are less than
     * reference element to the right of it, and all the elements which are greater than it - to the left.
     * Then the left and right varieties processes recursively by the same algorithm
     *
     * @param array to sort
     * @param start first index of the part which should be sorted
     * @param end   last index of the part which should be sorted
     * @return sorted array
     */
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

    /**
     * Changes 2 elements of array by places
     *
     * @param array  array which contains elements to be swap
     * @param first  one of the elements to be swap
     * @param second one of the elements to be swap
     */
    private static void swap(int[] array, int first, int second) {
        int temp = array[second];
        array[second] = array[first];
        array[first] = temp;
    }
}
