
import java.util.*;

class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList12 {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7,8};
		Node head = generateLinklist(arr);
		Node res = reverseNodes2(head, 3);
		while(res != null) {
			System.out.print(res.value+" ");
			res = res.next;
		}
	}


	public static Node reverseNodes(Node head, int N) {		
		if(N < 2) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node newHead = head;
		Node next = null;
		Node left = null;
		Node cur = head;	
		while(cur != null) {
			next = cur.next;
			stack.push(cur);
			if(stack.size() == N) {
				left = resign(stack, left, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	
	public static Node resign(Stack<Node> stack,Node left, Node right) {
		Node cur = stack.pop();
		Node next = null;
		if(left != null) {
			left.next = cur;
		}
		while(!stack.isEmpty()) {
			next = stack.pop();
			cur.next = next;
			cur = next;
		}
		cur.next = right;
		return cur;
	}

	public static Node reverseNodes2(Node head, int N) {
		if(N < 2) {
			return head;
		}

		int count = 1;
		Node left = null;
		Node start = null;
		Node next = null;
		Node cur = head;
		while(cur != null) {
			next = cur.next;
			if(count == N) {
				start = left == null ? head : left.next;
				head = left == null ? cur : head;
				resign2(left, start, cur, next);
				left = start;
				count = 0;
			}
			count++;
			cur = next;
		}
		return head;
	}	

	public static void resign2(Node left, Node start, Node end, Node right) {
		Node pre = start;
		Node cur = start.next;
		Node next = null;
		while(cur != right) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		if(left != null) {
			left.next = end;
		}
		start.next = right;
	}


	public static Node generateLinklist(int[] arr) {
		Node hNode = null;
		Node tNode = null;
		for(int i = 0; i < arr.length; i++) {
			Node cur = new Node(arr[i]);
			if(hNode == null) {
				hNode = cur;
			} else {
				tNode.next = cur;
			}
			tNode = cur;
		}
		return hNode;
	}
	public static Node reverseList(Node head) {
		Node pre = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	
	}

}
