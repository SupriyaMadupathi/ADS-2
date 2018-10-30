
public class CC {
    
     boolean[] marked;
   
     int[] id;
     int[] size;
    
    int count;

    
    public CC(final Graph g) {
        marked = new boolean[g.ve()];
        id = new int[g.ve()];
        size = new int[g.ve()];
        for (int v = 0; v < g.ve(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }
    private void dfs(final Graph g, final int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }
    public int id(final int v) {
        validateVertex(v);
        return id[v];
    }
    public int size(final int v) {
        validateVertex(v);
        return size[id[v]];
    }
    public int count() {
        return count;
    }
    public boolean connected(final int v, final int w) {
        validateVertex(v);
        validateVertex(w);
        return id(v) == id(w);
    }
    private void validateVertex(final int v) {
        int v1 = marked.length;
        if (v < 0 || v >= v1) {
            throw new IllegalArgumentException("vertex "
                + v + " is not between 0 and " + (v1 - 1));
        }
    }
}

