
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree9 {
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.right.left.left = new Node(7);
		head.right.left.right = new Node(8);
		printByZigZag(head);
	}

	public static void printByLevel(Node head) {
		if(head == null) {
			return ;
		}
		Queue<Node> queue = new LinkedList<Node>();
		int level = 1;
		Node last = head;
		Node nlast = null;
		queue.offer(head);
		System.out.print("Level " + (level++) + " : ");
		while(!queue.isEmpty()) {
			head = queue.poll();
			System.out.print(head.value + " ");
			if(head.left != null) {
				queue.offer(head.left);
				nlast = head.left;
			}
			if(head.right != null) {
				queue.offer(head.right);
				nlast = head.right;
			}
			if(last == head && !queue.isEmpty()) {
				System.out.print("\nLevel " + (level++) + " : ");
				last = nlast;
			}
		}
		System.out.println();
	}
	
	public static void printByZigZag(Node head) {
		if(head == null) {
			return ;
		}
		Deque<Node> dq = new LinkedList<Node>();
		int level = 1;
		boolean lr = true;
		Node last = head;
		Node nLast = null;
		dq.offerFirst(head);
		printLevelAndOrientation(level++, lr);
		while(!dq.isEmpty()) {
			if(lr) {
				head = dq.pollFirst();
				if(head.left != null) {
					nLast = nLast == null ? head.left : nLast;
					dq.offerLast(head.left);
				}
				if(head.right != null) {
					nLast = nLast == null ? head.right : nLast;
					dq.offerLast(head.right);
				}
			} else {
				head = dq.pollLast();
				if(head.right != null) {
					nLast = nLast == null ? head.right : nLast;
					dq.offerFirst(head.right);
				} 
				if(head.left != null) {
					nLast = nLast == null ? head.left : nLast;
					dq.offerFirst(head.left);
				}
			}
			System.out.print(head.value + " ");
			if(head == last && !dq.isEmpty()) {
				lr = !lr;
			        last = nLast;
				nLast = null;
				System.out.println();
				printLevelAndOrientation(level++, lr);	
			}
		}
		System.out.println();
	}

	public static void printLevelAndOrientation(int level, boolean lr) {
		System.out.print("Level " + level + " from ");
		System.out.print(lr ? "left to right: " : "right to left: ");
	}

}

