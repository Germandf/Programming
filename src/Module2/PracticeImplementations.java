package Module2;

import java.util.Iterator;

public class PracticeImplementations {

    public static boolean arrayIsOrdered(int[] array, int position){
        if(position < 0 || position >= array.length - 1)
            return true;
        if(arrayIsOrdered(array, position + 1)){
            return array[position] < array[position + 1];
        }
        else{
            return false;
        }
    }

    public static boolean valueExistsInList(Iterator<Integer> iterator, int value){
        if (iterator.hasNext()){
            if(iterator.next().equals(value)){
                return true;
            }
            else{
                return valueExistsInList(iterator, value);
            }
        }
        return false;
    }

    public static boolean valueExistsInOrderedArray(int[] array, int value, int position){
        if(position < 0 || position >= array.length - 1)
            return false;
        if(!valueExistsInOrderedArray(array, value, position + 1)){
            return array[position] == value;
        }
        else{
            return true;
        }
    }

}
