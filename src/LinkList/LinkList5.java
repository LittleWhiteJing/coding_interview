
class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}


class LinkList5 {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		Node head = generateLinklist(arr);
		Node cur = reversePart(head, 2, 4);
		while(cur != null) {
			System.out.print(cur.value+" ");
			cur = cur.next;
		}
	}

	public static Node generateLinklist(int[] arr) {
		Node head = null;
		Node tail = null;
		for(int i = 0; i < arr.length; i++) {
			Node cur = new Node(arr[i]);
			if(head == null) {
				head = cur;
			} else {
				tail.next = cur;
			}
			tail = cur;
		}
		return head;
	}

	public static Node reversePart(Node head, int from, int to) {
		int len = 0;
		Node node1 = head;
		Node fPre = null;
		Node tPos = null;
		while(node1 != null) {
			len++;
			fPre = len == from - 1 ? node1 : fPre;
			tPos = len == to + 1 ? node1 : tPos;
			node1 = node1.next;
		}
		if(from > to || from < 1 || to > len) {
			return head;
		}
		node1 = fPre == null ? head : fPre.next;
		Node node2 = node1.next;
		node1.next = tPos;
	        Node next = null;
		while(node2 != tPos) {
			next = node2.next;
			node2.next = node1;
			node1 = node2;
			node2 = next;
		}	
		if(fPre != null) {
			fPre.next = node1;
			return head;
		}
		return node1;

	}

 }
