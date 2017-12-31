
import java.util.*;

class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList14 {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5};
		int value = 3;
		Node head = generateLinklist(arr);
		Node cur = removeValue2(head, value);
		while(cur != null) {
			System.out.print(cur.value+" ");
			cur = cur.next;
		}	
		
	}
	
	public static Node generateLinklist(int[] arr) {
		Node hNode = null;
		Node tNode = null;
		for(int i = 0;i < arr.length; i++) {
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
	

	public static Node removeValue(Node head, int value) {
		Stack<Node> stack = new Stack<Node>();
		while(head != null) {
			if(head.value != value) {
				stack.push(head);
			}
			head = head.next;
		}
	
		while(!stack.isEmpty()) {
			stack.peek().next = head;
			head = stack.pop();
			
		}
		return head;
	}

	public static Node removeValue2(Node head, int value) {
		while(head != null) {
			if(head.value != value) {
				break;
			}
			head = head.next;
		}
		Node pre = head;
		Node cur = head;
		while(cur != null) {
			if(cur.value == value) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}


}







