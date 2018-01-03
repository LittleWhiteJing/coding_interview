class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList20 {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6,7};
		Node head = generateLinklist(arr);
		relocate(head);
		while(head != null) {
			System.out.print(head.value+" ");
			head = head.next;
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

	public static void relocate(Node head) {
		if(head == null || head.next == null) {
			return;
		}

		Node mid = head;
		Node right = head.next;
		while(right.next != null && right.next.next != null) {
			mid = mid.next;
			right = right.next.next;
		}
		right = mid.next;
		mid.next = null;
		mergeList(head, right);
	}

	public static void mergeList(Node left, Node right) {
		Node next = null;
		while(left.next != null) {
			next = right.next;
			right.next = left.next;
			left.next = right;
			left = right.next;
			right = next;
		}
		left.next = right;
	}

}
