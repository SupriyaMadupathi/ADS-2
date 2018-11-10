import java.util.Scanner;
public class Solution {
	Solution(){

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cities = Integer.parseInt(sc.nextLine());
		int roads = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph ewg = new EdgeWeightedGraph(cities);
		for (int i = 0; i < cities; i++) {
		    String[] str = sc.nextLine().split(" ");
		    Edge e = new Edge(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Double.parseDouble(str[2]));
		    ewg.addEdge(e);
		}
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
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
			int vertices = Integer.parseInt(s[0]);
			int weight = Integer.parseInt(s[1]);
                for (Edge j : ewg.adj(vertices)) {
                	if (j.either() == weight) {
                		System.out.println(j.weight());
                	} 
                }
                System.out.println("No Path Found.");
		}
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