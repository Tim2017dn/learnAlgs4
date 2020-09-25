package graphPackage;

import edu.princeton.cs.algs4.Stack;

public class DepthFirstPaths {
	
	boolean[] marked;
	int[] edgeTo;
	final int s;
	
	public DepthFirstPaths(Graph_Self G,int s) {
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		this.s=s;
		
		
	}
	
	public void dfs(Graph_Self G,int v) {
		marked[v]=true;
		for(int w: G.adj(v)) {
			if(!marked[w]) {
				edgeTo[w]=v;
				dfs(G, w);
			}
		}
	}
	
	public boolean hasPathTo(int v) {
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){
		if(!hasPathTo(v)) {return null;}
		Stack<Integer> path = new Stack<Integer>();
		for(int x=v;x!=s;x=edgeTo[x]) {
			path.push(x);
		}
		path.push(s);
		return path;
		
	}
	
	

}
