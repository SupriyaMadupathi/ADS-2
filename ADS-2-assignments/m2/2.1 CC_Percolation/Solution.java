
import java.util.Scanner;

class Percolation {

    private int cnt;
    
    private int[][] grid;
    
    private int size;
    
    private Graph cd;
    private CC cc;
    
    Percolation(final int n) {
        grid = new int[n][n];
        cnt = 0;
        cd = new Graph((n * n) + 2);
        cc = new CC(cd);
        this.size = n;
    }
    
    void open(final int row, final int col) {
        grid[row][col] = 1;
        cnt++;
        if (row == 0) {
            cd.addEdge(0, component(row, col));
        }
        if (row == size - 1) {
            cd.addEdge((size * size) + 1, component(row, col));
        }
        if (row + 1 < size && grid[row][col] == 1) {
                cd.addEdge(
                    component(row + 1, col), component(row, col));
            }
        if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                cd.addEdge(
                    component(row - 1, col), component(row, col));
        }
        if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                cd.addEdge(component(row, col - 1), component(row, col));
        }
        if (col + 1 < size && grid[row][col + 1] == 1) {
                cd.addEdge(
                    component(row, col + 1), component(row, col));
        }
    }
    
    int component(final int i, final int j) {
        return (i) * size + j;
    }
    
    boolean isOpen(final int row, final int col) {
        return grid[row][col] == 1;
    }
    
    boolean isFull(final int row, final int col) {
        return grid[row][col] == 0;
    }
    
    int numberofopensites() {
        return cnt;
    }
    
    boolean percolates() {
        cc = new CC(cd);
        return cc.connected(0, (size * size) + 1);
    }
}

class Solution {
    
    protected Solution() {

    }
    
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertices = sc.nextInt();
        Percolation wc = new Percolation(vertices);
        while (sc.hasNext()) {
        wc.open(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        System.out.println(wc.percolates());
    }
}
