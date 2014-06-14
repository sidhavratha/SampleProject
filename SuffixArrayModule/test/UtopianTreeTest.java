import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class UtopianTreeTest {

    @Test
    public void testUtopianTree()
    {
        Assert.assertEquals(1, UtopianTree.findHeight(0));
        Assert.assertEquals(2, UtopianTree.findHeight(1));
        Assert.assertEquals(3, UtopianTree.findHeight(2));
        Assert.assertEquals(6, UtopianTree.findHeight(3));
        Assert.assertEquals(7, UtopianTree.findHeight(4));
        Assert.assertEquals(14, UtopianTree.findHeight(5));
    }

}
