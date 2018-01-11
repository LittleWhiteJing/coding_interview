
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree15 {
	
	public static void main(String[] args) {
		Node head1 = new Node(6);
		head1.left = new Node(1);
		head1.right = new Node(12);
		head1.left.left = new Node(0);
		head1.left.right = new Node(3);
		head1.right.left = new Node(10);
		head1.right.right = new Node(13);
		head1.right.right.right = new Node(16);
		boolean res1 = isBST(head1);	
		System.out.println(res1);

		Node head2 = new Node(1);
		head2.left = new Node(2);
		head2.right = new Node(3);
		head2.left.left = new Node(4);
		head2.left.right = new Node(5);
		head2.left.left.left = new Node(8);
		head2.left.left.right = new Node(9);
		head2.left.right.left = new Node(10);
		head2.right.left = new Node(6);
		head2.right.right = new Node(7);
		boolean res2 = isCBT(head2);
		System.out.println(res2);
	}

	public static boolean isBST(Node head) {
		if(head == null) {
			return true;
		}
		boolean res = true;
		Node pre = null;
		Node cur1 = head;
		Node cur2 = null;
		while(cur1 != null) {
			cur2 = cur1.left;
			if(cur2 != null) {
				while(cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if(cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if(pre != null && pre.value > cur1.value) {
				return false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}



	public static boolean isCBT(Node head) {
		if(head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;
		Node l = null;
		Node r = null;
		queue.offer(head);
		while(!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if((leaf && (l!=null || r!=null)) || (l==null && r!=null)) {
				return false;
			}
			if(l != null) {
				queue.offer(l);
			}
			if(r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}

}
