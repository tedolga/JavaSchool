package two.essential;

import org.junit.Test;

import static org.junit.Assert.*;
import static two.essential.TextRepresenter.*;

/**
 * @author O. Tedikova
 * @version 1.0
 */
public class TextRepresenterTest {
    @Test
    public void testIsAcronym() {
        assertTrue(isAcronym("GUM"));
        assertFalse(isAcronym("gum"));
        assertFalse(isAcronym("gUM"));
        assertFalse(isAcronym("GUm"));
    }

    @Test
    public void testIsDelimiter() {
        assertTrue(isDelimiter(" "));
        assertTrue(isDelimiter("\t"));
        assertTrue(isDelimiter("\r"));
        assertTrue(isDelimiter("\n"));
        assertTrue(isDelimiter("."));
        assertFalse(isDelimiter(" h"));
        assertFalse(isDelimiter("m"));
    }

    @Test
    public void testToMixedCase() {
        assertEquals("A", toMixedCase("a"));
        assertEquals("Alba", toMixedCase("alba"));
        assertEquals("Alba", toMixedCase("aLBa"));
        assertEquals("A", toMixedCase("a"));
    }

    @Test
    public void testRepresentText() throws Exception {
        String sourceString = "BUBBLE.";
        assertEquals("BUBBLE.", representText(sourceString));
        sourceString = "bubble.";
        assertEquals("Bubble.", representText(sourceString));
        sourceString = " bubble.";
        assertEquals(" Bubble.", representText(sourceString));
        sourceString = " \tbubble.";
        assertEquals(" \tBubble.", representText(sourceString));
        sourceString = " \tbubble gUm.";
        assertEquals(" \tBubble gum.", representText(sourceString));
        sourceString = " \tbubble \ngUm.";
        assertEquals(" \tBubble \ngum.", representText(sourceString));
        sourceString = " \tbubble \nGUM.";
        assertEquals(" \tBubble \nGUM.", representText(sourceString));
        sourceString = " \tbubble \ngUM .";
        assertEquals(" \tBubble \ngum .", representText(sourceString));
        sourceString = " \tbubble \ngUM .yammy.";
        assertEquals(" \tBubble \ngum .Yammy.", representText(sourceString));
        sourceString = " \tbubble \ngUM .YAMMY.";
        assertEquals(" \tBubble \ngum .YAMMY.", representText(sourceString));
        sourceString = " \tbubble \ngUM . YAmMY.";
        assertEquals(" \tBubble \ngum . Yammy.", representText(sourceString));
        sourceString = " \tbubble \ngUM . \rYAmMY.";
        assertEquals(" \tBubble \ngum . \rYammy.", representText(sourceString));
        sourceString = " \tbubble \ngUM . \tYAMMY.";
        assertEquals(" \tBubble \ngum . \tYAMMY.", representText(sourceString));
    }
}
