package two.flow;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ArraySortUtilsTest {
    @Test
    public void testQuickSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, ArraySortUtils.quickSort(new int[]{2}));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArraySortUtils.quickSort(new int[]{3, 5, 6, 9, 2}));
        Assert.assertArrayEquals(new int[]{2, 7}, ArraySortUtils.quickSort(new int[]{7, 2}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 5}, ArraySortUtils.quickSort(new int[]{2, 2, 5, 2, 2}));
    }

    @Test
    public void testMergeSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, ArraySortUtils.mergeSort(new int[]{2}));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArraySortUtils.mergeSort(new int[]{3, 5, 6, 9, 2}));
        Assert.assertArrayEquals(new int[]{2, 7}, ArraySortUtils.mergeSort(new int[]{7, 2}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 5}, ArraySortUtils.mergeSort(new int[]{2, 2, 5, 2, 2}));
    }

    @Test
    public void testBubbleSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2}, ArraySortUtils.bubbleSort(new int[]{2}));
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArraySortUtils.bubbleSort(new int[]{3, 5, 6, 9, 2}));
        Assert.assertArrayEquals(new int[]{2, 7}, ArraySortUtils.bubbleSort(new int[]{7, 2}));
        Assert.assertArrayEquals(new int[]{2, 2, 2, 2, 5}, ArraySortUtils.bubbleSort(new int[]{2, 2, 5, 2, 2}));
    }

    @Test
    public void testSortingSpeedRandom() {
        System.out.println("----------------------Random elements-----------------------------");
        printSortingSpeedRandom(10000);
        printSortingSpeedRandom(100000);
    }

    private void printSortingSpeedRandom(int elementsCount) {
        int[] testArray = new int[elementsCount];
        Random random = new Random();
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt();
        }
        printBubbleResults(testArray);
        printQuickResults(testArray);
        printMergeResults(testArray);
    }

    private void printBubbleResults(int[] testArray) {
        StringBuilder results = new StringBuilder();
        results.append("Bubble sorting\n");
        results.append("---------------------------------------\n");
        results.append("Number of elements: ");
        results.append(testArray.length);
        results.append("\n");
        results.append("Work time in ms:");
        long startTime = System.currentTimeMillis();
        ArraySortUtils.bubbleSort(testArray);
        long endTime = System.currentTimeMillis();
        results.append(endTime - startTime);
        results.append("\n");
        results.append("---------------------------------------\n");
        System.out.println(results);
    }

    private void printQuickResults(int[] testArray) {
        StringBuilder results = new StringBuilder();
        results.append("---------------------------------------\n");
        results.append("Quick sorting\n");
        results.append("---------------------------------------\n");
        results.append("Number of elements: ");
        results.append(testArray.length);
        results.append("\n");
        results.append("Work time in ms:");
        long startTime = System.currentTimeMillis();
        ArraySortUtils.quickSort(testArray);
        long endTime = System.currentTimeMillis();
        results.append(endTime - startTime);
        results.append("\n");
        results.append("---------------------------------------\n");
        System.out.println(results);
    }

    private void printMergeResults(int[] testArray) {
        StringBuilder results = new StringBuilder();
        printBubbleResults(testArray);
        printQuickResults(testArray);
        results.append("Merge sorting\n");
        results.append("---------------------------------------\n");
        results.append("Number of elements: ");
        results.append(testArray.length);
        results.append("\n");
        results.append("Work time in ms:");
        long startTime = System.currentTimeMillis();
        ArraySortUtils.mergeSort(testArray);
        long endTime = System.currentTimeMillis();
        results.append(endTime - startTime);
        results.append("\n");
        results.append("---------------------------------------\n");
        System.out.println(results);
    }

}
