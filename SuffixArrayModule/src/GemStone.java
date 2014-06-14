import java.util.Scanner;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class GemStone {
    private static final int A_OFFSET = 97;
    private static final int Z_OFFSET = 122;
    private static final int SPACE_LENGTH = Z_OFFSET - A_OFFSET + 1;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int stringCount = Integer.parseInt(sc.nextLine());
        String[] testStrings = new String[stringCount];
        for(int i=0;i<stringCount;i++)
        {
            testStrings[i]=sc.nextLine();
        }
        System.out.println(countGemElement(testStrings));
    }

    public static int countGemElement(String[] strings) {

        int[] N = new int[SPACE_LENGTH];

        for(String currText : strings)
        {
            int[] currN = new int[SPACE_LENGTH];
            for(int i=0;i<currText.length();i++)
            {
                int currOffset = currText.charAt(i)-A_OFFSET;
                if(currN[currOffset]==0)
                {
                    N[currOffset]++;
                }
                currN[currOffset]++;
            }
        }

        int gemElementCount = 0;
        for(int i=0;i<N.length;i++)
        {
            if(N[i]==strings.length)
            {
                gemElementCount++;
            }
        }

        return gemElementCount;
    }
}
