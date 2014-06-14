import java.util.Scanner;

/**
 * Created by Sidhavratha on 26/5/14.
 */
public class UtopianTree {

    private static final Task MONSOON_TASK = new MonsoonTask();
    private static final Task SUMMER_TASK = new SummerTask();

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for(int i=0;i<testCaseCount;i++)
        {
            System.out.println(findHeight(sc.nextInt()));
        }
    }


    protected static long findHeight(int N) {
        return findHeight(N, 1, MONSOON_TASK);
    }

    private static long findHeight(int N,long height, Task task)
    {
        for(int i=0;i<N;i++)
        {
            height = task.execute(height);
            task=task.nextTask();
        }
        return height;
    }

    private interface Task
    {
        public long execute(long height);

        public Task nextTask();
    }

    private static class MonsoonTask implements Task
    {
        @Override
        public long execute(long height) {
            return height*2;
        }

        @Override
        public Task nextTask() {
            return SUMMER_TASK;
        }
    }

    private static class SummerTask implements Task
    {
        @Override
        public long execute(long height) {
            return height+1;
        }

        @Override
        public Task nextTask() {
            return MONSOON_TASK;
        }
    }
}
