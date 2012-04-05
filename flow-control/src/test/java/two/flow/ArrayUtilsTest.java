package two.flow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ArrayUtilsTest {
    @Test
    public void testQuickSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, ArrayUtils.quickSort(new int[]{2}));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArrayUtils.quickSort(new int[]{3, 5, 6, 9, 2}));
        Assert.assertArrayEquals(new int[]{2, 7}, ArrayUtils.quickSort(new int[]{7, 2}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 5}, ArrayUtils.quickSort(new int[]{2, 2, 5, 2, 2}));
    }

    @Test
    public void testMergeSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, ArrayUtils.mergeSort(new int[]{2}));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArrayUtils.mergeSort(new int[]{3, 5, 6, 9, 2}));
        Assert.assertArrayEquals(new int[]{2, 7}, ArrayUtils.mergeSort(new int[]{7, 2}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 5}, ArrayUtils.mergeSort(new int[]{2, 2, 5, 2, 2}));
    }

    @Test
    public void testBubbleSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, ArrayUtils.bubbleSort(new int[]{2}));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArrayUtils.bubbleSort(new int[]{3, 5, 6, 9, 2}));
        Assert.assertArrayEquals(new int[]{2, 7}, ArrayUtils.bubbleSort(new int[]{7, 2}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 5}, ArrayUtils.bubbleSort(new int[]{2, 2, 5, 2, 2}));
    }

    @Test
    public void testSortingSpeed() {
        printSortingSpeed(10);
        printSortingSpeed(100);
        printSortingSpeed(1000);
        printSortingSpeed(10000);
        printSortingSpeed(100000);
    }

    private void printSortingSpeed(int elementsCount) {
        int[] testArray = new int[elementsCount];
        Random random = new Random();
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt();
        }
        StringBuilder results = new StringBuilder();
        results.append("Bubble sorting\n");
        results.append("---------------------------------------\n");
        results.append("Number of elements: ");
        results.append(testArray.length);
        results.append("\n");
        results.append("Work time in ms:");
        long startTime = System.currentTimeMillis();
        ArrayUtils.bubbleSort(testArray);
        long endTime = System.currentTimeMillis();
        results.append(endTime - startTime);
        results.append("\n");
        results.append("---------------------------------------\n");
        results.append("Quick sorting\n");
        results.append("---------------------------------------\n");
        results.append("Number of elements: ");
        results.append(testArray.length);
        results.append("\n");
        results.append("Work time in ms:");
        startTime = System.currentTimeMillis();
        ArrayUtils.quickSort(testArray);
        endTime = System.currentTimeMillis();
        results.append(endTime - startTime);
        results.append("\n");
        results.append("---------------------------------------\n");
        results.append("Merge sorting\n");
        results.append("---------------------------------------\n");
        results.append("Number of elements: ");
        results.append(testArray.length);
        results.append("\n");
        results.append("Work time in ms:");
        startTime = System.currentTimeMillis();
        ArrayUtils.mergeSort(testArray);
        endTime = System.currentTimeMillis();
        results.append(endTime - startTime);
        results.append("\n");
        results.append("---------------------------------------\n");
        System.out.println(results);
    }

}
