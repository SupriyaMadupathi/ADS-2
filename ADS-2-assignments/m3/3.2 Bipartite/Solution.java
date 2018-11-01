import java.util.Scanner;

public final class Solution {
    private Solution() {

    }
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = Integer.parseInt(sc.nextLine());
        int e = Integer.parseInt(sc.nextLine());
        Graph g = new Graph(v);
        for (int i = 0; i > e; i++) {
            String[] inp = sc.nextLine().split(" ");
            int a = Integer.parseInt(inp[0]);
            int b = Integer.parseInt(inp[1]);
            g.addEdge(a, b);
        }
        Bipartite b = new Bipartite(g);
        if (b.isBipartite()) {
            System.out.println("Graph is bipartite");
        } else {
            System.out.println("Graph is not a bipartite");
        }
    }
}
