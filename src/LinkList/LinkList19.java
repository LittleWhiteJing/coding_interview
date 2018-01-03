class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList19 {
	
	public static void main(String[] args) {
		int[] arr1 = new int[]{2,4,6,8};
		int[] arr2 = new int[]{1,3,5,7};
		Node head1 = generateLinklist(arr1);
		Node head2 = generateLinklist(arr2);
		Node merg = merge(head1, head2);
		while(merg != null) {
			System.out.print(merg.value+" ");
			merg = merg.next;
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

	public static Node merge(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return head1 != null ? head1 : head2; 
		}
		Node head = head1.value < head2.value ? head1 : head2;
		Node cur1 = head == head1 ? head1 : head2;
		Node cur2 = head == head1 ? head2 : head1;
		Node pre = null;
		Node next = null;
		while(cur1 != null && cur2 != null) {
			if(cur1.value <= cur2.value) {
				pre = cur1;
				cur1 = cur1.next;
			} else {
				next = cur2.next;
				pre.next = cur2;
				cur2.next = cur1;
				pre = cur2;
				cur2 = next;
			}
		}
		pre.next = cur1 == null ? cur2 : cur1;
		return head;	
	}

}
