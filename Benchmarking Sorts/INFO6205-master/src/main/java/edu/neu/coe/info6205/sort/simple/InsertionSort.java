package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement insertionSort

        X temp;
        for(int i=from;i<to;i++)
        {
            for(int j=i;j>0;j--)
                if(less(xs[j],xs[j-1]))
                {
                  temp=xs[j];
                  xs[j]=xs[j-1];
                  xs[j-1]=temp;
                }
                else
                   break;   
    }
       
}
}