package digraphPackage;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.io.File;
import java.util.Iterator;
import java.util.NoSuchElementException;

class AdjMatrixDigraph_Self {


    private int V;
    private int E;
    private boolean[][] adj;

    public AdjMatrixDigraph_Self(int V){
        if (V < 0) throw new RuntimeException("Number of vertices must be nonnegative");

        this.V = V;
        this.E = 0;
        this.adj=new boolean[V][V];

    }


    public AdjMatrixDigraph_Self(int V,int E){
        this(V);
        if(E<0) throw new RuntimeException("Number of edges must be nonnegative");
        if(E>V*V) throw new RuntimeException("too many edges");

        while(this.E != E){
            int v = StdRandom.uniform(V);
            int w = StdRandom.uniform(V);
            addEdge(v,w);
        }
    }

    public AdjMatrixDigraph_Self(In in){

        this.V = in.readInt();
        if(V < 0)throw new IllegalArgumentException("number of vertices in a Digraph");

        this.E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("number of edges in a Digraph must be nonnegative");

        this.adj=new boolean[V][V];

        for(int i=0;i<E;i++){
            int v=in.readInt();
            int w =in.readInt();
            addEdge(v,w);
        }

    }

    public int V() { return V; }
    public int E() { return E; }

    public void addEdge(int v,int w){
        if(!adj[v][w]){
            E++;
        }
        adj[v][w]=true;

    }

    public Iterable<Integer> adj(int v){
        return new AdjIterator(v);
    }

    private class AdjIterator implements Iterator<Integer>, Iterable<Integer>{
        private int v;
        private int w = 0;

        AdjIterator(int v){
            this.v = v;
        }

        @Override
        public Iterator<Integer> iterator() {
            return this;
        }

        @Override
        public boolean hasNext() {
            while(w < V){
                if(adj[v][w])return true;
                w++;
            }

            return false;
        }

        @Override
        public Integer next() {

            if(hasNext()) return w++;
            else
                throw new NoSuchElementException();
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }

    }



    public String toString() {
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();

        s.append(V + " " + E + NEWLINE);

        for (int v = 0; v < V; v++) {
            s.append(v + " ");
            for (int w : adj(v)) {
                s.append(w+" ");
            }
            s.append(NEWLINE);

        }
        return s.toString();
    }

    public static void main(String[] args) {
//        int V = 5;
//        int E = 5;
        File f=new File("src/algs4-data/tinyDG.txt");

        AdjMatrixDigraph_Self G = new  AdjMatrixDigraph_Self(new In(f));
        StdOut.println(G);


    }


}
