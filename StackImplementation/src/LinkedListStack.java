
public class LinkedListStack<Type> implements Stack<Type> {
	private Node<Type> top;
	
	public LinkedListStack() {
		top=null;
	}
	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return top==null;
	}

	@Override
	public void push(Type item) {
		// TODO Auto-generated method stub
		
		//new node that points to current top
		Node<Type> newNode = new Node<>(item, top);
		
		// update top to be new node
		top = newNode;

	}

	@Override
	public Type pop() {
		// TODO Auto-generated method stub
		if(top==null) {
			return null;
		}
		Type retval=top.data;
		top=top.next; //update stack up
		return retval;
	}

	@Override
	public Type Top() {
		// TODO Auto-generated method stub
		if(top==null) {
			return null;
		}
		return top.data;
	}


	@Override
	public Type show() {
		// TODO Auto-generated method stub
		Node curr = top;
		System.out.print("-->");
		
		while(curr!=null) {
			System.out.print(curr.data.toString()+"-->");
			curr=curr.next;
		}
		System.out.println("null");
		return null;
	}
}
