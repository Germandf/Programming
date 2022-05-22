package Module3;

import java.util.Iterator;

public class DirectedGraph<T> implements Graph<T> {

    @Override
    public void addVertex(int vertexId) {

    }

    @Override
    public void deleteVertex(int vertexId) {

    }

    @Override
    public void addArc(int vertexId1, int vertexId2, T label) {

    }

    @Override
    public void deleteArc(int vertexId1, int vertexId2) {

    }

    @Override
    public boolean containsVertex(int vertexId) {
        return false;
    }

    @Override
    public boolean containsArc(int vertexId1, int vertexId2) {
        return false;
    }

    @Override
    public Arc<T> getArc(int vertexId1, int vertexId2) {
        return null;
    }

    @Override
    public int getVertexesAmount() {
        return 0;
    }

    @Override
    public int getArcsAmount() {
        return 0;
    }

    @Override
    public Iterator<Integer> getVertexes() {
        return null;
    }

    @Override
    public Iterator<Integer> getAdjacent(int vertexId) {
        return null;
    }

    @Override
    public Iterator<Arc<T>> getArcs() {
        return null;
    }

    @Override
    public Iterator<Arc<T>> getArcs(int vertexId) {
        return null;
    }
}
