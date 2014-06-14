/**
 * Created with IntelliJ IDEA.
 * User: Sidhavratha
 * Date: 18/8/13
 * Time: 1:25 AM
 * To change this template use File | Settings | File Templates.
 */
public class SuffixArray {

    public static int getOccurancesCount(String[] suffixArray, String text) {
        return getRwForTextOnSuffixArray(suffixArray,text)-
                getLwForTextOnSuffixArray(suffixArray,text)+1;
    }

    public static int getLwForTextOnSuffixArray(String[] suffixArray, String text) {
        int L=0,R=suffixArray.length-1;
        if(compare(text,suffixArray[0])<=0)
            R=0;
        else if(compare(text,suffixArray[suffixArray.length-1])>0)
            R=suffixArray.length;
        else
            while(R-L>1){
                int M=(R+L)/2;
                if(compare(text,suffixArray[M])<=0)
                    R=M;
                else
                    L=M;
            }
        return R;
    }

    public static int getRwForTextOnSuffixArray(String[] suffixArray, String text) {
        int L=0,R=suffixArray.length-1;
        if(compare(text,suffixArray[0])<=0)
            L=-1;
        else if(compare(text,suffixArray[suffixArray.length-1])>0)
            L=suffixArray.length-1;
        else
            while(R-L>1){
                int M=(R+L)/2;
                if(compare(text,suffixArray[M])>=0)
                    L=M;
                else
                    R=M;
            }
        return L;
    }

    public static int compare(String W, String Apos) {
        int diff=0,i;
        for(i=0;i<W.length();i++){
            if(Apos.length()<=i)
                return 1;
            diff=W.charAt(i)-Apos.charAt(i);
            if(diff!=0) return diff;
        }
        return 0;
    }

}
