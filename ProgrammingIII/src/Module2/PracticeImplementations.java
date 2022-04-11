package Module2;

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

}
