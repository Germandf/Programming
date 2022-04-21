package Module1;

public class Pile<T> {

    MySimpleLinkedList<T> list;

    public Pile() {
        this.list = new MySimpleLinkedList<T>();
    }

    public void push(T info){
        list.insertFront(info);
    }

    public T pop(){
        return list.extractFront();
    }

    public T top(){
        var tmp = list.extractFront();
        list.insertFront(tmp);
        return tmp;
    }

    public void reverse(){
        var size = list.size();
        var newList = new MySimpleLinkedList<T>();
        for(int i = 0; i < size; i++)
            newList.insertFront(this.list.extractFront());
        this.list = newList;
    }

}
