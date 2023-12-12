package HeapVarieties;
import heap.BinaryHeap;

class MinHeapNode<Type> implements Comparable<MinHeapNode<Type>>{
	//a simple counter of nodes created during this execution
	static long logicalTime = 0;
	Type data;
	long time;
	public MinHeapNode(Type data) {
		this.data = data;
		this.time = logicalTime++;
	}
	
	@Override
	public int compareTo(MinHeapNode<Type> that) {
		//any node created earlier has higher priority
		if(this.time < that.time)
			return -1;
		else if(this.time == that.time)
			return 0;
		else
			return 1;
	}
}

public class BinaryHeapQueue<Type> implements Queue<Type> {
	BinaryHeap<MinHeapNode<Type>> heap = new BinaryHeap<>();
	
	@Override
	public void enqueue(Type data) {
		heap.insert(new MinHeapNode<>(data));
	}

	@Override
	public Type dequeue() {
		return heap.deleteMin().data;
	}

	@Override
	public Type front() {
		return heap.findMin().data;
	}

	@Override
	public boolean isEmpty() {
		return heap.isEmpty();
	}
	
	public static void main(String[] args) {
		BinaryHeapQueue<Integer> queue = new BinaryHeapQueue<>();
		queue.enqueue(1000);
		queue.enqueue(20);
		System.out.println(queue.dequeue());
		queue.enqueue(5);
		queue.enqueue(200000);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
	}
}