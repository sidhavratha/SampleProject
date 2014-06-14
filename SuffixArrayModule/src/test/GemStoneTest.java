import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class GemStoneTest {

    @Test
    public void testGemStone()
    {
        Assert.assertEquals(2,GemStone.countGemElement(new String[]{"abcdde","baccd","eeabg"}));
        Assert.assertEquals(0,GemStone.countGemElement(new String[]{"abcdde","baccd","eesfg"}));
        Assert.assertEquals(1,GemStone.countGemElement(new String[]{"abcdde","baccd","eesdz"}));
    }
}
