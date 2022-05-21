package Module1;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {

    private Node<T> first;
    private int size;

    public MySimpleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        Node<T> tmp = this.first;
        if(tmp == null)
            return null;
        this.first = this.first.getNext();
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

    public int indexOf(T info){
        if (this.first == null)
            return -1;
        var tmp = this.first;
        for(int i = 0; i < this.size; i++){
            if(tmp.getInfo().equals(info))
                return i;
            tmp = tmp.getNext();
        }
        return -1;
    }

    public void sort(){
        Node<T> current = this.first, index = null;
        T temp;
        if(this.first == null)
            return;
        else {
            while(current != null) {
                index = current.getNext();
                while(index != null) {
                    if(current.getInfo().compareTo(index.getInfo()) > 0) {
                        temp = current.getInfo();
                        current.setInfo(index.getInfo());
                        index.setInfo(temp);
                    }
                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    public boolean isPalindrome(){
        var isPalindrome = true;
        for (int i = 0; i < this.size / 2 && isPalindrome; i++){
            if(!this.get(i).equals(this.get(size - i - 1)))
                isPalindrome = false;
        }
        return isPalindrome;
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
    public MyIterator<T> iterator() {
        return new MyIterator<T>(this.first);
    }

}