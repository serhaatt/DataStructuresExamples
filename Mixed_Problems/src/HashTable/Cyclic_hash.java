package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Cyclic_hash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
	    Set<ListNode> nodesSeen = new HashSet<>();
	    while (head != null) {
	        if (nodesSeen.contains(head)) {
	            return true;
	        } else {
	            nodesSeen.add(head);
	        }
	        head = head.next;
	    }
	    return false;
	}
	
	public class ListNode{
		int key;
	    ListNode next;
	}


}
