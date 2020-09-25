package common;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class t1 {

    public static void main(String[] args) {
        test2();
    }

    public static void test1(){
        Graph g = new Graph(4);
        g.addEdge(1, 0);
        g.addEdge(1, 2);
        g.addEdge(1,3);


//        for(int t:g.adj[3]){
//            System.out.print(t+" ");
//        }

        Path p = new Path(g, 3);
//        Iterable it =p.pathTo(0);
        for(int x:p.pathTo(1)){
            System.out.println(x);
        }

    }

    public static void test2(){
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2,3);
        g.addEdge(3, 0);

        Cycle c =new Cycle(g);
        Iterable<Integer> it = c.cycle();
        for(int x:it){
            System.out.println(x);
        }


    }

    static class Graph{
        public int E;
        public int V;
        public ArrayList<Integer>[] adj;

        public Graph(int v){
            this.V = v;
            this.E = 0;
            adj = new ArrayList[v];
            for(int i=0;i<V;i++){
                adj[i]=new ArrayList<>();
            }
        }

        public void addEdge(int v,int w){

            E++;
            adj[v].add(w);
            adj[w].add(v);
        }

    }


    static class Path{
        boolean[] marked;
        int[] edgeTo;
        int s;

        public Path(Graph G,int s){
            this.s = s;
            this.marked = new boolean[G.V];
            this.edgeTo = new int[G.V];
//            dfs(G,s);
            bfs(G, s);
        }

        public void bfs(Graph G,int s){
            Queue<Integer> queue = new LinkedList();
            queue.add(s);
            while(!queue.isEmpty()){
                Integer v = queue.poll();
                for(int w:G.adj[v]){
                    if(!marked[w]){
                        edgeTo[w] = v;
                        marked[w] = true;
                        queue.add(w);
                    }
                }

            }
        }


        public void dfs(Graph G ,int v){
            marked[v] = true;
            for(int w:G.adj[v]){
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    dfs(G,w);
                }
            }
        }

        public boolean hasPathTo(int v){
            return marked[v];
        }

        public Iterable<Integer> pathTo(int v){
            if(!marked[v]) return null;
            Deque stack = new LinkedList();
            for(int x=v;x!=s;x=edgeTo[x]){
                stack.push(x);
            }
            stack.push(s);
            return stack;

        }
    }

    static class Cycle{
        public boolean[] marked;
        public int[] edgeTo;
        public LinkedList Cycle;  // use it as stack

        public Cycle(Graph G){
            this.marked = new boolean[G.V];
            this.edgeTo = new int[G.V];

            for(int i=0;i<G.V;i++){
                if(!marked[i]){
                    dfs(G,-1,i);
                }

            }

        }

        public Iterable cycle(){
            return Cycle;
        }

        public void dfs(Graph G,int u,int v){
            // v represent current node
            // w represent from w to v ; if v is the first ,w = -1

            marked[v] = true;
            for(int w:G.adj[v]){
                if(Cycle!=null){
                    return;
                }

                if(!marked[w]){
                    edgeTo[w] = v;
                    dfs(G,v,w);
                }
                else if(w!=u){
                    // 下一个节点已经被访问，而且下一个节点不是上个节点
                    // 说明出现了环
                    Cycle = new LinkedList();
                    for(int x = v;x!=w;x=edgeTo[x]){
                        Cycle.push(x);
                    }
                    Cycle.push(w);
                    Cycle.push(v);

                }
            }
        }

    }


}
