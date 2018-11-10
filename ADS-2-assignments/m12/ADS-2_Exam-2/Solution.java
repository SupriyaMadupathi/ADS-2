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
            }
                System.out.println(ewg);
            break;
			//Print the Graph Object.


		case "DirectedPaths":
		while (sc.hasNextLine()) {
			String[] s = sc.nextLine().split(" ");
                int v = Integer.parseInt(s[0]);
                int w = Integer.parseInt(s[1]);
                DijkstraUndirectedSP dsp = new DijkstraUndirectedSP(ewg, v);
                if (dsp.hasPathTo(w)) {
                System.out.println(dsp.distTo(w));
            } else {
            	System.out.println("No Path Found.");
			}
		}
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			break;

		case "ViaPaths":
		String[] paths = sc.nextLine().split(" ");
			int source = Integer.parseInt(paths[0]);
			int via = Integer.parseInt(paths[1]);
			int destination = Integer.parseInt(paths[2]);
			DijkstraUndirectedSP dusp = new DijkstraUndirectedSP(ewg, source);
			if (dusp.hasPathTo(destination)) {
				System.out.println("");
			} else {
                System.out.println("No Path Found.");
			}
	
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