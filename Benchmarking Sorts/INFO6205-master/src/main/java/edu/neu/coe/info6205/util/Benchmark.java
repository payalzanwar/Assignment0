/*
 * Copyright (c) 2018. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.simple.InsertionSort;
import edu.neu.coe.info6205.sort.simple.SelectionSort;
import edu.neu.coe.info6205.sort.simple.ShellSort;
import edu.neu.coe.info6205.sort.simple.Sort;
import java.util.Arrays;

import java.util.Random;
import java.util.function.Function;

/**
 * @param <T> The generic type T is that of the input to the function f which you will pass in to the constructor.
 */
public class Benchmark<T> {

    /**
     * Constructor for a Benchmark.
     * @param f a function of T => Void.
     * Function f is the function whose timing you want to measure. For example, you might create a function which sorts an array.
     * When you create a lambda defining f, you must return "null."
     */
    public Benchmark(Function<T, Void> f) {
        this.f = f;
    }

    /**
     * Run function f m times and return the average time in milliseconds.
     * @param t the value that will in turn be passed to function f.
     * @param m the number of times the function f will be called.
     * @return the average number of milliseconds taken for each run of function f.
     */
    public double run(T t, int m) {
        double ATentry,ATexit,Total=0,Avg;
       for(int i=0;i<m;i++)
        {
             ATentry = System.nanoTime();
             f.apply(t);
             ATexit = System.nanoTime();
             Total = Total + (ATexit - ATentry);
        }
             Avg = Total/m;
        

        return Avg;  // TODO
    }

    private final Function<T, Void> f;

    /**
     * Everything below this point has to do with a particular example of running a Benchmark.
     * In this case, we time three types of simple sort on a randome integer 
     * array of length 1000.
     * Each test is run 200 times.
     * @param args the command-line arguments, of which none are significant.
     */
    public static void main(String[] args) {
        Random random = new Random();
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        // TODO You need to apply doubling to n
        int n = 10000; // This is the size of the array
        
         
        
      for (int k = 0; k< 5; k++) {
        
            
            Integer[] array = new Integer[n];
            System.out.println(" Random array\n");
            for (int i = 0; i < n; i++) array[i] =  random.nextInt();
           
            
            benchmarkSort(array, "InsertionSort: "+n, new InsertionSort<>(), m);
            benchmarkSort(array, "SelectionSort: "+n, new SelectionSort<>(), m);
            
      
            System.out.println(" Partially sorted array\n");
           
            
            //for partially sorted array
              
            array[0] = (int)(Math.random () * 10) + 1;
            for (int a = 1; a < array.length; a++) {
            array[a] = array[a-1] + (int)(Math.random() * 12) - 2;}
            
            benchmarkSort(array, "InsertionSort: "+n, new InsertionSort<>(), m);
            benchmarkSort(array, "SelectionSort: "+n, new SelectionSort<>(), m);
           
            
            System.out.println(" Reverse sorted array\n");
            //for reverse sorted array
            
              
            for (int i = 0; i < n; i++) array[i] =  random.nextInt();
            Arrays.sort(array);
            
            for (int start = 0, end = n-1; start < end; start++, end--) {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
            }          
            benchmarkSort(array, "InsertionSort: "+n, new InsertionSort<>(), m);
            benchmarkSort(array, "SelectionSort: "+n, new SelectionSort<>(), m);

          
           //sorted array
            System.out.println(" Sorted array\n");
            
                
            for (int i = 0; i < n; i++) array[i] =  random.nextInt();
            Arrays.sort(array);
            benchmarkSort(array, "InsertionSort: "+n, new InsertionSort<>(), m);
            benchmarkSort(array, "SelectionSort: "+n, new SelectionSort<>(), m);
       
            n=n*2;
      }
        
    }

    private static void benchmarkSort(Integer[] array, String name, Sort<Integer> sorter, int m) {
        Function<Integer[], Void> sortFunction = (xs) -> {
            sorter.sort(xs);
            return null;
        };
        Benchmark<Integer[]> bm = new Benchmark<>(sortFunction);
        double x = bm.run(array, m);
        System.out.println(name + ": " + x + " millisecs");
    }
}
