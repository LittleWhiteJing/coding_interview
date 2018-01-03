class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList18 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{2,3,4,6,6,7};
		Node head = generateCirList(arr);
		Node cur = insertNum(head, 5);
		Node end = cur;
		while(cur.next != end) {
			System.out.print(cur.value+" ");
			cur = cur.next;
		}
		System.out.print(cur.value);
		
	}
	
	public static Node generateCirList(int[] arr) {
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
			tNode.next = hNode;
		}
		return hNode;
	}


	public static Node insertNum(Node head, int num) {
		Node node = new Node(num);
		if(head == null) {
			node.next = node;
			return node;
		}
		Node pre = head;
		Node cur = head.next;
		while(cur != head) {
			if(pre.value <= num && cur.value >= num) {
				break;
			}
			pre = cur;
			cur = cur.next;
		}
		pre.next = node;
		node.next = cur;
		return head.value < num ? head : node;
	}

}

