package graphPackage;


import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LazyPrimMST;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class TestCC {
    public static void main(String[] args) {
        File f=new File("E:\\ProjectWorkspace\\eclipse-2019\\算法第4版\\src\\GraphPackage\\tinyG.txt");
        Graph_Self G =new Graph_Self(new In(f));


        CC_Self cc=new CC_Self(G);
        int M =cc.count();
        StdOut.println(M+" compoments");

        Bag<Integer>[] components;
        components = (Bag<Integer>[]) new Bag[M];
        for(int i=0;i<M;i++) {
            components[i] = new Bag<Integer>();
        }

        for(int v=0;v<G.V();v++){
            components[cc.id(v)].add(v);
        }

        for(int i=0;i<M;i++){
            for(int v:components[i]){
                StdOut.print(v+" ");
            }
            StdOut.println();
        }


    }
}
