import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sidhavratha on 1/3/14.
 */
public class LongTest {

    @Test
    public void testLong()
    {
        Map map = new HashMap();
        map.put(new Integer(1),new String("1"));
        map.get("1");
        Assert.assertEquals(Long.valueOf("100000000095167").toString(), "100000000095167");
        //throw new ClassCastException("java.lang.String");
    }

    @Test
    public void testTest(){
        System.out.println(0x10 + 10 + 010);
        System.out.println('a'%'b');
        System.out.println((+15));
        System.out.println((3 / 2 ));
        System.out.println((- -1-3 * 10 / 5-1));
        System.out.println(Integer.MAX_VALUE+":"+Integer.MIN_VALUE);


        //char a = '\u0061';
        //char 'a' = 'a';
        //char \u0061 = 'a';
        //ch\u0061r a = 'a';

        //ch'a'r a = 'a';
    }

    void compute(char[] ca, int... is) { }

}
