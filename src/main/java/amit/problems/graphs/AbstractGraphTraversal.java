package amit.problems.graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractGraphTraversal<T> {

    protected volatile boolean isFinished = false;
    private final AtomicInteger timeCounter = new AtomicInteger(0);
    private final Map<Graph.Vertex<T>, GraphVertexTraversal<T>> verticesTraversals = new HashMap<>();

    public void dfs(Graph<T> graph, Graph.Vertex<T> vertex) {
        GraphVertexTraversal<T> vertexTraversal = verticesTraversals.computeIfAbsent(vertex, v -> new GraphVertexTraversal<>(vertex));
        dfs(graph, vertexTraversal);
    }

    private void dfs(Graph<T> graph, GraphVertexTraversal<T> vertex) {
        GraphVertexTraversal<T> other;
        if (isFinished) {
            return; //Search termination;
        }
        vertex.discovered = true;
        vertex.entryTime = timeCounter.incrementAndGet();
        processVertexEarly(vertex);

        for (Graph.Edge<T> edge : vertex.vertex.paths) {
            other = verticesTraversals.computeIfAbsent(edge.b, v -> new GraphVertexTraversal<>(edge.b));
            if(!other.discovered) {
                other.parent = vertex;
                processEdge(vertex, other);
                dfs(graph, other);
            } else if(!other.processed) {
                processEdge(vertex, other);
                if(isFinished) {
                    return;
                }
            }
        }
    }

    protected abstract void processVertexEarly(GraphVertexTraversal<T> vertex);

    protected abstract void processVertexLate(GraphVertexTraversal<T> vertex);

    protected abstract void processEdge(GraphVertexTraversal<T> parent, GraphVertexTraversal<T> child);

    static class GraphVertexTraversal<T> {

        final Graph.Vertex<T> vertex;
        boolean discovered = false;
        boolean processed = false;
        GraphVertexTraversal<T> parent;
        int entryTime;
        int exitTime;

        GraphVertexTraversal(Graph.Vertex<T> vertex) {
            this.vertex = vertex;
        }
    }
}
