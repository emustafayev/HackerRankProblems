package algorithms.graph.dfs;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {


        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        Vertex h = new Vertex("H");


        a.addNeighbours(g);
        g.addNeighbours(f);
        f.addNeighbours(a);

        c.addNeighbours(b,e);
        e.addNeighbours(c,d,h);
        d.addNeighbours(h);
        h.addNeighbours(e);

        DepthFirstSearchImpl depthFirstSearch = new DepthFirstSearchImpl();

        depthFirstSearch.dfs(Arrays.asList(a,c),false);



    }


}
