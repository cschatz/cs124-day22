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
	
	public static <E> void show(E[] items) {
		for (E item : items) {
			System.out.print(item + " ");
		}
		System.out.println();
	}
	
	
	private static <E extends Comparable<E>> void
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
	
	public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) {
		// Base case: empty list or 1-element list
		if (list.size() <= 1)
			return;
		
		// divide into two halves
		int halfway = list.size() / 2;
		
		ArrayList<E> leftHalf = new ArrayList<E>(list.subList(0, halfway));
		ArrayList<E> rightHalf = new ArrayList<E>(list.subList(halfway, list.size()));
		
		mergeSort(leftHalf);
		mergeSort(rightHalf);
		
		list.clear();
		merge(leftHalf, rightHalf, list);
	}
	
	private static <E extends Comparable<E>> int partition(E[] items, int begin, int end) {
		// arbitrarily pick the pivot
		E pivot = items[begin];
		// set up bookends
		int left = begin;
		int right = end+1;
		// temp variable to enable swapping
		E temp;
		
		// keep checking and swapping until the bookends meet
		while (left < right-1) {
			// move the left bookend forward as far as possible
			while (left < right-1 && items[left+1].compareTo(pivot) < 0) {
				left++;
			}
			// move right bookend backward as far as possible
			while (left < right-1 && items[right-1].compareTo(pivot) > 0) {
				right--;
			}
			
			if (left < right-1) {
				// swap elements beyond each bookend
				temp = items[left+1];
				items[left+1] = items[right-1];
				items[right-1] = temp;
				left++;
				right--;
			}
		}
		
		// swap the pivot into its final location (index #left)
		temp = items[right-1];
		items[right-1] = pivot;
		items[begin] = temp;
		
		// return the final position of the pivot
		return left;
	}
	
	private static <E extends Comparable<E>> void quickSortHelper(E[] items, int begin, int end) {
		// base case: 0 or 1 elements
		if (begin >= end) {
			return;
		}
		int pivotPosition = partition(items, begin, end);
		// We know all items are correctly arranged with respect to the pivot
		// So recursively sort both sides
		quickSortHelper(items, begin, pivotPosition-1);
		quickSortHelper(items, pivotPosition+1, end);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] items) {
		quickSortHelper(items, 0, items.length-1);
	}

	public static void main(String[] args) {
//		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(7, 3, 5, 1, 4, 0, 2));
//
//		show(nums);
//		selectionSort(nums);
//		show(nums);
		
//		ArrayList<Integer> nums1 = new ArrayList<Integer>(Arrays.asList(2, 3, 7, 8, 9));
//		ArrayList<Integer> nums2 = new ArrayList<Integer>(Arrays.asList(1, 4, 5, 6, 10));
//		ArrayList<Integer> result = new ArrayList<Integer>();
//		
//		merge(nums1, nums2, result);
//		show(result);
		
//		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(7, 3, 5, 1, 4, 0, 2));
//		show(nums);
//		mergeSort(nums);
//		show(nums);
		
		
		Integer[] nums = { 7, 11, 10, 3, 6, 5, 4, 1, 12, 9, 8, 2 };
		show(nums);
		quickSort(nums);
		show(nums);
	}

}
