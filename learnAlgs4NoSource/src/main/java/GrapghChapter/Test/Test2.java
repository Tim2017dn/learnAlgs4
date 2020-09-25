package GrapghChapter.Test;

import GrapghChapter.*;
import common.In;
import common.StdOut;

import java.io.File;

public class Test2 {


    public static void main(String[] args) {
        testPrim();
    }


    public static void testCycle(){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1,2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);

        Cycle c = new Cycle(g);
        System.out.println(c.hasCycle());
    }


    public static void testEdgeWeightedGraph(){
        File f = new File("./algs4-data/tinyEWG.txt");
        In in = new In(f);
        EdgeWeightedGraph graph = new EdgeWeightedGraph(in);
        StdOut.println(graph);

    }

    public static void testPrim(){
        File f = new File("./algs4-data/tinyEWG.txt");
        In in = new In(f);
        EdgeWeightedGraph graph = new EdgeWeightedGraph(in);
        LazyPrimMST mst = new LazyPrimMST(graph);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());

    }


}
