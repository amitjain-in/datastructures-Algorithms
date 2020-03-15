package amit.problems.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;


/**
 * Consider a group of people N. Few of them don't talk to each other and this information is given in pairs of dislikes.
 * Identify if you can divide this group of people into two sets such that no two people who dislike each other are in the same group.
 */
public class GraphBipartition {

    public static void main(String[] args) {
        GraphBipartition graphBipartition = new GraphBipartition();
        System.out.println(graphBipartition.possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));//true
        System.out.println(graphBipartition.possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));//false
        System.out.println(graphBipartition.possibleBipartition(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}}));//false - disconnected graph
    }

    public boolean possibleBipartition(int N, int[][] dislikes) {
        return solveIt(buildGraph(N, dislikes));
    }

    static HashMap<Integer, Vertex> buildGraph(int N, int[][] dislikes) {
        HashMap<Integer, Vertex> all = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            Vertex n = new Vertex(i);
            all.put(i, n);
        }
        for (int[] dislike : dislikes) {
            int from = dislike[0];
            int to = dislike[1];
            Vertex fromNode = all.get(from);
            Vertex toNode = all.get(to);
            fromNode.addDislike(toNode);
            toNode.addDislike(fromNode);
        }
        return all;
    }

    static boolean solveIt(HashMap<Integer, Vertex> allNodes) {

        Queue<Vertex> queue = new LinkedBlockingDeque<>();
        queue.add(allNodes.get(1));
        int peopleGrouped = 0;//Counter for all processed nodes.

        while (!queue.isEmpty() || peopleGrouped < allNodes.size()) {
            Vertex person = null;
            if (queue.isEmpty()) {//This is disconnected graph. Now find the other group of nodes which we haven't processed yet.
                for (Vertex nodeG : allNodes.values()) {
                    if (nodeG.group == 0) {
                        person = nodeG;
                        peopleGrouped++;
                        break;
                    }
                }
                //if person is still null then we have a problem here with the input.
            } else {
                person = queue.poll();
                peopleGrouped++;
            }
            if(person.group == 0) {
                for (Vertex dislike : person.dislikes) {
                    //Put the people who dislike each other in opposite groups
                    if (dislike.group == 1) {
                        person.group = 2;
                        break;
                    } else if (dislike.group == 2) {
                        person.group = 1;
                        break;
                    }
                }
                if (person.group == 0) {
                    //This is probably the first iteration for this connected graph. Hence, you can in any group. We chose 1.
                    person.group = 1;
                }
                for (Vertex dislike : person.dislikes) {
                    if (dislike.group == 0) {
                        queue.add(dislike);
                    } else if (person.group == dislike.group) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Vertex {
        final int data;
        final List<Vertex> dislikes = new LinkedList<>();
        int group = 0; //0 is not grouped, 1 is first group and 2 is second group

        public Vertex(int data) {
            this.data = data;
        }

        public void addDislike(Vertex node) {
            dislikes.add(node);
        }
    }
}
