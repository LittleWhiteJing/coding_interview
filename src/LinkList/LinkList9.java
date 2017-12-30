
import java.util.*;

class Node {
	public int value;
	public Node next;
	public Node rand;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList9 {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		Node head1 = generateLinklist(arr);
		Node head2 = copListWithRand2(head1);
		while(head1 != null) {
			System.out.print(head1.value);
			head1 = head1.next;	
		}
		System.out.println();
		while(head2 != null) {
			System.out.print(head2.value);
			head2 = head2.next;
		}
	
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

	public static Node copListWithRand(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while(cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		} 
		return map.get(head);
	}

	public static Node copListWithRand2(Node head) {
		if(head == null) {
			return head;
		}
		Node cur = head;
		Node next = null;
		while(cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node curCopy = null;
		while(cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		Node res = head.next;
		cur = head;
		while(cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;

	}

}






























