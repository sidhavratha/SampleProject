import java.util.Scanner;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class HalloweenParty {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for(int i=0;i<testCaseCount;i++)
        {
            System.out.println(findBars(sc.nextInt()));
        }
    }

    public static long findBars(double i) {
        double half = i/2;
        return (long) (Math.floor(half)*Math.ceil(half));
    }
}
