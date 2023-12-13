package algorithms.graph.dfs;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Vertex {
    private List<Vertex> neighbours;
    private boolean visited;
    private String name;

    public Vertex(String name) {
        this.name = name;
        neighbours = new ArrayList<>();
    }

    @Override
    public String toString() {
        return name;
    }

    public void addNeighbours(Vertex... vertices) {
        neighbours.addAll(Arrays.asList(vertices));
    }
}
