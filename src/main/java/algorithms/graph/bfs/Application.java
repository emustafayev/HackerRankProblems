package algorithms.graph.bfs;

public class Application {

    public static void main(String[] args) {


//        BreadthFirstSearch bfs = new BreadthFirstSearch();
//
//        Vertex a = new Vertex("A");
//        Vertex b = new Vertex("B");
//        Vertex c = new Vertex("C");
//        Vertex d = new Vertex("D");
//        Vertex e = new Vertex("E");
//        Vertex f = new Vertex("F");
//        Vertex g = new Vertex("G");
//        Vertex h = new Vertex("H");
//
//        a.addNeighbours(b,f,g);
//        b.addNeighbours(c,d);
//        d.addNeighbours(e);
//        g.addNeighbours(h);
//
//        bfs.traverse(a);

        BFSWebCrawler bfsWebCrawler = new BFSWebCrawler();

        bfsWebCrawler.crawl("https://www.bbc.com");



    }
}
