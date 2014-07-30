package com.util;

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
        /*
        10	20	30
        20	20	20


        R() = 6000
        R(0) = 12000 + (12000*16000/18000)(10666.67) + (12000*10666.7/16000)(8000) = 30666.67
        R(1) = 6000 + (6000*16000/18000)(5333.33) + (6000*5333.3/10000)(3200) = 14533.32
        R(2) = 4000 + (4000*10666.7/16000)(2666.67) + (4000*5333.3/10000)(2133.3) = 8799.97
        R(0,1) = 12000 + (4000) = 16000
        R(0,2) = 8000 + (8000/3) = 10666.7
        R(1,2) = 4000 + (4000/3)(1333.3) = 5333.3
        R(1,2,3) = 8000


        10,20
        30,20

        R() = 200 + ()
        R(0) = 600 + (150*3) = 1050
        R(1) = 200 + (150) = 350
        R(0,1) = 600



         */

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
                    Formula oldFormula = valueContainer.get(prevIndices.getLeft());
                    Formula newFormula = new OperatorFormula(
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
                    );

                    System.out.println(CombinationUtil.print(prevIndices.getLeft().getIndices())+"Old/New formula : " + oldFormula.evaluate(dataDelta, data1)+"/"+newFormula.evaluate(dataDelta, data1));

                    valueContainer.put(prevIndices.getLeft(),newFormula);
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
