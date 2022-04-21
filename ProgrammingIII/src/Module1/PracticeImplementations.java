package Module1;

public class PracticeImplementations {

    public static <T extends Comparable<T>> MySimpleLinkedList<T> GetOrderedListWithCommonValuesFromOrderedLists(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        var newOrderedList = new MySimpleLinkedList<T>();
        var it1 = list1.iterator();
        var it2 = list1.iterator();
        while(it1.hasNext() && it2.hasNext()){
            var info1 = it1.getCurrent();
            var info2 = it2.getCurrent();
            if (info1.compareTo(info2) > 0){
                it1.next();
            } else if (info1.compareTo(info2) < 0){
                it2.next();
            } else{
                newOrderedList.insertFront(info1);
                it1.next();
                it2.next();
            }
        }
        return newOrderedList;
    }

    public static <T extends Comparable<T>> MySimpleLinkedList<T> GetOrderedListWithCommonValuesFromUnorderedLists(MySimpleLinkedList<T> list1, MySimpleLinkedList<T> list2){
        var newList = new MySimpleLinkedList<T>();
        var it1 = list1.iterator();
        while(it1.hasNext()){
            var info1 = it1.next();
            var it2 = list1.iterator();
            var found = false;
            while(it2.hasNext() || found == false){
                var info2 = it2.next();
                if(info1 == info2){
                    newList.insertFront(info1);
                    found = true;
                }
            }
        }
        newList.sort();
        return newList;
    }

}
