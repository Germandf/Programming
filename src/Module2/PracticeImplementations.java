package Module2;

import java.util.Iterator;

public class PracticeImplementations {

    // O(n)
    public static boolean arrayIsOrdered(int[] array, int position){
        if(position < 0 || position >= array.length)
            return true;
        if(arrayIsOrdered(array, position + 1))
            return array[position] < array[position + 1];
        else
            return false;
    }

    // O(n)
    public static boolean valueExistsInList(Iterator<Integer> iterator, int value){
        if (!iterator.hasNext())
            return false;
        if(iterator.next().equals(value))
            return true;
        else
            return valueExistsInList(iterator, value);
    }

    // O(n)
    public static boolean valueExistsInOrderedArray(int[] array, int value, int position){
        if(position < 0 || position >= array.length)
            return false;
        if(array[position] == value)
            return true;
        else
            return valueExistsInOrderedArray(array, value, position + 1);
    }

    // O(n)
    public static int decimalToBinary(int decimal){
        if (decimal <= 0)
            return 0;
        else
            return decimal % 2 + 10 * (decimalToBinary(decimal / 2));
    }

}
