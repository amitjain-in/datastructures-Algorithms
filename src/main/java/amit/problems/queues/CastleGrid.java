package amit.problems.queues;


import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CastleGrid {


    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        Graph graph = buildGraph(grid);
        return graph.minDistance(graph.findVertex(startX, startY), graph.findVertex(goalX, goalY));
    }

    static Graph buildGraph(String[] grid) {
        Graph graph = new Graph();
        int n = (int) Math.sqrt(grid.length);
        int row = 0;

        for (int i = 0; i < grid.length; i++) {
            boolean isRowEnd = i % (n - 1) == 0;
            if (grid[i].equals("X") || isRowEnd) { //Create a vertex out of this
                Vertex vertex = new Vertex(row, i % n);
                graph.vertices.add(vertex);
            }

            if (isRowEnd) {
                row++;
            }
        }
        return graph;
    }

    static class Graph {
        final List<Vertex> vertices = new LinkedList<>();
        final List<Edge> edges = new LinkedList<>();

        public int minDistance(Vertex a, Vertex b) {
            //Djiskstras
            return 0;
        }

        public Vertex findVertex(int x, int y) {
            for (Vertex vertex : vertices) {
                if (vertex.x == x && vertex.y == y) { //optimise later
                    return vertex;
                }
            }
            return null;
        }
    }

    static class Vertex {
        final int x;
        final int y;

        Vertex(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge {
        final Vertex a;
        final Vertex b;

        Edge(Vertex a, Vertex b) {
            this.a = a;
            this.b = b;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);
}
