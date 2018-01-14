class Node {
	public int value;
	public Node left;
	public Node right;
	public Node parent;
	public Node(int data) {
		this.value = data;
	}
}

class BTree17 {
	
	public static void main(String[] args) {
		Node head = new Node(6);
		head.left = new Node(3);
		head.right = new Node(9);
		
		head.left.left = new Node(1);
		head.left.right = new Node(4);
		head.left.parent = head;
		
		head.left.left.right = new Node(2);
		head.left.left.parent = head.left;

		head.left.left.right.parent = head.left.left;

		head.left.right.right = new Node(5);
		head.left.right.parent = head.left;

		head.left.right.right.parent = head.left.right;

		head.right.left = new Node(8);
		head.right.right = new Node(10);
		head.right.parent = head;

		head.right.left.left = new Node(7);
		head.right.left.parent = head.right;

		head.right.left.left.parent = head.right.left;

		head.right.right.parent = head.right;

		Node res = getNextNode(head.left.right.right);

		System.out.print(res.value);
	}

	public static Node getNextNode(Node node) {
		if(node == null) {
			return node;	
		}
		if(node.right != null) {
			return getLeftMost(node.right);
		} else {
			Node parent = node.parent;
			while(parent != null && parent.left != node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}

	}

	public static Node getLeftMost(Node node) {
		if(node == null) {
			return node;
		}
		while(node.left != null) {
			node = node.left;
		}
		return node;
	}
}
