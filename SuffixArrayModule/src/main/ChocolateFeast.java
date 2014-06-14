import java.util.Scanner;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class ChocolateFeast {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCount = sc.nextInt();
        for(int i=0;i<testCount;i++)
        {
            System.out.println(countChocolates(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        }
    }

    public static int countChocolates(double N, double C, int M) {

        double validChocolates = Math.floor(N/C);
        double totalChocolates = validChocolates;

        double wrapperChocolates =0;
        double wrapperLeft = 0;
        while((wrapperChocolates = Math.floor((validChocolates+wrapperLeft)/M))>0)
        {
            wrapperLeft = validChocolates>=M?validChocolates%M:0;
            validChocolates = wrapperChocolates;
            totalChocolates+=wrapperChocolates;
        }
        return (int)totalChocolates;
    }
}
