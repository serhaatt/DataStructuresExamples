
public class stack_main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Character> myStack = new LinkedListStack<Character>();
		String infix ="(3+4)*7";
		String postfix=new String();
	
		for(int i = 0; i < infix.length(); i++) {
			char ch=infix.charAt(i);
			switch(ch) {
			
				case '(': // save ‘(‘ on stack
					myStack.push(ch);
					myStack.show();
					break;
					
				case ')': // pop stack until matching ‘(‘, and remove ‘(‘

					while (myStack.Top()!='(') {
				          postfix=postfix+(myStack.Top());   
				          myStack.pop(); 
				          myStack.show();
				      }
				      myStack.pop();   
				      break; 
				case '+':  // append operand to end of postfixExpr
				case '-':
				case '*':
				case '/':	
					 myStack.push(ch);
					 myStack.show();
					 break;		// save new operator
					 
				default :  // append operand to end of postfixExpr
					postfix=postfix+ch;   
					break;
					

			}
		}// end of switch and for
		
		// append the operators in the stack to postfixExpr
		while (!myStack.isEmpty()) {
		    postfix=postfix+(myStack.Top()); 
		    //myStack.show();
	 	    myStack.pop(); 
		}
		System.out.println(postfix);

	}
}
