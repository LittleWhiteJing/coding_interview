import java.util.*;

class Stack5 {

	public static void main(String[] args) {
		
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(8);
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(6);
		sortStack(stack);

		int top = stack.pop();
		System.out.println("The top of the stack: "+top);
	
	}
	
	public static void sortStack(Stack<Integer> stack) {
		
		Stack<Integer> help = new Stack<Integer>();

		while(!stack.isEmpty()) {
			int cur = stack.pop();
			while(!help.isEmpty() && cur > help.peek()) {
				stack.push(help.pop());
			}
			help.push(cur);	
		}

		while(!help.isEmpty()) {
			stack.push(help.pop());
		
		}
	}

}
