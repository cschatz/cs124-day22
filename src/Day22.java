import java.util.ArrayList;
import java.util.Collections;

public class Day22 {
	
	
	public static <E extends Comparable<E>> void selectionSort(ArrayList<E> items) {
		// pos: starting position (changes each round)
		for (int pos = 0; pos <= items.size()-2; pos++) {
			// scan all elements from pos upward
			// find the smallest one
			E smallestValue = items.get(pos);
			int smallestIndex = pos;
			for (int i = pos+1; i < items.size(); i++) {
				E current = items.get(i);
				if (current.compareTo(smallestValue) < 0) {
					smallestValue = current;
					smallestIndex = i;
				}
			}
			// swap the smallest into position #pos
			Collections.swap(items, pos, smallestIndex);
		}
	}
	
	public static <E> void show(ArrayList<E> items) {
		for (E item : items) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {


	}

}
