package Module2;

public class Program {

	public static void main(String[] args) {
		int[] arrayOrdered = new int[] { 1, 2, 3, 4, 5 };
		int[] arrayNotOrdered = new int[] { 1, 2, 4, 3, 5 };
		boolean isOrdered1 = PracticeImplementations.arrayIsOrdered(arrayOrdered, 0);
		boolean isOrdered2 = PracticeImplementations.arrayIsOrdered(arrayNotOrdered, 0);
		System.out.println(isOrdered1);
		System.out.println(isOrdered2);
	}

}