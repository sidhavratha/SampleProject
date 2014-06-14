import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class ChocolateFeastTest {

    @Test
    public void testChocolateFeast()
    {
        Assert.assertEquals(6, ChocolateFeast.countChocolates(10,2,5));
        Assert.assertEquals(3, ChocolateFeast.countChocolates(12,4,4));
        Assert.assertEquals(5, ChocolateFeast.countChocolates(6,2,2));
    }
}
