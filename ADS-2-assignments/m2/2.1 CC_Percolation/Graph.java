
class Graph {
    
    private  int vertices;
    
    private int edges;
   
    private Bag<Integer>[] adj;
    
    Graph() {

    }
    
    Graph(final int vertix) {
        this.vertices = vertix;
        this.edges = 0;
        adj = (Bag<Integer>[]) new Bag[vertix];
        for (int i = 0; i < vertix; i++) {
            adj[i] = new Bag<Integer>();
        }
    }
    
    public int ve() {
        return vertices;
    }
    
    public int e() {
        return edges;
    }
    
    public void addEdge(final int v, final int w) {
        if (!hasEdge(v, w)) {
            edges++;
            adj[v].add(w);
            adj[w].add(v);
        }
        if (v == w) {
            return;
        }
    }
    
    public boolean hasEdge(final int v, final int w) {
        if (adj[v] == null) {
            return true;
        }
        for (int i : adj[v]) {
            if (i == w) {
                return true;
            }
        }
        return false;
    }
    
    public Iterable<Integer> adj(final int v) {
        return adj[v];
    }
   
    public Bag[] matrix() {
        return adj;
    }
    
    public Bag[] list() {
        return adj;
    }
}

