package three.generics;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author Tedikova O.
 * @version 1.0
 */
public class MinMaxFinderTest {
    @Test
    public void testMinMax() throws Exception {
        Holder[] holders = new Holder[5];
        holders[0] = new Holder<Integer>(4);
        holders[1] = new Holder<Integer>(2);
        holders[2] = new Holder<Integer>(6);
        holders[3] = new Holder<Integer>(3);
        holders[4] = new Holder<Integer>(4);
        MinMaxFinder<Integer> minMaxFinder = new MinMaxFinder<Integer>(holders);
        Assert.assertEquals((Object) 2, minMaxFinder.min());
        Assert.assertEquals((Object) 6, minMaxFinder.max());
    }

}
