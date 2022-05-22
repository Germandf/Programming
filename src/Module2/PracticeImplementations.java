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

    // O(n^2)
    public static void bubbleSort(int[] array){
        int aux;
        for (int i = 0; i <= array.length; i++) {
            for (int j = 0; j <= array.length - i; j++) {
                if(array[j] > array[j + 1]){
                    aux = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = aux;
                }
            }
        }
    }

    // O(n^2)
    public static void selectionSort(int[] array){
        for (int i = 0; i <= array.length; i++) {
            int min_ix = i;
            for (int j = i + 1; j <= array.length - i; j++)
                if(array[j] < array[min_ix])
                    min_ix = j;
            int aux = array[i];
            array[i] = array[min_ix];
            array[min_ix] = aux;
        }
    }

    // O(log2 n)
    public static void mergeSort(int[] array) {
        if (array.length < 2)
            return;
        int[] arrayLeft = new int[array.length / 2];
        int[] arrayRight = new int[array.length - array.length / 2];
        for (int i = 0; i < array.length / 2; i++)
            arrayLeft[i] = array[i];
        for (int i = array.length / 2; i < array.length; i++)
            arrayRight[i - array.length / 2] = array[i];
        mergeSort(arrayLeft);
        mergeSort(arrayRight);
        merge(array, arrayLeft, arrayRight);
    }

    public static void merge(int[] array, int[] arrayLeft, int[] arrayRight) {
        int i = 0, j = 0, k = 0;
        while (i < arrayLeft.length && j < arrayRight.length)
            if (arrayLeft[i] <= arrayRight[j])
                array[k++] = arrayLeft[i++];
            else
                array[k++] = arrayRight[j++];
        while (i < arrayLeft.length)
            array[k++] = arrayLeft[i++];
        while (j < arrayRight.length)
            array[k++] = arrayRight[j++];
    }

    // O(n^2)
    public static void quickSort(int[] array){
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int startingIx, int endingIx)
    {
        if (startingIx >= endingIx)
            return;
        int pivotIx = quickSortPartition(array, startingIx, endingIx);
        quickSort(array, startingIx, pivotIx - 1);
        quickSort(array, pivotIx + 1, endingIx);
    }

    private static int quickSortPartition(int[] array, int startingIx, int endingIx)
    {
        int pivot = array[endingIx];
        int i = startingIx;
        for(int j = startingIx; j < endingIx; j++)
            if (array[j] < pivot)
            {
                swap(array, i, j);
                i++;
            }
        swap(array, i, endingIx);
        return i;
    }

    private static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
