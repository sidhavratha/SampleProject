package com.util;

import java.util.Arrays;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class Indices
{
    private final int[] indices;

    public Indices(int[] indices)
    {
        Arrays.sort(indices);
        this.indices = indices;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        for(int index : indices)
        {
            hash+=index*31;
        }
        return hash;
    }

    @Override
    public boolean equals(Object indices)
    {
        if(indices instanceof Indices)
        {
            Indices other = (Indices) indices;
            if(other.indices.length == this.indices.length)
            {
                for(int i=0;i<this.indices.length;i++)
                {
                    if(this.indices[i]!=other.indices[i])
                    {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public boolean contains(int index)
    {
        for(int i: indices)
        {
            if(i>index)
                return false;
            if(i==index)
                return true;
        }
        return false;
    }

    public int[] getIndices()
    {
        return this.indices;
    }
}
