package Module1;

import java.util.Iterator;

public class MyDoubleIterator<T> implements Iterator<T> {

    private DoubleNode<T> cursor;

    public MyDoubleIterator(DoubleNode<T> first) {
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