package two.flow;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ArrayUtils {

    public static int[] quickSort(int[] array) {
        return quickSort1(array, 0, array.length - 1);
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
            swap(array[i], array[j]);
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

    private static void swap(int first, int second) {
        int temp = second;
        second = first;
        first = temp;
    }
}
