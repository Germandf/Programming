package Module1;

import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {

    private Node<T> cursor;

    public MyIterator(Node<T> first) {
        this.cursor = first;
    }

    @Override
    public boolean hasNext() {
        return this.cursor != null;
    }

    @Override
    public T next() {
        var info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }

    public T getCurrent(){
        return this.cursor.getInfo();
    }

}