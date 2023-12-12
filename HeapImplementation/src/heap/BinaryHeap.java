package heap;

public class BinaryHeap<Type extends Comparable<? super Type>> implements Heap<Type>{

	private static final int DEFAULT_CAPACITY = 17;
	private Object[] array;
	private int size;
	
	public BinaryHeap() {
		array = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	public BinaryHeap(int capacity) {
		array = new Object[capacity+1];
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void makeEmpty() {
		array = new Object[DEFAULT_CAPACITY];
		size = 0;
	}
	
	private void expandCapacity() {
		Object[] newArray = new Object[array.length*2];
		for(int i = 1; i <= size; i++) { //cannot use front & back anymore
			//back or front or both may have crossed the array's end due to circular structure
			newArray[i] = array[i];
		}
		array = newArray;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insert(Type data) {
		if (size == array.length-1)
			expandCapacity();
		
		//Percolate up
		int hole = ++size;
		array[0] = data; //initialize the sentinel
		//the step above is necessary in the case that data percolates 
		//  all the way up to the root. In that case, we ensure that 
		//  data.compareTo(array[0]) returns 0 and we terminate the loop
		//skipping this operation requires additional control on hole > 0
		while(data.compareTo((Type) array[hole/2]) < 0) {
			array[hole] = array[hole/2]; //parent becomes child, hole moves up
			hole = hole/2;
		}
		array[hole] = data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Type findMin() {
		if(isEmpty())
			return null;
		return (Type) array[1]; //smallest item is at the root
	}

	@Override
	public Type deleteMin() {
		if(isEmpty())
			return null;
		
		Type minItem = findMin(); //returns array[1]
		array[1] = array[size]; //last item becomes the first item 
		size--; //# of items is decremented
		percolateDown(1); //items at array[1] potentially violates the heap property. fix this by percolating it down
		
		return minItem;
	}
	
	@SuppressWarnings("unchecked")
	private void percolateDown(int hole) { //tmp = 2  hole = 2 child = 4
		Type tmp = (Type) array[hole];

		int child;
		while(hole*2 <= size) {
			child = hole*2;
			if(child != size && ((Type) array[child+1]).compareTo((Type) array[child]) < 0)
			//if there is a right child, and its value is smaller than the left child; proceed with the right child.
				child++;
			if(((Type) array[child]).compareTo(tmp) < 0) //if tmp is greater than the smaller child
				array[hole] = array[child]; //percolate down by replacing with child
			else //reached a level where smallest child has a greater (or equal) value, terminate. 
				break;
			hole = child;
		}
		array[hole] = tmp;
	}
	
	public BinaryHeap(Type[] array) {
		//reserve sufficient capacity
		int capacity = (int) Math.pow(2, Math.ceil(Math.log(array.length)) + 1) + 1;
		this.array = new Object[capacity];
		size = array.length; 
		
		//copy items in the order they are provided
		for(int i = 1; i <= array.length; i++)
			this.array[i] = array[i-1];
		
		//heapify all contents
		buildHeap();
	}
	
	private void buildHeap() {
		for(int i = size/2; i > 0; i--)
			percolateDown(i);
	}
	
	public String toString() { //similar to an array's String representation. skips the sentinel!
		String res = "[";
		if(size > 0)
			res = res + array[1].toString();
		for(int i = 2; i <= size; i++)
			res = res + ", " + array[i].toString();
		res = res + "]";
		return res;
	}
	
	public static void main(String[] args) {
		Heap<Integer> heap = new BinaryHeap<>();
		System.out.println("Empty heap:\n" + heap.toString());
		heap.insert(10);
		System.out.println("After insert(10):\n" + heap.toString());
		heap.insert(20);
		System.out.println("After insert(20):\n" + heap.toString());
		heap.insert(100);
		System.out.println("After insert(100):\n" + heap.toString());
		heap.insert(2);
		System.out.println("After insert(2):\n" + heap.toString());
		heap.deleteMin();
		System.out.println("After deleteMin():\n" + heap.toString());
		heap.deleteMin();
		System.out.println("After deleteMin():\n" + heap.toString());
		
		Integer[] vals = {59, 36, 58, 21, 41, 97, 31, 16, 26, 53};
		heap = new BinaryHeap<>(vals);
		System.out.println("buildHeap result:\n" + heap.toString());
		
	}
}
