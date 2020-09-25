package graphPackage;

public class CC_Self {
	
	boolean[] marked;
	int[] id;
	int[] size;
	int count;
	
	public CC_Self(Graph_Self G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		size = new int[G.V()];
		for(int v=0;v<G.V();v++) {
			if(!marked[v]) {
				dfs(G,v);
				count++;
			}
		}	
	}
	
	public void dfs(Graph_Self G,int v) {
		marked[v]=true;
		id[v]=count;
		for(int w:G.adj(v)) {
			if(!marked[w]) {
				dfs(G, w);
			}
		}
	}
	
	
	public int id(int v) {
		validateVertex(v);
		return id[v];
	}
	
	private void validateVertex(int v) {
        int V = marked.length;
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }
	
	public int size(int v) {
        validateVertex(v);
        return size[id[v]];
    }
	
	public int count() {
        return count;
    }
	
	public boolean connected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
	
	
	
	

}
