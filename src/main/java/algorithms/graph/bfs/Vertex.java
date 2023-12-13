package algorithms.graph.bfs;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Vertex {
    private String name;
    private boolean visited;
    private List<Vertex> neighbors;

    public Vertex(String name) {
        this.name = name;
        neighbors = new ArrayList<>();
    }

    public void addNeighbours(Vertex... vertex) {
        this.neighbors.addAll(Arrays.asList(vertex));
    }


    @Override
    public String toString() {
        return name;
    }
}
