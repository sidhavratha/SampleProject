import java.util.Scanner;

/**
 * Created by Sidhavratha on 29/3/14.
 */
public class PrintCommand {

    public static void main(String args[])
    {
        System.out.println("Choose among options : \n 1. Add \n 2. Substract");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        try
        {
            int option = (Integer.parseInt(s));
            if(option==1)
            {
                System.out.println("Input two digits to add");
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a+b);
            }
            else if(option==2)
            {
                System.out.println("Input two digits to substract");
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a-b);
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.println("Wrong Option");
        }
    }

}
