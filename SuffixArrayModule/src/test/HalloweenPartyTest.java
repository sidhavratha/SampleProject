import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class HalloweenPartyTest{

    @Test
    public void testHalloweenParty()
    {
        Assert.assertEquals(6, HalloweenParty.findBars(5));
        Assert.assertEquals(9, HalloweenParty.findBars(6));
        Assert.assertEquals(12, HalloweenParty.findBars(7));
        Assert.assertEquals(16, HalloweenParty.findBars(8));
    }

}
