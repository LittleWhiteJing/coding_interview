import java.util.*;

class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}	
}

class LinkList7 {

	public static void main(String[] args) {
		int[] arr1 = new int[]{1,2,3,3,2,1};
		int[] arr2 = new int[]{1,2,3,4,5,6};
		Node head1 = generateLinklist(arr1);
		Node head2 = generateLinklist(arr2);
		boolean r1 = isPalindrome3(head1);
		boolean r2 = isPalindrome3(head2);
		System.out.println("Result1 is "+r1);
		System.out.println("Result2 is "+r2);	
	}

	public static Node generateLinklist(int[] arr) {
		Node head = null;
		Node tail = null;
		for(int i = 0; i < arr.length; i++) {
			Node cur = new Node(arr[i]);
			if(head == null) {
				head = cur;
			} else {
				tail.next = cur;
			}
			tail = cur;
		}
		return head;
	}

	public static boolean isPalindrome(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		Node cur = head;
		while(cur != null) {
			stack.push(cur.value);
			cur = cur.next;
		}
		while(head != null) {
			if(head.value != stack.pop()){
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static boolean isPalindrome2(Node head) {
		if(head == null || head.next == null) {
			return true;
		}

		Node right = head.next;
		Node cur = head;
		while(cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<Integer> stack = new Stack<Integer>();
		while(right != null) {
			stack.push(right.value);
			right = right.next;
		}
		while(!stack.isEmpty()) {
			if(stack.pop() != head.value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	public static boolean isPalindrome3(Node head) {
		if(head == null || head.next == null) {
			return true;
		}

		Node n1 = head;
		Node n2 = head;

		while(n2.next != null && n2.next.next != null) {
			n1 = n1.next;
			n2 = n2.next.next;
		}

		n2 = n1.next;
		n1.next = null;
		Node n3 = null;
		while(n2 != null) {
			n3 = n2.next;
			n1.next = n2;
			n1 = n2;
			n2 = n3;
		}
		n3 = n1;
		n2 = head;
		boolean res = true;
		while(n1 != null && n2 != null) {
			if(n1.value != n2.value) {
				return false;
			}
			n1 = n1.next;
			n2 = n2.next;
		}
	
		n2 = n3.next;
		n3.next = null;
		while(n2 != null){
			n1 = n2.next;
			n2.next = n3;
			n3 = n2;
			n2 = n1;
		}

		return true;	
	}


}
