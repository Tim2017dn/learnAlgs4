package graphPackage;

public class DepthFirstSearch_Self {
	
	boolean[] marked;
	int count;
	
	public DepthFirstSearch_Self(Graph_Self G,int s) {
		marked=new boolean[G.V()];
		validateVertex(s);
		dfs(G,s);
	
	}
	
	private void dfs(Graph_Self G,int v) {
		count++;
		marked[v]=true;
		for(int w:G.adj(v)) {
			if(!marked[w])
				dfs(G, w);
		}
	}
	
	
	
	private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
        
	}
	
	public boolean marked(int v) {
		validateVertex(v);
		return marked[v];
	}
	
	public int count() {
		return count;
	}

}
