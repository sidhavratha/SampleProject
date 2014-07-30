import com.util.Indices;
import com.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sidhavratha on 28/7/14.
 */
public class CombinationUtil {

    public List<List<Pair<Indices, Indices>>> combine(int length)
    {
        List<List<Pair<Indices, Indices>>> combs = new ArrayList<List<Pair<Indices, Indices>>>();
        for(int i=0;i<=length;i++)
        {
            combs.add(combine(length, new int[i], new int[length - i]));
        }

        for(List<Pair<Indices, Indices>> pairsAtLevel : combs)
        {
            for(Pair<Indices, Indices> pair : pairsAtLevel)
            {
                System.out.println(print(pair.getLeft().getIndices(), pair.getRight().getIndices()));
            }
            System.out.println();
        }
        return combs;
    }

    private List<Pair<Indices, Indices>> combine(int length, int[] arrLeft, int[] arrRight)
    {
        List<Pair<int[], int[]>> combine = combine(length, arrLeft, arrRight, 0, length - 1, 0, arrLeft.length);
        List<Pair<Indices, Indices>> result = new ArrayList<Pair<Indices, Indices>>(combine.size());
        for(Pair<int[],int[]> pair : combine)
        {
            result.add(new Pair<Indices, Indices>(new Indices(pair.getLeft()), new Indices(pair.getRight())));
        }
        return result;
    }

    private List<Pair<int[], int[]>> combine(int length, int[] arrLeft, int[] arrRight, int start, int end, int index, int r)
    {
        List<Pair<int[], int[]>> combs = new ArrayList<Pair<int[], int[]>>();
        if(index==r)
        {
            combs.addAll(combine(length, arrRight, 0, length - 1, 0, arrRight.length, arrLeft));
            return combs;
        }
        for(int i=start;i<=end && end+1-i>=r-index;i++)
        {
            arrLeft[index]=i;
            combs.addAll(combine(length, arrLeft, arrRight, i + 1, end, index + 1, r));
        }
        return combs;
    }

    private List<Pair<int[], int[]>> combine(int length, int[] arrRight, int start, int end, int index, int r, int[] arrLeft)
    {
        List<Pair<int[], int[]>> combs = new ArrayList<Pair<int[], int[]>>();
        if(index==r)
        {
            for(int i : arrRight)
            {
                for(int j : arrLeft)
                {
                    if(i==j)
                        return new ArrayList<Pair<int[], int[]>>();
                }
            }
            combs.add(new Pair<int[], int[]>(clone(arrLeft), clone(arrRight)));
            return combs;
        }
        for(int i=start;i<=end && end+1-i>=r-index;i++)
        {
            arrRight[index]=i;
            combs.addAll(combine(length, arrRight, i + 1, end, index + 1, r, arrLeft));
        }
        return combs;
    }

    private int[] clone(int[] arr)
    {
        int[] arrCloned = new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            arrCloned[i]=arr[i];
        }
        return arrCloned;
    }

    public String print(int[] arrLeft, int[] arrRight) {
        return print(arrLeft)+"|"+print(arrRight);
    }

    public static String print(int[] data)
    {
        StringBuffer stringBuf = new StringBuffer();
        for(int i : data)
        {
            stringBuf.append(i + ", ");
        }
        return stringBuf.toString();
    }

}
