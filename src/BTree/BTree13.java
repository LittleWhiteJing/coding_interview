class Node {
	public int value;
	public Node left;
	public Node right;
	public Node (int data) {
		this.value = data;
	}
}

class BTree13 {
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.left.left = new Node(8);
		head.left.left.right = new Node(9);
		head.left.right.left = new Node(10);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		boolean res = isBalance(head);
		System.out.println(res);
	}

	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}

	public static int getHeight(Node head, int level, boolean[] res) {
		if(head == null) {
			return level;
		}
		int lH = getHeight(head.left, level+1, res);
		if(!res[0]) {
			return level;
		}
		int rH = getHeight(head.right, level+1, res);
		if(!res[0]) {
			return level;	
		}
		if(Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		return Math.max(lH, rH);
	}
}
