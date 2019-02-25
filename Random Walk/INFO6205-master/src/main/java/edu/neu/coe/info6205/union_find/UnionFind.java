/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.coe.info6205.union_find;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Payal Zanwar
 */
public class UnionFind implements UF{

    /**
     * @param args the command line arguments
     */
    private int[] Graph;
    private int NoOfcount;
    private int PairCount;
    public UnionFind(int N)
    {
        Graph = new int[N];
        for(int i=0; i<N;i++)
        {
            Graph[i]=i;
        System.out.print(Graph[i]+"\t");
        }
    }

   
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no of sites");
        int N = sc.nextInt();
        sc.nextLine();
        int result = count(N);
       
        System.out.println("\"Result :"+result);
    }

    public int components() {
        //To change body of generated methods, choose Tools | Templates.
      
        
        return NoOfcount;
    }
    
    public static int count(int N)
    {
            Random r = new Random();
            UnionFind uf = new UnionFind(N);
        for(int i=0;i<N;i++)
        {
            while((!(uf.Graph[0]==uf.Graph[i])))
            {
      
            int p = r.nextInt(N);
            int q = r.nextInt(N);
            if(p==q)
            {
            do
            {
            q= r.nextInt(N-1);
            }while(p==q);
            }
            System.out.println("\nRandom Pair : (" +p+","+q+")");
            uf.PairCount++;
            if(! uf.isConnected(p, q))
            {
            uf.connect(p, q);
            
            }
            }
    }
            System.out.println("Final Array:");
            for(int j=0;j<N;j++)
            System.out.print(uf.Graph[j]+"\t");
            System.out.println("\nNoOfConnections :"+uf.NoOfcount);
            System.out.println("\nPair Count :"+uf.PairCount);
            return uf.NoOfcount;
    }
    
    @Override
    public int find(int p) {
       
            p=Graph[p];
            return p;
    }

    @Override
    public void union(int p, int q) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            int pid = Graph[p];
            int qid = Graph[q];
            for (int i = 0; i < Graph.length; i++)
                {
                    if (Graph[i] == pid)
                        Graph[i] = qid;
        
                }
                NoOfcount++;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void connect(int p, int q) {
         union(p, q);
    }
    
}
