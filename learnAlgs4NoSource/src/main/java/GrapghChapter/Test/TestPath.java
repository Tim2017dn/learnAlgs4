package GrapghChapter.Test;

import GrapghChapter.DepthFirstPaths;
import GrapghChapter.DepthFirstSearch;
import GrapghChapter.Graph;
import common.In;
import common.StdOut;

import java.io.File;

public class TestPath {
    public static void main(String[] args) {
        File f=new File("./algs4-data/tinyG.txt");
        In in = new In(f);
        Graph G = new Graph(in);
        int s = Integer.parseInt("1");
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }

}
