import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Sidhavratha
 * Date: 2/10/13
 * Time: 11:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class FibonacciSumTest {

    @Test
    public void testFibonacciEvenSum(){

        /*Assert.assertEquals(0,FibonacciSum.bItr(1,0));
        Assert.assertEquals(2,FibonacciSum.bItr(2,0));
        Assert.assertEquals(10,FibonacciSum.bItr(8,0));
        Assert.assertEquals(44,FibonacciSum.bItr(100,0));
        Assert.assertEquals(798,FibonacciSum.bItr(1000,0));
*/
        int i=3;
        Assert.assertEquals(4,(i+=3)-2);
        Assert.assertEquals(6,i);

    }
}
