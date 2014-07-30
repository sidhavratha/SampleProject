package com.util;

/**
 * Created by Sidhavratha on 29/7/14.
 */
public class Operators {

    public static final Operator ADD_OPERATOR = new Operator() {
        @Override
        public double apply(double leftValue, double rightValue) {
            return leftValue+rightValue;
        }
    };

    public static final Operator SUBTRACT_OPERATOR = new Operator() {
        @Override
        public double apply(double leftValue, double rightValue) {
            return leftValue-rightValue;
        }
    };

    public static final Operator MULTIPLY_OPERATOR = new Operator() {
        @Override
        public double apply(double leftValue, double rightValue) {
            return leftValue*rightValue;
        }
    };

    public static final Operator DIVIDE_OPERATOR = new Operator() {
        @Override
        public double apply(double leftValue, double rightValue) {
            return leftValue/rightValue;
        }
    };
}
