import java.util.*;

class Stack2 {
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.add(2);
		stack.add(5);
		stack.add(6);
		stack.add(3);
		stack.add(7);
		int head = stack.poll();
		System.out.println("Poll element: "+head);
		int curr = stack.peek();
		System.out.println("Peek element: "+curr);
			
	}

}

class MyStack {
	
	private Stack<Integer> StackPush;
	private Stack<Integer> StackPop;

	public MyStack() {
		this.StackPush = new Stack<Integer>();
		this.StackPop = new Stack<Integer>();
	}

	public void add (int newNum) {
		this.StackPush.push(newNum);
	}

	public int poll() {
		if(this.StackPush.empty() && this.StackPop.empty()) {
			throw new RuntimeException("Your stack is empty!");
		} else if(this.StackPop.empty()) {
			while(!this.StackPush.empty()) {
				this.StackPop.push(this.StackPush.pop());
			}
		}
		return this.StackPop.pop();
	}

	public int peek() {
		if(this.StackPush.empty() && this.StackPop.empty()) {
			throw new RuntimeException("Your stack is empty!");
		} else if(this.StackPop.empty()) {
			while(!this.StackPush.empty()) {
				this.StackPop.push(this.StackPush.pop());
			}
		}
		return this.StackPop.peek();
	}



}  
