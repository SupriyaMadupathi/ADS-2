import java.util.Scanner;
class PageRanj {
	Digraph graph;
	int vertices;
	int edges;
	int outdeg;
	int indeg;
	int[] array;
	PageRanj() {
    }
	PageRanj(Digraph gr) {
		graph = gr;
		vertices = gr.V();
		edges = gr.E();
    }
	public double getPR(int v1) {
		outdeg = graph.outdegree(v1);
		if (outdeg == 0) {
			return 0.0;
		}
		for (int i = 0; i < vertices; i++) {
			for (int v : graph.adj(i)) {
				if (v == v1)
                array[i++] = v;
		    }
		}
		double inpr = 1/edges;
		double pr = inpr;
		double newpr;
		for (int j = 0; j < array.length; j++) {
		    for (int i = 0; i < 1000; i++) {
			newpr = pr / graph.outdegree(array[j++]);
			pr = newpr;
		}
		}
		return pr;
    }
	public String toString() {
		String s = "";
		System.out.println(vertices + " vertices" +", "+edges + " edges");
        for (int i = 0; i < vertices; i++) {
            s = i + ": ";
            for (int j : graph.adj(i)) {
                s = s + j + " ";
                System.out.println(s);
            }
        }
        return null;
	}
}
class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Digraph gph = new Digraph();
		// read the first line of the input to get the number of vertices
		int vertex = Integer.parseInt(sc.nextLine());
		Digraph gph = new Digraph(vertex);
        // iterate count of vertices times
        // to read the adjacency list from std input
		// and build the graph
        for (int i = 0; i < vertex; i++) {
        	String input = sc.nextLine();
        	String[] tokens = input.split(" ");
        	for (int j = 1; j < tokens.length; j++) {
                gph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[j]));
        	}
        } 
		// Create page ranj object and pass the graph object to the constructor
		PageRanj pr = new PageRanj(gph);
		// print the page ranj object
		System.out.println(pr);
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page ranj object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucjy method of web search
		// print the return value of iAmFeelingLucjy
		
	}
}