import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: Sidhavratha
 * Date: 18/8/13
 * Time: 1:03 AM
 * To change this template use File | Settings | File Templates.
 */
public class SuffixArrayTest {

    @Test
    public void testCompare(){
        assertTrue(SuffixArray.compare("abc", "ab") > 0);
        assertTrue(SuffixArray.compare("a", "bc") < 0);
        assertTrue(SuffixArray.compare("ab","abcd")==0);
        assertTrue(SuffixArray.compare("ab","ab")==0);
        assertTrue(SuffixArray.compare("z","ab")>0);
        assertTrue(SuffixArray.compare("amam","am")>0);
    }

    /*
    abramam

    m
    am
    mam
    amam
    ramam
    bramam
    abramam

    abramam
    am
    amam
    bramam
    m
    mam
    ramam
     */
    @Test
    public void testLwForTextOnSuffixArray(){
        String[] suffixArray = new String[]{"abramam","am","amam","bramam","m","mam","ramam"};
        assertEquals(1,SuffixArray.getLwForTextOnSuffixArray(suffixArray,"am"));
        assertEquals(4,SuffixArray.getLwForTextOnSuffixArray(suffixArray,"ham"));
        assertEquals(4,SuffixArray.getLwForTextOnSuffixArray(suffixArray,"m"));
        assertEquals(7,SuffixArray.getLwForTextOnSuffixArray(suffixArray,"z"));
        assertEquals(0,SuffixArray.getLwForTextOnSuffixArray(suffixArray,"a"));
        assertEquals(5,SuffixArray.getLwForTextOnSuffixArray(suffixArray,"mam"));
    }

    @Test
    public void testRwForTextOnSuffixArray(){
        String[] suffixArray = new String[]{"abramam","am","amam","bramam","m","mam","ramam"};
        assertEquals(2,SuffixArray.getRwForTextOnSuffixArray(suffixArray,"am"));
        assertEquals(5,SuffixArray.getRwForTextOnSuffixArray(suffixArray,"m"));
        assertEquals(3,SuffixArray.getRwForTextOnSuffixArray(suffixArray,"ham"));
        assertEquals(5,SuffixArray.getRwForTextOnSuffixArray(suffixArray,"mam"));
    }

    @Test
    public void testOccurancesCountForTextOnSuffixArray(){
        String[] suffixArray = new String[]{"abramam","am","amam","bramam","m","mam","ramam"};
        assertEquals(2,SuffixArray.getOccurancesCount(suffixArray,"am"));
        assertEquals(2,SuffixArray.getOccurancesCount(suffixArray,"m"));
        assertEquals(1,SuffixArray.getOccurancesCount(suffixArray,"mam"));
        assertEquals(0,SuffixArray.getOccurancesCount(suffixArray,"ham"));
    }

}
