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
        String sourceString = "BUBBLE.";
        Assert.assertEquals("BUBBLE.", TextRepresenter.representText(sourceString));
        sourceString = "bubble.";
        Assert.assertEquals("Bubble.", TextRepresenter.representText(sourceString));
        sourceString = " bubble.";
        Assert.assertEquals(" Bubble.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble.";
        Assert.assertEquals(" \tBubble.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble gUm.";
        Assert.assertEquals(" \tBubble gum.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUm.";
        Assert.assertEquals(" \tBubble \ngum.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \nGUM.";
        Assert.assertEquals(" \tBubble \nGUM.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUM .";
        Assert.assertEquals(" \tBubble \ngum .", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUM .yammy.";
        Assert.assertEquals(" \tBubble \ngum .Yammy.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUM .YAMMY";
        Assert.assertEquals(" \tBubble \ngum .YAMMY.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUM . YAmMY.";
        Assert.assertEquals(" \tBubble \ngum . Yammy.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUM . \rYAmMY.";
        Assert.assertEquals(" \tBubble \ngum . \rYammy.", TextRepresenter.representText(sourceString));
        sourceString = " \tbubble \ngUM . \tYAMMY.";
        Assert.assertEquals(" \tBubble \ngum . \tYAMMY.", TextRepresenter.representText(sourceString));
    }
}
