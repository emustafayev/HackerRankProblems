package algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {


    public void traverse(Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(root);
        root.setVisited(true);

        while (!queue.isEmpty()) {
            System.out.println(queue);
            Vertex current = queue.poll();

            System.out.println(current.getName());

            for (Vertex node : current.getNeighbors()) {

                if (!node.isVisited()){
                    node.setVisited(true);
                    queue.add(node);
                }
            }
        }


    }
}
