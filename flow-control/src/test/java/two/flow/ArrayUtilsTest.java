package two.flow;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class ArrayUtilsTest {
    @Test
    public void testQuickSort() throws Exception {
        Assert.assertArrayEquals(new int[]{2, 3, 5, 6, 9}, ArrayUtils.quickSort(new int[]{3, 5, 6, 9, 2}));

    }
}
