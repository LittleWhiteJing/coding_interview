import java.util.*;

class Stack3 {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(3);
		stack.push(6);
		stack.push(2);
		stack.push(7);
		stack.push(5);
		reverse(stack);
		int first = stack.pop();
		int second = stack.pop();
		int third = stack.pop();
		System.out.println("first: "+first);
		System.out.println("second: "+second);
		System.out.println("third: "+third);
		
	}
	
	public static int getStackBottom(Stack<Integer> stack) {
		int result = stack.pop();
		if(stack.empty()) {
			return result;
		} else {
			int last = getStackBottom(stack);
			stack.push(result);
			return last;
		}
	}

	public static void reverse(Stack<Integer> stack) {
		if(stack.empty()) {
			return;
		}
		int i = getStackBottom(stack);
		reverse(stack);
		stack.push(i);
	} 


}


