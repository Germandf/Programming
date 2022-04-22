package Module1;

public class MyDoubleLinkedList<T> implements Iterable<T> {

    private DoubleNode<T> first;
    private int size;

    public MyDoubleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        var tmp = new DoubleNode<T>(info);
        if(this.first != null)
            this.first.setPrevious(tmp);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        var tmp = this.first;
        if(tmp == null)
            return null;
        this.first = this.first.getNext();
        this.first.setPrevious(null);
        this.size--;
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public T get(int index) {
        if (this.first == null)
            return null;
        var tmp = this.first;
        for(int i = 0; i < index; i++){
            if(tmp.getNext() == null)
                return null;
            tmp = tmp.getNext();
        }
        return tmp.getInfo();
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        if (this.first == null)
            return "";
        var string = "";
        var tmp = this.first;
        for(int i = 0; i < this.size; i++){
            string += tmp.getInfo().toString();
            tmp = tmp.getNext();
            if(tmp != null)
                string += ", ";
        }
        return string;
    }

    @Override
    public MyDoubleIterator<T> iterator() {
        return new MyDoubleIterator<T>(this.first);
    }
}
