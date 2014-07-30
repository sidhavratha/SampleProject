package com.util;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class FormulaHoldingFormula implements Formula
{
    private Formula formula;
    public FormulaHoldingFormula(Formula formula)
    {
        this.formula = formula;
    }

    @Override
    public double evaluate(Object day1, Object day2) {
        return formula.evaluate(day1, day2);
    }
}
