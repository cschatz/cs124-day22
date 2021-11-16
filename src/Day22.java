import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	public static <E extends Comparable<E>> void
					merge(ArrayList<E> listA, ArrayList<E> listB, ArrayList<E> out) {
		// Assume listA and listB are ALREADY SORTED
		// Assume out is empty
		int a = 0;
		int b = 0;
		
		// keep going until the end of one list
		while (a < listA.size() && b < listB.size()) {
			// compare the current element from each list
			if (listA.get(a).compareTo(listB.get(b)) < 0) {
				// element from listA goes into out next
				out.add(listA.get(a));
				a++;
			} else {
				out.add(listB.get(b));
				b++;
			}
		}
		
		// go through anything left in listA
		while (a < listA.size()) {
			out.add(listA.get(a));
			a++;
		}
		
		// go through anything left in listB
		while (b < listB.size()) {
			out.add(listB.get(b));
			b++;
		}
		
	}
	
	
	

	public static void main(String[] args) {
//		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(7, 3, 5, 1, 4, 0, 2));
//
//		show(nums);
//		selectionSort(nums);
//		show(nums);
		
		ArrayList<Integer> nums1 = new ArrayList<Integer>(Arrays.asList(2, 3, 7, 8, 9));
		ArrayList<Integer> nums2 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 6, 10));
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		merge(nums1, nums2, result);
		show(result);
	}

}
