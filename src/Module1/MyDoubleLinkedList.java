package Module1;

public class MyDoubleLinkedList<T> implements Iterable<T> {

    private DoubleNode<T> first;
    private DoubleNode<T> last;
    private int size;

    public MyDoubleLinkedList() {
        this.first = null;
    }

    public void insertFront(T info) {
        var tmp = new DoubleNode<T>(info);
        if(this.first != null)
            this.first.setPrevious(tmp);
        else
            this.last = tmp;
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        var tmp = this.first;
        if(tmp == null)
            return null;
        this.first = this.first.getNext();
        if(this.first == null)
            this.last = null;
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

    public boolean isPalindrome(){
        var isPalindrome = true;
        while(this.first != null && this.last != null && isPalindrome){
            if(!this.first.getInfo().equals(this.last.getInfo()))
                isPalindrome = false;
            this.first = this.first.getNext();
            this.last = this.last.getPrevious();
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
    public MyDoubleIterator<T> iterator() {
        return new MyDoubleIterator<T>(this.first);
    }
}
