package com.util;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class ValueFormula implements Formula
{
    private final int value;
    public ValueFormula(int value)
    {
        this.value = value;
    }
    @Override
    public double evaluate(Object day1, Object day2) {
        return value;
    }
}
