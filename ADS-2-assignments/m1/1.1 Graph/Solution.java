import java.util.Scanner;

interface Graph {
   
    int vertices();
    
    int edges();
    
    void addEdge(int v, int w);
    
    Iterable<Integer> adj(int v);
    
    boolean hasEdge(int v, int w);
}

class Newgraph implements Graph {
    
     int vertices;
    
     int edges;
    
     Bag<Integer>[] adj;
     String[] tokens;
     Newgraph() {
    }
    Newgraph( int vert) {
        this.vertices = vert;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vert];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    Newgraph(Scanner scan) {
        this.vertices = Integer.parseInt(scan.nextLine());
        adj = (Bag<Integer>[]) new Bag[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new Bag<Integer>();
        }
        int edg = Integer.parseInt(scan.nextLine());
        tokens = scan.nextLine().split(",");
        for (int i = 0; i < edg; i++) {
            String[] inputs = scan.nextLine().split(" ");
            addEdge(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }
    }
    public int vertices() {
        return vertices;
    }
    public int edges() {
        return edges;
    }
    public void addEdge(int vertexOne,int vertexTwo) {
        if (vertexOne == vertexTwo) {
            return;
        }
        if (!hasEdge(vertexOne, vertexTwo)) {
        adj[vertexOne].add(vertexTwo);
        adj[vertexTwo].add(vertexOne);
        edges++;
        }
    }
    public Iterable<Integer> adj(int vertex) {
        return adj[vertex];
    }
    public boolean hasEdge(int v, int w) {
        for (int k : adj[v]) {
                if (k == w) {
                    return true;
                }
        } return false;
    }
    public void show(int vert, int edg,
        String[] tok) throws Exception {
        if (edg <= 1 && vert <= 1) {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            throw new Exception("No edges");
        } else {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            for (int i = 0; i < tok.length; i++) {
            String str = "";
            str = tok[i] + ": ";
            for (int k : adj(i)) {
                str = str + tok[k] + " ";
            }
            System.out.println(str);
            }
        }
    }
    public void show1(int vert,
        int edg) throws Exception {
        if (edg <= 1 && vert <= 1) {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            //throw new Exception("No edges");
        } else {
            System.out.println(vertices()
                + " vertices" + ", " + edges() + " edges");
            int[][] disp = new int[vert][vert];
            for (int i = 0; i  < vert; i++) {
                for (int j = 0; j < vert; j++) {
                    if (hasEdge(i, j)) {
                        disp[i][j] = 1;
                    }
                }
            }
            for (int i = 0; i < vert; i++) {
                for (int j = 0; j < vert; j++) {
                    System.out.print(disp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

public final class Solution {
    private Solution() {

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.nextLine();
        int numberofvertices = Integer.parseInt(sc.nextLine());
        int numberofedges = Integer.parseInt(sc.nextLine());
        String[] keys = sc.nextLine().split(",");
        Newgraph g = new Newgraph(numberofvertices);
        while (sc.hasNext()) {
            String[] conn = sc.nextLine().split(" ");
            g.addEdge(Integer.parseInt(conn[0]),
                Integer.parseInt(conn[1]));
        }
        switch (type) {
            case "List":
            try {
                g.show(numberofvertices, numberofedges, keys);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            case "Matrix":
            try {
                g.show1(numberofvertices, numberofedges);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
            default:
            break;
        }
    }
}

