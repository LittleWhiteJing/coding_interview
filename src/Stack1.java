import java.util.*;

class Stack1 {

	public static void main(String[] args){
		
		MyStack2 stack = new MyStack2();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(7);
		stack.push(1);
		int minelem = stack.getMin();
		System.out.println("Min Elememt:"+minelem);
		int temp1 = stack.pop();
		int temp2 = stack.pop();
		minelem = stack.getMin();
		System.out.println("Pop Element:"+temp1+" and "+temp2);
		System.out.println("Min Element:"+minelem);
		
	}

}

class MyStack1 {

	private Stack<Integer> StackData;
	private Stack<Integer> StackMin;

	public MyStack1() {
		this.StackData = new Stack<Integer>();
		this.StackMin = new Stack<Integer>();
	}	

	public void push(int newNum) {
		if(this.StackMin.isEmpty()) {
			this.StackMin.push(newNum);
		} else if(newNum <= this.getMin()){
			this.StackMin.push(newNum);
		}
		this.StackData.push(newNum);
	}

	public int pop() {
		if(this.StackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty!"); 
		}	
		int value = this.StackData.pop();
		if(value == this.getMin()) {
			this.StackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if(this.StackMin.isEmpty()){
			throw new RuntimeException("Your stack is empty!");
		}
		return this.StackMin.peek();
	}

}

class MyStack2 {
	
	private Stack<Integer> StackData;
	private Stack<Integer> StackMin;

	public MyStack2() {
		this.StackData = new Stack<Integer>();
		this.StackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if(this.StackMin.isEmpty()) {
			this.StackMin.push(newNum);
		} else if(newNum <= getMin()) {
			this.StackMin.push(newNum);
		} else {
			this.StackMin.push(getMin());
		}
		this.StackData.push(newNum);
	}

	public int pop() {
		if(this.StackData.isEmpty()){
			throw new RuntimeException("Your stack is empty!");
		}
		int value = this.StackData.pop();
		this.StackMin.pop();
	       	return value;	
	}

	public int getMin() {
		if(this.StackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty!");
		}
		return this.StackMin.peek();
	}
	

}












