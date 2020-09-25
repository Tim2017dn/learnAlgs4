package graphPackage;

import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreadthFirstPaths_Self {

	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public BreadthFirstPaths_Self(Graph G,int s) {
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		this.s=s;
		bfs(G,s);
		
		
	}
	
	
	public void bfs(Graph G,int s) {
		
		Queue<Integer> queue=new Queue();
		marked[s]=true;
		queue.enqueue(s);
		
		while(queue.isEmpty()) {
			int  v = queue.dequeue();
			for(int w : G.adj(v)) {
				if(!marked[w]) {
					edgeTo[w]=v;
					marked[w]=true;
					queue.enqueue(w);
				}
			}		
				
		}
		
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		
		Stack<Integer> path=new Stack();
		
		if(!hasPathTo(v)) {return null;}
		for(int x=v;x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
		
	}
	
	
}
