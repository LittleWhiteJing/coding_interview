
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree10 {

	public static void main(String[] args) {
		Node head = new Node(6);
		head.left = new Node(1);
		head.right = new Node(12);
		head.left.left = new Node(0);
		head.left.right = new Node(13);
		head.right.left = new Node(10);
		head.right.right = new Node(3);
		head.right.right.right = new Node(16);	
		Node[] arr = getTwoErrNodes(head);
		System.out.println(arr[0].value + " " + arr[1].value);
	}

	public static Node[] getTwoErrNodes(Node head) {
		Node[] errs = new Node[2];
		if(head == null) {
			return errs;
		}
		Stack<Node> stack = new Stack<Node>();
		Node pre = null;
		while(!stack.isEmpty() || head != null) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				if(pre != null && pre.value > head.value) {
					errs[0] = errs[0] == null ? pre : errs[0];
					errs[1] = head;
				}
				pre = head;
				head = head.right;
			}
		}
		return errs;
	}
	
	
}
