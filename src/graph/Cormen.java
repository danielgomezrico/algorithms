package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Cormen {

    static final int WHITE = 0;
    static final int GRAY = 1;
    static final int BLACK = 2;

    static class Node {
        HashSet<Integer> neighbours;
        int id;

        Node(int id) {
            this.neighbours = new HashSet<>();
            this.id = id;
        }

        void addNeighbour(int id) {
            neighbours.add(id);
        }
    }

    public static class Graph {
        Node[] nodes;

        Graph(int size) {
            nodes = new Node[size];
        }

        Node getNode(int id) {
            Node node = nodes[id];

            if (node == null) {
                node = new Node(id);
                nodes[id] = node;
            }

            return node;
        }

        void addEdge(int first, int second) {
            getNode(first).addNeighbour(second);
            getNode(second).addNeighbour(first);
        }
    }

    static int[] shortPathToEveryoneBfs(Graph graph, Node source) {
        final int weight = 6;
        int[] colors = new int[graph.nodes.length];
        int[] distance = new int[graph.nodes.length];
        LinkedList<Node> queue = new LinkedList<Node>();

        for (int i = 0; i < graph.nodes.length; i++) {
            colors[i] = 0;
            distance[i] = Integer.MAX_VALUE;
        }

        colors[source.id] = WHITE;
        distance[source.id] = 0;
        queue.add(source);

        while (!queue.isEmpty()) {
            Node currentNode = queue.pop();

            for (int neighbourId : currentNode.neighbours) {
                if (colors[neighbourId] == WHITE) {
                    colors[neighbourId] = GRAY;
                    distance[neighbourId] = distance[currentNode.id] + weight;
                    queue.add(graph.getNode(neighbourId));
                }
            }

            colors[currentNode.id] = BLACK;
        }

        return distance;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);

        int[] distances = shortPathToEveryoneBfs(graph, graph.getNode(1));
        for (int i = 1; i < distances.length; i++) {
            System.out.print(" " + distances[i]);
        }
    }
}