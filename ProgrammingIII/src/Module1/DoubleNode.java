package Module1;

public class DoubleNode<T> {

    private T info;
    private DoubleNode<T> previous;
    private DoubleNode<T> next;

    public DoubleNode() {
        this.info = null;
        this.previous = null;
        this.next = null;
    }

    public DoubleNode(T info) {
        this();
        this.setInfo(info);
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

}
