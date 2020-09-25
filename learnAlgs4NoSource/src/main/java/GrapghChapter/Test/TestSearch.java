package GrapghChapter.Test;

import GrapghChapter.DepthFirstSearch;
import GrapghChapter.Graph;
import common.In;
import common.StdOut;

import java.io.File;
import java.util.Iterator;
public class TestSearch {

    public static void main(String[] args) {
//        File f=new File("E:\\ProjectWorkspace\\IDEAWorkspace\\learnAlgs4NoSource\\algs4-data\\tinyG.txt");
        File f=new File("./algs4-data/tinyG.txt");
        Graph G =new Graph(new In(f));
        //1 9
        int s=Integer.parseInt("9");
        DepthFirstSearch search=new DepthFirstSearch(G,s);

        for(int v=0;v<G.V();v++) {
            if(search.marked(v)) {
                StdOut.print(v+" ");
            }
        }
        StdOut.println();

        if(search.count()!=G.V()) {
            StdOut.print("NOT ");
        }
        StdOut.println("Connected");

    }

}
