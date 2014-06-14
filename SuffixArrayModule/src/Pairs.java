import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Sidhavratha
 * Date: 25/8/13
 * Time: 3:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Pairs {
    public static void main(String[] s) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] numbers = new int[N];
        for(int i=0;i<N;i++){
            numbers[i]=sc.nextInt();
        }
        Arrays.sort(numbers);
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                if(numbers[j]-numbers[i]==K)
                    count++;
                else if(numbers[j]-numbers[i]>K)
                    break;
            }
        }

        System.out.print(count);
    }
}
