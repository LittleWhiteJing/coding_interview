class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList17 {

	public static void main(String[] args) {
		int[] arr = new int[]{1,2,3,4,5,6};
		Node head = generateLinklist(arr);
		Node dete = head.next.next.next;
		removeNodeWired(dete);
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

	public static void removeNodeWired(Node node) {
		if(node == null) {
			return ;
		}
		Node next = node.next;
		if(next == null) {
			throw new RuntimeException("Can't remove last node!");
		}
		node.value = next.value;
		node.next = next.next;
	}
	
}
