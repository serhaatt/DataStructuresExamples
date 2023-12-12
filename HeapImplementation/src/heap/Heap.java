package heap;

public interface Heap<Type extends Comparable<? super Type>> {
	public void insert(Type data);
	public Type findMin();
	public Type deleteMin();
	public boolean isEmpty();
	public void makeEmpty();
}
