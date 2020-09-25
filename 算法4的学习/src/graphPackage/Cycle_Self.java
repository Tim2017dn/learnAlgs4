package graphPackage;

import edu.princeton.cs.algs4.*;

import java.io.File;

public class Cycle_Self {

    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> cycle;



    public Cycle_Self(Graph_Self G){
        if(hasSelfLoop(G)) return;
//        if(hasParalleEdges(G)) return;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        for(int v=0;v< G.V();v++){
            if(!marked[v]){
                dfs(G,-1,v);
            }
        }

    }

    private boolean hasSelfLoop(Graph_Self G) {
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                if (v == w) {
                    cycle = new Stack<>();
                    cycle.push(v);
                    cycle.push(v);
                    return true;
                }
            }

        }
        return false;
    }

    private boolean hasParalleEdges(Graph_Self G){
        marked = new boolean[G.V()];

        for(int v=0;v<G.V();v++){

            for(int w:G.adj(v)){
                if(marked[w]){
                    cycle = new Stack<Integer>();
                    cycle.push(v);
                    cycle.push(w);
                    cycle.push(v);
                }
                marked[w]=true;
            }

            for(int w:G.adj(v)){
                marked[w]=false;
            }

        }

        return true;
    }


    //
    private void dfs(Graph_Self G,int u,int v){
        marked[v] = true;
        for(int w:G.adj(v)){

            if(cycle!=null)return;

            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G, v, w);
            }
            else if(w!=u){
                cycle = new Stack<Integer>();
                for(int x=v; x!=w; x=edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }

        }
    }


    public boolean hasCycle(){
        return cycle!=null;
    }

    public Iterable<Integer> cycle(){
        return cycle;
    }


    public static void main(String[] args) {
//        In in = new In(args[0]);
//        File f=new File("E:\\ProjectWorkspace\\IDEAWorkspace\\算法4的学习\\src\\graphPackage\\tinyG.txt");
        File f=new File("E:\\ProjectWorkspace\\IDEAWorkspace\\算法4的学习\\src\\graphPackage\\text.txt");
        In i=new In(f);

        Graph_Self G = new Graph_Self(i);
        Cycle_Self finder = new Cycle_Self(G);
        if (finder.hasCycle()) {
            for (int v : finder.cycle()) {
                StdOut.print(v + " ");
            }
            StdOut.println();
        }
        else {
            StdOut.println("Graph is acyclic");
        }
    }

}
