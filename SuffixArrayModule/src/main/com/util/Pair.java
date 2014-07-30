package com.util;

/**
* Created by Sidhavratha on 29/7/14.
*/
public class Pair<T,V>
{
    private T t;
    private V v;
    public Pair(T left, V right)
    {
        this.t = left;
        this.v = right;
    }

    public T getLeft(){return this.t;}
    public V getRight(){return this.v;}
}
