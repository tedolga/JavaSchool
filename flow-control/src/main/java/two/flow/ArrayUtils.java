package two.flow;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ArrayUtils {

    public static int[] quickSort(int[] array) {
        return quickSort1(array, 0, array.length - 1);
    }

    public static int[] mergeSort(int[] array) {
        return mergeSort1(array, 0, array.length);
    }

    private static int[] mergeSort1(int[] array, int off, int len) {
        if (array.length > 1) {
            int splitIndex = array.length / 2;
            int[] firstArray = new int[splitIndex];
            System.arraycopy(array, 0, firstArray, 0, splitIndex);
            int[] secondArray = new int[array.length - splitIndex];
            System.arraycopy(array, splitIndex, secondArray, 0, array.length - splitIndex);
            firstArray = mergeSort1(firstArray, 0, firstArray.length);
            secondArray = mergeSort1(secondArray, 0, secondArray.length);
            int[] resultArray = new int[firstArray.length + secondArray.length];
            for (int i = 0, j = 0, k = 0; k < resultArray.length; k++) {
                if (j >= secondArray.length || (i < firstArray.length && firstArray[i] <= secondArray[j])) {
                    resultArray[k] = firstArray[i];
                    i++;
                } else {
                    resultArray[k] = secondArray[j];
                    j++;
                }
            }
            return resultArray;
        } else {
            return array;
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
