package HeapVarieties;

public class HeapOperations {
	public static <Type extends Comparable<? super Type>> boolean isMinHeap(Type[] array) {
		for(int i = 0; i < array.length/2; i++) {
			int childLeft = (i+1)*2-1;
			//if childLeft exists and parent > childLeft
			if(childLeft < array.length && array[i].compareTo(array[childLeft]) > 0)
				return false;
			//if childRight exists and parent > childRight
			int childRight = childLeft + 1;
			if(childRight < array.length && array[i].compareTo(array[childRight]) > 0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] vals = {16, 21, 31, 26, 41, 97, 58, 36, 59, 53};
		if(isMinHeap(vals)) {
			System.out.println("This array is a heap!");
		}
	}
}
