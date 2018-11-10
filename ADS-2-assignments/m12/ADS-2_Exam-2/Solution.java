import java.util.Scanner;
public class Solution {
	Solution(){

	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int cities = Integer.parseInt(sc.nextLine());
		int roads = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(cities);
		while(sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            for (int j = 1; j < input.length; j++) {
                Edge e = new Edge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Double.parseDouble(input[2]));
                ewg.addEdge(e);
            }
        } 

		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...

		String caseToGo = sc.nextLine();
		switch (caseToGo) {
		case "Graph":
		System.out.println(cities + " vertices" + " " + roads + " edges");
		    String str = "";
		    for (int i = 0; i < cities; i++) {
                str += i + ":";
                for (Edge e : ewg.adj[i]) {
                    str += e + " " + e.weight(); 
                }
                System.out.println(str);
            }
            break;
			//Print the Graph Object.


		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		default:
			break;
		}

	}
}