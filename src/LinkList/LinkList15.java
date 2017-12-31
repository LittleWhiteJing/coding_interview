
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList15 {
	
	public static void main(String[] args) {
		Node head = new Node(6);
		head.left = new Node(4);
		head.right = new Node(7);
		head.left.left = new Node(2);
		head.left.right = new Node(5);
		head.left.left.left = new Node(1);
		head.left.left.right = new Node(3);
		head.right.right = new Node(9);
		head.right.right.left = new Node(8);
		Node cur = convert2(head);
		while(cur != null) {
			System.out.print(cur.value+" ");
			cur = cur.right;
		}
	}

	public static Node convert(Node head) {
		Queue<Node> queue = new LinkedList<Node>();
		inOrderToQueue(head, queue);
		if(queue.isEmpty()) {
			return head;
		}
		head = queue.poll();
		Node pre = head;
		pre.left = null;
		Node cur = null;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			pre.right = cur;
			cur.left = pre;
			pre = cur;
		}
		pre.right = null;
		return head;
	}

	public static void inOrderToQueue(Node head, Queue<Node> queue) {
		if(head == null) {
			return;
		}
		inOrderToQueue(head.left, queue);
		queue.offer(head);
		inOrderToQueue(head.right,queue);
	}
	
	public static Node convert2(Node head) {
		if(head == null) {
			return null;
		}
		Node last = process(head);
		head = last.right;
		last.right = null;
		return head;

	}

	public static Node process(Node head) {
		if(head == null) {
			return null;
		}
		Node Eleft = process(head.left);
		Node Eright = process(head.right);
		Node Sleft = Eleft == null ? null : Eleft.right;
		Node Sright = Eright == null ? null : Eright.right;
		if(Eleft != null && Eright != null) {
			Eleft.right = head;
			head.left = Eleft;
			Sright.left = head;
			head.right = Sright;
			Eright.right = Sleft;
			return Eright;
		} else if(Eleft != null){
			Eleft.right = head;
			head.left = Eleft;
			head.right = Sleft;
			return head;
		} else if(Eright != null){
			head.right = Sright;
			Sright.left = head;
			Eright.right = head;
			return Eright;
		} else {
			head.right = head;
			return head;
		}

	}





























}
