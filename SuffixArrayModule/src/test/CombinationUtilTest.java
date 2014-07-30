import com.util.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sidhavratha on 28/7/14.
 */
public class CombinationUtilTest {

    @Test
    public void testCombinationUtil()
    {
        String[] data1 = new String[]{"10","20","30"};
        String[] data2 = new String[]{"30","40","50"};
        String[] dataDelta = new String[data1.length];
        Function<String[], Integer>[] selectors = new Function[]{
            new IndexBasedStringToIntSelector(0),
                    new IndexBasedStringToIntSelector(1),
                    new IndexBasedStringToIntSelector(2)};

        /*String[] data1 = new String[]{"10","20"};
        String[] data2 = new String[]{"40","40"};
        String[] dataDelta = new String[data1.length];
        Function<String[], Integer>[] selectors = new Function[]{
                new IndexBasedStringToIntSelector(0),
                new IndexBasedStringToIntSelector(1)};
        */

        for(int i=0;i<data1.length;i++)
        {
            dataDelta[i] = String.valueOf(Integer.valueOf(data2[i])-Integer.valueOf(data1[i]));
        }



        List<List<Pair<Indices, Indices>>> combinations = new CombinationUtil().combine(selectors.length);

        Map<Indices, Formula> valueContainer = new HashMap<Indices, Formula>();

        for(List<Pair<Indices, Indices>> combinationAtLevel : combinations)
        {
            for(Pair<Indices, Indices> combinationPair : combinationAtLevel)
            {
                Formula valueFormula = new ValueFormula(1);
                for(int leftIndex : combinationPair.getLeft().getIndices())
                {
                    valueFormula = new OperatorFormula(valueFormula,
                            Operators.MULTIPLY_OPERATOR,
                            new SelectorFormula<String[]>(
                                    Side.LEFT,
                                    selectors[leftIndex]
                            ));
                }
                for(int rightIndex : combinationPair.getRight().getIndices())
                {
                    valueFormula = new OperatorFormula(valueFormula,
                            Operators.MULTIPLY_OPERATOR,
                            new SelectorFormula<String[]>(
                                    Side.RIGHT,
                                    selectors[rightIndex]
                            ));
                }
                valueContainer.put(combinationPair.getLeft(), valueFormula);
            }
        }

        for(Indices indices : valueContainer.keySet())
        {
            System.out.println(CombinationUtil.print(indices.getIndices())+" : "+valueContainer.get(indices).evaluate(dataDelta, data1));
        }

        /*
        First initialization completed
        Next step is to attribute the values
         */

        for(int i=combinations.size()-1;i>0;i--)
        {
            List<Pair<Indices, Indices>> combinationAtCurrentLevel = combinations.get(i);
            List<Pair<Indices, Indices>> combinationAtPrevLevel = combinations.get(i-1);

            for(Pair<Indices, Indices> currentCombinationPair : combinationAtCurrentLevel)
            {
                List<Pair<Indices, Indices>> allPrevIndicesElligibleForAttribution = getAllIndicesContainingAtLeastOneIndex(currentCombinationPair.getLeft(), combinationAtPrevLevel);
                Formula sumOfAll = new ValueFormula(0);
                for(Pair<Indices, Indices> prevIndices : allPrevIndicesElligibleForAttribution)
                {
                    sumOfAll = new OperatorFormula(
                            sumOfAll,
                            Operators.ADD_OPERATOR,
                            new FormulaHoldingFormula(valueContainer.get(prevIndices.getLeft()))
                    );
                }

                for(Pair<Indices, Indices> prevIndices : allPrevIndicesElligibleForAttribution)
                {
                    valueContainer.put(prevIndices.getLeft(),
                            new OperatorFormula(
                                    valueContainer.get(prevIndices.getLeft()),
                                    Operators.ADD_OPERATOR,
                                    new OperatorFormula(
                                            valueContainer.get(currentCombinationPair.getLeft()),
                                            Operators.MULTIPLY_OPERATOR,
                                            new OperatorFormula(
                                                    valueContainer.get(prevIndices.getLeft()),
                                                    Operators.DIVIDE_OPERATOR,
                                                    sumOfAll
                                            )
                                    )
                            )
                    );
                }
            }



        }

        for(Indices indices : valueContainer.keySet())
        {
            System.out.println(CombinationUtil.print(indices.getIndices())+" : "+valueContainer.get(indices).evaluate(dataDelta, data1));
        }

    }

    private List<Pair<Indices, Indices>> getAllIndicesContainingAtLeastOneIndex(Indices currentIndices, List<Pair<Indices, Indices>> prevCombinationPairs)
    {
        List<Pair<Indices, Indices>> resultList = new ArrayList<Pair<Indices, Indices>>();
        for(Pair<Indices, Indices> combinationPair : prevCombinationPairs)
        {
            for(int index : currentIndices.getIndices())
            {
                if(combinationPair.getLeft().contains(index))
                {
                    resultList.add(combinationPair);
                    break;
                }
            }
        }
        return resultList;
    }



}
