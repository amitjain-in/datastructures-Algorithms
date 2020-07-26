package amit.problems.graphs;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph<T> {

    private final List<Vertex<T>> vertices = new LinkedList<>();
    private final List<Edge<T>> edges = new LinkedList<>();

    public List<Vertex<T>> getVertices() {
        return vertices;
    }

    public List<Edge<T>> getEdges() {
        return edges;
    }

    public void addVertex(Vertex<T> vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Edge<T> edge) {
        edges.add(edge);
    }

    public Vertex<T> bfs(Vertex<T> from, T elem) {
        Queue<Vertex<T>> queue = new ArrayDeque<>();
        return null;
    }

    static class Vertex<T> {
        final T data;
        final List<Edge<T>> paths = new LinkedList<>();

        public Vertex(T data) {
            this.data = data;
        }

        public void addEdge(Edge<T> edge) {
            paths.add(edge);
        }
    }

    static class Edge<T> {
        final Vertex<T> b;
        final int weight;

        public Edge(Vertex<T> b) {
            this(b, 1);
        }

        public Edge(Vertex<T> b, int weight) {
            this.b = b;
            this.weight = weight;
        }
    }
}
