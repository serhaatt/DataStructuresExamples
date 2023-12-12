package heap;

public class HeapSort {
	public static <Type extends Comparable<? super Type>> void heapSort(Type[] array) {
		for(int i = array.length/2; i >= 0; i--) {
			perculateDown(array, i, array.length);
		}
		
		//for debug purposes only
		System.out.println("After buildHeap: \n" + heapToString(array));
		
		for(int j = array.length-1; j >0; j--) {
			swap(array, 0, j);
			perculateDown(array, 0, j);
		}
	}
	
	private static <Type extends Comparable<? super Type>> void perculateDown(Type[] array, int hole, int len) {
		Type tmp = (Type) array[hole];

		//there is no sentinel value. unlike binaryHeap (where children of i reside at 2*i and 2*i+1),
		//   children of i reside at 2*(i+1)-1 and 2*(i+1)
		//we do not express as 2*i+1 and 2*i+2 on purpose. when i = 0, left child would become -1, since 2*0 = 0!
		int child;
		while((hole+1)*2-1 < len) {
			child = (hole+1)*2-1;
			if(child+1 < len && ((Type) array[child+1]).compareTo((Type) array[child]) > 0)
			//if there is a right child, and its value is smaller than the left child; proceed with the right child.
				child++;
			if(((Type) array[child]).compareTo(tmp) > 0) //if tmp is greater than the smaller child
				array[hole] = array[child]; //percolate down by replacing with child
			else //reached a level where smallest child has a greater (or equal) value, terminate. 
				break;
			hole = child;
		}
		array[hole] = tmp;
	}
	
	private static <Type> void swap(Type[] array, int source, int dest) {
		Type tmp = array[source];
		array[source] = array[dest];
		array[dest] = tmp;
	}
	
	private static <Type> String heapToString(Type[] array) { //similar to an array's String representation. skips the sentinel!
		String res = "[" + array[0].toString();
		for(int i = 1; i < array.length; i++)
			res = res + ", " + array[i].toString();
		res = res + "]";
		return res;
	}
	
	public static void main(String[] args) {
		Integer[] vals = {59, 36, 58, 21, 41, 97, 31, 16, 26, 53};
		
		System.out.println("Array before sorting:");
		String res = "[" + vals[0].toString();
		for(int i = 1; i < vals.length; i++)
			res = res + ", " + vals[i];
		res = res + "]";
		System.out.println(res);
		
		heapSort(vals);
		
		System.out.println("Array after sorting:");
		res = "[" + vals[0].toString();
		for(int i = 1; i < vals.length; i++)
			res = res + ", " + vals[i];
		res = res + "]";
		System.out.println(res);
	}
}
