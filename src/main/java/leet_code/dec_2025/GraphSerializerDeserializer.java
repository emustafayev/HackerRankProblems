package leet_code.dec_2025;

import java.util.*;

/**
 * Graph node definition.
 */
class Node {
    int data;
    List<Node> edgeNeighbours;

    Node(int data) {
        this.data = data;
        this.edgeNeighbours = new ArrayList<>();
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

/**
 * This class contains:
 * - encrypt(Node root) -> List<Integer>
 * - decrypt(List<Integer> encoded) -> Node
 * <p>
 * The encoding supports:
 * - cycles
 * - duplicated node.data values
 * <p>
 * It serializes ONLY the connected component reachable from root.
 */
public class GraphSerializerDeserializer {

    /**
     * Serializes a graph component reachable from root into a flat List<Integer>.
     * <p>
     * Encoding format:
     * [N,
     * data_0, degree_0, neighborId_0_1, neighborId_0_2, ...,
     * data_1, degree_1, neighborId_1_1, ...
     * ...
     * ]
     * <p>
     * Where:
     * - N is number of unique nodes discovered from root
     * - each node gets a unique ID in discovery order: root is 0, next discovered is 1, ...
     */
    public List<Integer> encrypt(Node root) {
        // If graph is empty, encode N=0.
        if (root == null) {
            return Collections.singletonList(0);
        }

        // nodeToId assigns stable IDs to nodes based on object identity.
        Map<Node, Integer> nodeToId = new HashMap<>();

        // We keep nodes in the order we assigned IDs, so we can later write them out by ID.
        List<Node> idToNode = new ArrayList<>();

        // BFS queue (DFS also works).
        ArrayDeque<Node> queue = new ArrayDeque<>();

        // Initialize with root as ID=0.
        nodeToId.put(root, 0);
        idToNode.add(root);
        queue.add(root);

        // BFS to discover all reachable nodes and assign IDs.
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            // Discover neighbors and assign IDs for newly seen nodes.
            for (Node nei : current.edgeNeighbours) {
                if (!nodeToId.containsKey(nei)) {
                    int newId = idToNode.size();
                    nodeToId.put(nei, newId);
                    idToNode.add(nei);
                    queue.add(nei);
                }
            }
        }

        // Now we know N and we know the ID of every node.
        int N = idToNode.size();
        List<Integer> encoded = new ArrayList<>();

        // 1) Write N
        encoded.add(N);

        // 2) For each node by ID, write:
        //    data, degree, neighbor IDs
        for (int id = 0; id < N; id++) {
            Node node = idToNode.get(id);

            // Write node data
            encoded.add(node.data);

            // Write degree (number of neighbors)
            List<Node> neighbours = node.edgeNeighbours;
            encoded.add(neighbours.size());

            // Write neighbor IDs (some may point backward, forward, or to itself)
            for (Node nei : neighbours) {
                encoded.add(nodeToId.get(nei));
            }
        }

        return encoded;
    }

    /**
     * Deserializes a graph from the List<Integer> produced by encrypt().
     * Returns the root node (ID=0), or null if encoded graph is empty.
     */
    public Node decrypt(List<Integer> encoded) {
        // Basic validation
        if (encoded == null || encoded.isEmpty()) {
            return null;
        }

        int idx = 0;

        // 1) Read N
        int N = encoded.get(idx++);
        if (N == 0) {
            return null;
        }

        // We'll create all nodes first (two-pass approach),
        // because edges can reference nodes that appear later (forward references).
        Node[] nodes = new Node[N];

        // We'll store neighbor ID lists temporarily while parsing,
        // then connect edges after all Node objects exist.
        List<int[]> neighbourLists = new ArrayList<>(N);

        // 2) Parse each node: data, degree, neighbors...
        for (int i = 0; i < N; i++) {
            // Read data
            int data = encoded.get(idx++);
            nodes[i] = new Node(data);

            // Read degree
            int degree = encoded.get(idx++);

            // Read neighbor IDs into an array
            int[] neighbours = new int[degree];
            for (int j = 0; j < degree; j++) {
                neighbours[j] = encoded.get(idx++);
            }
            neighbourLists.add(neighbours);
        }

        // 3) Wire edges
        for (int i = 0; i < N; i++) {
            int[] neighbours = neighbourLists.get(i);
            for (int neiId : neighbours) {
                nodes[i].edgeNeighbours.add(nodes[neiId]);
            }
        }

        // Root is always node ID 0 (same convention as encrypt).
        return nodes[0];
    }

    // -------------------- Optional: quick sanity test --------------------
    public static void main(String[] args) {
        // Build a graph with:
        //  - duplicate data values
        //  - cycles
        Node a = new Node(7);
        Node b = new Node(7);   // duplicate data
        Node c = new Node(42);

        // Create cycle: a -> b -> c -> a
        a.edgeNeighbours.add(b);
        b.edgeNeighbours.add(c);
        c.edgeNeighbours.add(a);

        // Add self-loop: b -> b
        b.edgeNeighbours.add(b);

        GraphSerializerDeserializer codec = new GraphSerializerDeserializer();

        List<Integer> enc = codec.encrypt(a);
        System.out.println("Encoded: " + enc);

        Node decodedRoot = codec.decrypt(enc);

        // Basic checks:
        System.out.println("Decoded root data: " + decodedRoot.data);
        System.out.println("Decoded root neighbors count: " + decodedRoot.edgeNeighbours.size());
        System.out.println("Decoded root neighbor[0] data: " + decodedRoot.edgeNeighbours.get(0).data);
    }
}
