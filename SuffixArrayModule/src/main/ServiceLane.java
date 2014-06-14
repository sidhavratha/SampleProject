import java.util.Scanner;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class ServiceLane {

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        int testCaseCount = sc.nextInt();
        int[] N = new int[length];

        for(int i=0;i<length;i++)
        {
            N[i]=sc.nextInt();
        }

        for(int i=0;i<testCaseCount;i++)
        {
            System.out.println(findVehicleWidth(N,sc.nextInt(),sc.nextInt()));
        }
    }

    protected static int findVehicleWidth(int[] n, int i, int j) {
        int min = n[i];
        for(int k=i;k<=j;k++)
        {
            if(n[k]<min)
            {
                min=n[k];
            }
        }
        return min;
    }
}
