package hashTable;

public interface HashTable<Type> {
	public void makeEmpty();
	public boolean contains(Type data);
	public Type find(Type data);
	public void insert(Type data);
	public void remove(Type data);
}
