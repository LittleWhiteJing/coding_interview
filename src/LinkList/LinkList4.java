class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class DoubleNode {
	public int value;
	public DoubleNode last;
	public DoubleNode next;
	public DoubleNode(int data) {
		this.value = data;
	}
}

class LinkList4 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5};
		Node head = generateList(arr);
		Node cur = reverseList(head);
		while(cur != null) {
			System.out.print(cur.value+" ");
			cur = cur.next;
		}
	}
	
	public static Node generateList(int[] arr) {
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

	public static DoubleNode reverseList(DoubleNode head) {
		DoubleNode pre = null;
		DoubleNode next = null;
		while(head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}

}
