package HeapVarieties;


public interface Stack<Type> {
	/**
	 * Checks if the stack is empty or not
	 * @return true if empty, false otherwise
	 */
	boolean isEmpty();
	
	/**
	 * Adds a new item to the stack
	 * @param item Item to be added
	 */
	void push(Type item);
	
	/**
	 * Remove the top item from the stack
	 * @return Top item (removed)
	 */
	Type pop(); 
	
	/**
	 * Peeks at the top item without removing it
	 * @return Top item (not removed)
	 */
	Type top();
}
