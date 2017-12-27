
class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList3 {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5};
		Node head = generateList(arr);
		Node cur = removeMidNode(head);
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

	public static Node removeMidNode(Node head) {
		if(head == null || head.next == null) {
			return null;
		}
		if(head.next.next == null) {
			head = head.next;
		}
		Node pre = head;
		Node cur = head.next.next;
		while(cur.next != null && cur.next.next != null) {
			pre = pre.next;
			cur = cur.next.next;
		}
		pre.next = pre.next.next;
		return head;
	}

	public static Node removeByRadio(Node head, int a, int b) {
		if(a < 1 || a > b) {
			return head;
		}
		int n = 0;
		Node cur = head;
		while(cur != null) {
			cur = cur.next;
			n++;
		}
		n = (int) Math.ceil(((double) (a*n))/(double) b);
		if(n == 1) {
			head = head.next;
		}
		if(n > 1) {
			cur = head;
			while(--n != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

}
