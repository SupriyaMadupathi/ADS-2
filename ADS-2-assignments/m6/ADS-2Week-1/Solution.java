import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {
    Digraph graph;
    int vertices;
    int edges;
    int outdeg;
    int indeg;
    int[] array;
    /**
     * Constructs the object.
     */
    PageRank() {
    }
    /**
     * Constructs the object.
     *
     * @param      gr    The graphics
     */
    PageRank(Digraph gr) {
        graph = gr;
        vertices = gr.V();
        edges = gr.E();
    }
    /**
     * Gets the pr.
     *
     * @param      v1    The v 1
     *
     * @return     The pr.
     */
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
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
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
/**
 * Class for web search.
 */
class WebSearch {

}

/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution(){

    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        //Digraph gph = new Digraph();
        // read the first line of the input to get the number of vertices
        int vertex = Integer.parseInt(sc.nextLine());
        Digraph gph = new Digraph(vertex);
        // iterate count of vertices times
        // to read the adjacency list from std input
        // and build the graph
        while(sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                gph.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[j]));
            }
        } 
        // Create page ranj object and pass the graph object to the constructor
        PageRank pr = new PageRank(gph);
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