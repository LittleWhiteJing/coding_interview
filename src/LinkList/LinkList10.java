
import java.util.*;

class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList10 {
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{1,2,3};
		int[] arr2 = new int[]{1,2,7};
	       	Node head1 = generateLinklist(arr1);
		Node head2 = generateLinklist(arr2);
		Node res = addLists2(head1, head2);
		while(res != null) {
			System.out.print(res.value+" ");
			res = res.next;
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

	public static Node addLists(Node head1, Node head2) {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();
		Node cur1 = head1;
		Node cur2 = head2;
		while(cur1 != null) {
			stack1.push(cur1.value);
			cur1 = cur1.next;
		}
		while(cur2 != null) {
			stack2.push(cur2.value);
			cur2 = cur2.next;
		}
		int n1 = 0;
		int n2 = 0;
		int ca = 0;
		int sum = 0;
		Node pre = null;
		Node node = null;
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			n1 = stack1.isEmpty() ? 0 : stack1.pop();
			n2 = stack2.isEmpty() ? 0 : stack2.pop();
			sum = n1 + n2 + ca;
			pre = node;
			node = new Node(sum % 10);
			node.next = pre;
			ca = sum/10;
		}
		if(ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		return node;
	}

	public static Node addLists2(Node head1, Node head2) {
		Node res1 = reverseList(head1);
		Node res2 = reverseList(head2);

		Node c1 = res1;
		Node c2 = res2;

		int n1 = 0;
		int n2 = 0;
		int sum = 0;
		int ca = 0;
		Node pre;
		Node node = null;

		while(c1 != null || c2 != null) {
			n1 = c1 == null ? 0 : c1.value;
			n2 = c2 == null ? 0 : c2.value;
			sum = n1 + n2 + ca;
			pre = node;
			node = new Node(sum % 10);
			node.next = pre;
			ca = sum / 10;
			c1 = c1.next;
			c2 = c2.next;
		}	
		if(ca == 1) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}
		reverseList(res1);
		reverseList(res2);
		return node;
	
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

