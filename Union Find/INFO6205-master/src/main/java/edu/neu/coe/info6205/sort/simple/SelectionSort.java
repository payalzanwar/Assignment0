package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {

    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement selection sort
        int j,min;
        X temp;
        for(int i=from;i<to-1;i++)
        {
            min=i;
            for(j=i+1;j<to;j++)
            {
                if(xs[j].compareTo(xs[min])<0)
                min=j;
            }  
                temp=xs[min];
                xs[min]=xs[i];
                xs[i]=temp;
                
           
        }
         
         
        
    }
}
