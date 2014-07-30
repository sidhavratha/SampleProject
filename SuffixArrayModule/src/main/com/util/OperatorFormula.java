package com.util;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class OperatorFormula implements Formula
{
    private Formula left;
    private Operator op;
    private Formula right;
    public OperatorFormula(Formula left, Operator op, Formula right)
    {
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public double evaluate(Object day1, Object day2) {
        return op.apply(left.evaluate(day1, day2), right.evaluate(day1, day2));
    }
}
