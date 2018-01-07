class Node {
	
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}

}

class BTree2 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2); head.right = new Node(3);
		head.left.right = new Node(4); 
		head.left.right.left = new Node(7);
		head.left.right.right = new Node(8);
		head.left.right.right.right = new Node(11);
		head.left.right.right.right.left = new Node(13);
		head.left.right.right.right.right = new Node(14);
		head.right.left = new Node(5);
		head.right.right = new Node(6);
		head.right.left.left = new Node(9);
		head.right.left.right = new Node(10);
		head.right.left.left.left = new Node(12);
		head.right.left.left.left.left = new Node(15);
		head.right.left.left.left.right = new Node(16);
		printEdge1(head);
		printEdge2(head);
	}

	public static void printEdge1(Node head) {
		if(head == null) {
			return ;
		}
		int height = getHeight(head, 0);
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head, 0, edgeMap);
		for(int i = 0; i != edgeMap.length; i++) {
			System.out.print(edgeMap[i][0].value + " ");
		}
		printLeafNotInMap(head, 0, edgeMap);
		for(int i = edgeMap.length - 1; i != -1; i--) {
			if(edgeMap[i][0] != edgeMap[i][1]) {
				System.out.print(edgeMap[i][1].value + " ");
			}
		}
		System.out.println();
	}

	public static int getHeight(Node h, int l) {
		if(h == null) {
			return l;
		}
		return Math.max(getHeight(h.left, l+1), getHeight(h.right, l+1));
	}

	public static void setEdgeMap(Node head, int l, Node[][] edgeMap) {
		if(head == null) {
			return ;
		}
		edgeMap[l][0] = edgeMap[l][0] == null ? head : edgeMap[l][0];
		edgeMap[l][1] = head;
		setEdgeMap(head.left, l+1, edgeMap);
		setEdgeMap(head.right, l+1, edgeMap);
	}

	public static void printLeafNotInMap(Node h, int l, Node[][] edgeMap) {
		if(h == null) {
			return ;
		}
		if(h.left == null && h.right == null && h != edgeMap[l][0] && h != edgeMap[l][1]){
			System.out.print(h.value + " ");
		}
		printLeafNotInMap(h.left, l+1, edgeMap);
		printLeafNotInMap(h.right, l+1, edgeMap);
	}

	public static void printEdge2(Node head) {
		if(head == null) {
			return ;
		}
		System.out.print(head.value + " ");
		if(head.left != null && head.right != null) {
			printLeftEdge(head.left, true);
			printRightEdge(head.right, true);
		} else {
			printEdge2(head.left == null ? head.right : head.left);
		}
		System.out.println();
	}

	public static void printLeftEdge(Node h, boolean print) {
		if(h == null) {
			return ;
		}
		if(print || (h.left == null && h.right == null)) {
			System.out.print(h.value + " ");
		}
		printLeftEdge(h.left, print);
		printLeftEdge(h.right, print && h.left == null ? true : false);
	}

	public static void printRightEdge(Node h, boolean print) {
		if(h == null) {
			return ;
		}
		printRightEdge(h.left, print && h.right == null ? true : false);
		printRightEdge(h.right, print);
		if(print || (h.left == null && h.right == null)) {
			System.out.print(h.value + " ");
		}
	}
	


}



































