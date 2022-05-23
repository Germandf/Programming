package Module3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PracticeImplementations {

    public static <T> void DFS(Graph<T> graph){
        var vertexesVisited = new String[graph.getVertexesAmount()];
        for (var vertexVisited: vertexesVisited)
            vertexVisited = "BLANCO";
        int time = 0;
        var i = graph.getVertexes();
        while (i.hasNext()){
            var vertex = i.next();
            if (vertexesVisited[vertex] == "BLANCO")
                time = DFSVisit(graph, vertexesVisited, vertex, time);
        }
    }

    private static <T> int DFSVisit(Graph<T> graph, String[] vertexesVisited, int vertex, int time){
        vertexesVisited[vertex] = "AMARILLO";
        time++;
        var i = graph.getAdjacent(vertex);
        while (i.hasNext()) {
            int adjacentVertex = i.next();
            if (vertexesVisited[adjacentVertex] == "BLANCO")
                time = DFSVisit(graph, vertexesVisited, adjacentVertex, time);
        }
        vertexesVisited[vertex] = "NEGRO";
        time++;
        return time;
    }

    public static <T> void BFS(Graph<T> graph){
        var vertexesVisited = new boolean[graph.getVertexesAmount()];
        var i = graph.getVertexes();
        while (i.hasNext()){
            var vertex = i.next();
            if (!vertexesVisited[vertex])
                BFSVisit(graph, vertexesVisited, vertex);
        }
    }

    private static <T> void BFSVisit(Graph<T> graph, boolean[] vertexesVisited, int vertex){
        vertexesVisited[vertex] = true;
        var queue = new LinkedList<Integer>();
        queue.addLast(vertex);
        while (!queue.isEmpty()){
            var vertexFromQueue = queue.removeFirst();
            var i = graph.getAdjacent(vertexFromQueue);
            while (i.hasNext()) {
                int adjacentVertex = i.next();
                if (!vertexesVisited[vertex]){
                    vertexesVisited[vertex] = true;
                    queue.addLast(adjacentVertex);
                }
            }
        }
    }

    public static <T> boolean GraphHasCycle(Graph<T> graph){
        var vertexesVisited = new String[graph.getVertexesAmount()];
        for (var vertexVisited: vertexesVisited)
            vertexVisited = "BLANCO";
        var i = graph.getVertexes();
        while (i.hasNext()){
            var vertex = i.next();
            if (vertexesVisited[vertex] == "BLANCO")
                if(GraphHasCycleVisit(graph, vertexesVisited, vertex))
                    return true;
        }
        return false;
    }

    private static <T> boolean GraphHasCycleVisit(Graph<T> graph, String[] vertexesVisited, int vertex){
        vertexesVisited[vertex] = "AMARILLO";
        var i = graph.getAdjacent(vertex);
        while (i.hasNext()) {
            int adjacentVertex = i.next();
            if (vertexesVisited[adjacentVertex] == "BLANCO")
                GraphHasCycleVisit(graph, vertexesVisited, adjacentVertex);
            else if (vertexesVisited[adjacentVertex] == "AMARILLO")
                return true;
        }
        vertexesVisited[vertex] = "NEGRO";
        return false;
    }

}
