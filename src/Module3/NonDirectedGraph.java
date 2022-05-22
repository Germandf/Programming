package Module3;

public class NonDirectedGraph<T> extends DirectedGraph<T> {

    @Override
    public void addArc(int vertexId1, int vertexId2, T label) {
        super.addArc(vertexId1, vertexId2, label);
        super.addArc(vertexId2, vertexId1, label);
    }

    @Override
    public void deleteArc(int vertexId1, int vertexId2) {
        super.deleteArc(vertexId1, vertexId2);
        super.deleteArc(vertexId2, vertexId1);
    }

}
