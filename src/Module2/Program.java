package Module2;

import java.util.Arrays;
import java.util.LinkedList;

public class Program {

	public static void main(String[] args) {
		int[] arrayOrdered = new int[] { 1, 2, 3, 4, 5 };
		int[] arrayNotOrdered = new int[] { 1, 2, 4, 3, 5 };
		LinkedList<Integer> list = new LinkedList(Arrays.asList(1, 2, 3, 4, 5));
		// Exercise 1
		System.out.println(PracticeImplementations.arrayIsOrdered(arrayOrdered, 0));
		System.out.println(PracticeImplementations.arrayIsOrdered(arrayNotOrdered, 0));
		// Exercise 2
		System.out.println(PracticeImplementations.valueExistsInList(list.iterator(), 4));
		System.out.println(PracticeImplementations.valueExistsInList(list.iterator(), 6));
		System.out.println(PracticeImplementations.valueExistsInOrderedArray(arrayOrdered, 4, 0));
		System.out.println(PracticeImplementations.valueExistsInOrderedArray(arrayOrdered, 6, 0));
	}

}