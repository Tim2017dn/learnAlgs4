package graphPackage;

import java.io.File;

import edu.princeton.cs.algs4.*;

public class TestSearch {

	public static void main(String[] args) {
		File f=new File("./src/graphPackage/tinyG.txt");
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
