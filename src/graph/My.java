package graph;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import static sun.misc.Version.println;

public class My {
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
//            The graph is undirected?
//            getNode(second).addNeighbour(first);
        }


        Boolean bfs(Node source, Node destination) {
            HashSet<Integer> visited = new HashSet<>();
            LinkedList<Integer> toVisit = new LinkedList<>();

            toVisit.add(source.id);

            while (!toVisit.isEmpty()) {
                Integer nodeId = toVisit.remove();
                if (destination.id == nodeId) return true;

                if (visited.contains(nodeId)) continue;

                visited.add(nodeId);
                toVisit.addAll(getNode(nodeId).neighbours);
            }

            return false;
        }

        Boolean dfs(Node source, Node destination, HashSet<Integer> visited) {
            if (visited.contains(source.id)) return false;
            visited.add(source.id);

            if (destination == source) return true;

            for (Integer neighbour : source.neighbours) {
                if (dfs(getNode(neighbour), destination, visited)) {
                    return true;
                }
            }

            return false;
        }

        public static void main(String[] args) {
            Graph graph = new Graph(6);
            graph.addEdge(0, 1);
            graph.addEdge(1, 2);
            graph.addEdge(2, 3);
            graph.addEdge(3, 4);
            graph.addEdge(4, 5);

            if (graph.dfs(graph.getNode(1), graph.getNode(2), new HashSet<>())) {
                System.out.println("DFS YES");
            } else {
                System.out.println("DFS NO");
            }

            if (graph.bfs(graph.getNode(1), graph.getNode(2))) {
                System.out.println("BFS YES");
            } else {
                System.out.println("BFS NO");
            }
        }
    }
}