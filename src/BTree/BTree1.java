
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree1 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2); head.right = new Node(3);
		head.left.left = new Node(4); head.left.right = new Node(5);
		head.right.left = new Node(6); head.right.right = new Node(7);
		preOrderNore(head);
		System.out.println();
		inOrderNore(head);
		System.out.println();
		posOrderNore(head);
	}

	public static void preOrderRecur(Node head) {
		if(head == null) {
			return ;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(Node head) {
		if(head == null) {
			return ;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(Node head) {
		if(head == null) {
			return ;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	public static void preOrderNore(Node head) {
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.push(head);
			while(!stack.isEmpty()) {
				Node cur = stack.pop();
				System.out.print(cur.value + " ");
				if(cur.right != null) {
					stack.push(cur.right);
				}
				if(cur.left != null) {
					stack.push(cur.left);
				}
			}
		}
	}

	public static void inOrderNore(Node head) {
		if(head != null) {
			Stack<Node> stack = new Stack<Node>();
			while(!stack.isEmpty() || head != null) {
				if(head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}	 
			}
		}	
	}

	public static void posOrderNore(Node head) {
		if(head != null) {
			Stack<Node> s1 = new Stack<Node>();
		       	Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while(!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if(head.left != null) {
					s1.push(head.left);
				}
				if(head.right != null) {
					s1.push(head.right);
				}
			}
			while(!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}	
		}	
	}

}





















