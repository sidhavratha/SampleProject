package com.util;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class SelectorFormula<T> implements Formula<T>
{
    private Side side;
    private Function<T, Integer> selector;

    public SelectorFormula(Side side, Function<T, Integer> selector)
    {
        this.side = side;
        this.selector = selector;
    }

    @Override
    public double evaluate(T day1, T day2) {
        if(side == Side.LEFT)
        {
            return selector.valueOf(day1);
        }
        else
        {
            return selector.valueOf(day2);
        }
    }
}
