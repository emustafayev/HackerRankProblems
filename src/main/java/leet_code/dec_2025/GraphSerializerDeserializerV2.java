package leet_code.dec_2025;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphSerializerDeserializerV2 {


    public List<Integer> encode(Node root) {
        Map<Node, Integer> nodeToId = new HashMap<>();
        List<Node> idToNode = new ArrayList<>();

        idToNode.add(root);
        nodeToId.put(root, 0);
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(root);

        //For encoding
        //Node => ID
        //ID => Node(Order)

        while(!queue.isEmpty()) {
            Node currentNode = queue.poll();
            for (Node nei: currentNode.edgeNeighbours){
                if (!nodeToId.containsKey(nei)) {
                    int newId = nodeToId.size();
                    nodeToId.put(nei,newId);
                    idToNode.add(nei);
                    queue.add(nei);
                }
            }
        }

        System.out.println(nodeToId);
        int N = idToNode.size();
        ArrayList<Integer> encoded = new ArrayList<>();
        encoded.add(N);

        for (int i = 0; i < N; i++) {
            Node node = idToNode.get(i);
            //Add node data, node edge count, id of edges
            encoded.add(node.data);
            encoded.add(node.edgeNeighbours.size());

            for(Node nei: node.edgeNeighbours){
                encoded.add(nodeToId.get(nei));//I knew all nodes IDs bc it is ordered.
            }
        }
        return encoded;
    }

    public Node decode(List<Integer> encoded) {

        return  null;
    }

    public static void main(String[] args) throws IllegalAccessException {

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

        GraphSerializerDeserializerV2 gds = new GraphSerializerDeserializerV2();
        List<Integer> encode = gds.encode(a);
        System.out.println(encode);
    }
}
