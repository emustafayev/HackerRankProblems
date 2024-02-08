package leet_code;


import java.util.Arrays;

// UnionFind.class
class UnionFind {


    public static void main(String[] args) {

    }
    private int[] root;

    public int[] getRoot() {
        return root;
    }

    public UnionFind(int x) {
        root = new int[x];
        for (int i = 0; i < x; i++) {
            root[i] = i;
        }
    }

    public int find(int x) {
        return root[x];
    }


    public void union(int x, int y) {

    }


    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}


public class DisjointSetQuickFind {


    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        // 1-2-5-6-7 3-8-9 4

        uf.union(1, 2);
        uf.union(2, 5);
        uf.union(5, 6);
        uf.union(6, 7);
        uf.union(3, 8);
        uf.union(8, 9);

        System.out.println(Arrays.toString(uf.getRoot()));
        System.out.println(uf.connected(1, 5)); // true
    }

    public final static void nap(){

    }

}

