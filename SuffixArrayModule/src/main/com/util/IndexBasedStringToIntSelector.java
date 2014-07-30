package com.util;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class IndexBasedStringToIntSelector implements Function<String[], Integer>
{
    private int index;

    public IndexBasedStringToIntSelector(int index)
    {
        this.index = index;
    }

    @Override
    public Integer valueOf(String[] arr) {
        return Integer.valueOf(arr[index]);
    }
}
