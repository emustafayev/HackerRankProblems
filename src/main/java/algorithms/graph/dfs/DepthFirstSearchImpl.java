package algorithms.graph.dfs;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearchImpl {

    public DepthFirstSearchImpl() {
        this.stack = new Stack<>();
    }

    private Stack<Vertex> stack;

    public void dfs(List<Vertex> roots, boolean recursive) {

        for (Vertex root : roots) {
            if (!root.isVisited())
                if (recursive) {
                    root.setVisited(true);
                    dfsHelperRecursive(root);
                }
                else
                    dfsHelper(root);

            System.out.println();
        }
    }

    private void dfsHelper(Vertex root) {
        stack.add(root);
        while (!stack.isEmpty()) {
            System.out.println(stack);
            Vertex current = stack.pop();
            current.setVisited(true);
            System.out.println("Vertex: " + current.getName());
            for (Vertex v : current.getNeighbours()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    stack.add(v);
                }
            }
        }
    }


    private void dfsHelperRecursive(Vertex root) {
        System.out.println("Vertex: " + root);
        for (Vertex v : root.getNeighbours()) {
            if (!v.isVisited()) {
                v.setVisited(true);
                dfsHelperRecursive(v);
            }
        }

    }


}
