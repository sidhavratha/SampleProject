import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created with IntelliJ IDEA.
 * User: Sidhavratha
 * Date: 25/8/13
 * Time: 3:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PairsTest {

    @Test
    public void testPairsSimple(){
        String input = "5 2\n1 5 3 4 2";
        String expected = "3";

        ByteArrayOutputStream baos = setUp(input);

        Pairs.main(null);

        Assert.assertEquals(expected, baos.toString());

    }

    @Test
    public void testPairsMedium(){
        String input = "10 1\n363374326 364147530 61825163 1073065718 1281246024 1399469912 428047635 491595254 879792181 1069262793";
        String expected = "0";

        ByteArrayOutputStream baos = setUp(input);

        Pairs.main(null);

        Assert.assertEquals(expected, baos.toString());

    }
    private ByteArrayOutputStream setUp(String input){
        // set stdin
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // set stdout
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        return baos;
    }


}
