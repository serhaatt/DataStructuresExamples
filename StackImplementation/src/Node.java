
public class Node<Type> {
	
	protected Type data;
	protected Node<Type> next;
	
	public Node (Type data,Node<Type> next) {
		this.data=data;
		this.next=next;
	}
}
