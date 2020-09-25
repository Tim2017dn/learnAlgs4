package digraphPackage;

import edu.princeton.cs.algs4.DepthFirstSearch;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;

public class Test {

	public static void main(String[] args) {

		testDigrapgh();
	}


	public static void testDigrapgh(){
		File f=new File("src/algs4-data/tinyDG.txt");
		Digraph_Self G =new Digraph_Self(new In(f));

		StdOut.println(G);
	}
	
}
