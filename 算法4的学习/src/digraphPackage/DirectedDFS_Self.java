package digraphPackage;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class DirectedDFS_Self {

    private boolean[] marked;
    private int count;

    public DirectedDFS_Self(Digraph_Self G,int s){
        marked = new boolean[G.V()];
        validateVertex(s);
        dfs(G,s);
    }

    public DirectedDFS_Self(Digraph_Self G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        validateVertices(sources);
        for (int v : sources) {
            if (!marked[v]) dfs(G, v);
        }
    }

    private void dfs(Digraph_Self G,int v){
        count++;
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!marked[w])
                dfs(G, w);
        }

    }

    private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertices(Iterable<Integer> vertices) {
        if (vertices == null) {
            throw new IllegalArgumentException("argument is null");
        }
        int V = marked.length;
        for (Integer v : vertices) {
            if (v == null) {
                throw new IllegalArgumentException("vertex is null");
            }
            validateVertex(v);
        }
    }

    public boolean marked(int v) {
        validateVertex(v);
        return marked[v];
    }


    public int count() {
        return count;
    }

    public static void main(String[] args) {

        // read in digraph from command-line argument
        File f = new File("src/algs4-data/tinyDG.txt");
        Digraph_Self G = new Digraph_Self(new In(f));


        // read in sources from command-line arguments
        Bag<Integer> sources = new Bag<Integer>();
//        for (int i = 1; i < args.length; i++) {
//            int s = Integer.parseInt(args[i]);
            sources.add(2);
//        }

        // multiple-source reachability
        DirectedDFS_Self dfs = new DirectedDFS_Self(G, sources);

        // print out vertices reachable from sources
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) StdOut.print(v + " ");
        }
        StdOut.println();
    }
}
