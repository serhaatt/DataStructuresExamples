
public class stack_main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//you have a language w$w'enter a string then 
		//find your string is accept or not for the language
		
		Stack<Character> myStack = new LinkedListStack<Character>();
		String str ="abc$cba";
		Boolean flag=false;

		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)!= '$' && flag==false) {
				myStack.push(str.charAt(i));
				myStack.show();
			}
			else if(str.charAt(i)=='$') flag=true;
			
			else if(flag==true){
				if(!myStack.isEmpty() && myStack.Top()==str.charAt(i))
					myStack.pop();
					myStack.show();
			}
				
		}
		
		//if(myStack.isEmpty())
		if (myStack.Top()==null) {
			System.out.println("Your string is in the language");
		}
		else {
			System.out.println("Your string is not in the language");
		}
	}

}
