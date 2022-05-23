package Module3;

import java.util.HashMap;

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

    public static <T> int DFSVisit(Graph<T> graph, String[] vertexesVisited, int vertex, int time){
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



}
