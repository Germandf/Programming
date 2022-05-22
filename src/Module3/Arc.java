package Module3;

public class Arc<T> {

    private int originVertex;
    private int destinyVertex;
    private T label;

    public Arc(int originVertex, int destinyVertex, T label) {
        this.originVertex = originVertex;
        this.destinyVertex = destinyVertex;
        this.label = label;
    }

    public int getOriginVertex() {
        return originVertex;
    }

    public int getDestinyVertex() {
        return destinyVertex;
    }

    public T getLabel() {
        return label;
    }

}
