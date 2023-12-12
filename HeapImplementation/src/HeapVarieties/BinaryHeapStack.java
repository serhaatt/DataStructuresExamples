package HeapVarieties;
import heap.BinaryHeap;

class MaxHeapNode<Type> implements Comparable<MaxHeapNode<Type>>{
	//a simple counter of nodes created during this execution
	static long logicalTime = 0;
	Type data;
	long time;
	public MaxHeapNode(Type data) {
		this.data = data;
		this.time = logicalTime++;
	}
	
	@Override
	public int compareTo(MaxHeapNode<Type> that) {
		//any node created earlier has lower priority
		if(this.time < that.time)
			return 1;
		else if(this.time == that.time)
			return 0;
		else
			return -1;
	}
}

public class BinaryHeapStack<Type> implements Stack<Type>{
	BinaryHeap<MaxHeapNode<Type>> heap = new BinaryHeap<>();
	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}

	@Override
	public void push(Type data) {
		heap.insert(new MaxHeapNode<>(data));
	}

	@Override
	public Type pop() {
		return heap.deleteMin().data;
	}

	@Override
	public Type top() {
		return heap.findMin().data;
	}
	
	public static void main(String[] args) {
		BinaryHeapStack<Integer> stack = new BinaryHeapStack<>();
		stack.push(1000);
		stack.push(20);
		System.out.println(stack.pop());
		stack.push(5);
		stack.push(200000);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}
}
