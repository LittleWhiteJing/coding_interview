
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree16 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		Node head = generateTree(arr);
		inOrderNorec(head);
	}

	public static void inOrderNorec(Node head) {
		if(head == null) {
			return ;
		}
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

	public static Node generateTree(int[] sortArr) {
		if(sortArr == null) {
			return null;
		}
		return generate(sortArr, 0, sortArr.length-1);
	}

	public static Node generate(int[] sortArr, int start, int end) {
		if(start > end) {
			return null;
		}
		int mid = (start + end)/2;
		Node head = new Node(sortArr[mid]);
		head.left = generate(sortArr, start, mid - 1);
		head.right = generate(sortArr, mid + 1, end);
		return head;
	}

}
