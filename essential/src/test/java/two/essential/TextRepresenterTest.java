package two.essential;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class TextRepresenterTest {
    @Test
    public void testRepresentText() throws Exception {
        String sourceString = ("bubble GuM. TASTY!\n");
        Assert.assertEquals("Bubble gum. TASTY!\n", TextRepresenter.representText(sourceString));

    }
}
