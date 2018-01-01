class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList16 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,3,4,1,5,8,6};
		Node head = generateLinklist(arr);
		Node cur = SelectSort(head);
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

	public static Node SelectSort(Node head) {
		Node tail = null;
		Node cur = head;
		Node smallPre = null;
		Node small = null;
		while(cur != null) {
			small = cur;
			smallPre = getSmallestPre(cur);
			if(smallPre != null) {
				small = smallPre.next;
				smallPre.next = small.next;
			}
			cur = small == cur ? cur.next : cur;
			if(tail == null) {
				head = small;
			} else {
				tail.next = small;
			}
			tail = small;
		}
		return head;
	}
	
	public static Node getSmallestPre(Node head) {
		Node smallPre = null;
		Node small = head;
		Node pre = head;
		Node cur = head.next;
		while(cur != null) {
			if(cur.value < small.value) {
				smallPre = pre;
				small = cur;
			}
			pre = cur;
			cur = cur.next;
		}
		return smallPre;
	}

}
