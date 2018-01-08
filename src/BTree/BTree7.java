class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree7 {

	public static void main(String[] args) {
		Node head = new Node(6);
		head.left = new Node(1);
		head.right = new Node(12);
		head.left.left = new Node(0);
		head.left.right = new Node(3);
		head.right.right = new Node(13);
		head.right.left = new Node(10);
		head.right.left.left = new Node(4);
		head.right.left.right = new Node(14);
		head.right.left.left.left = new Node(2);
		head.right.left.left.right = new Node(5);
		head.right.left.right.left = new Node(11);
		head.right.left.right.right = new Node(15);
		head.right.right.left = new Node(20);
		head.right.right.right = new Node(16);
		Node cur = biggestSubBST(head);
		String res = inOrderRecu(cur);
		System.out.println(res);
	}


	public static String inOrderRecu(Node head) {
		if(head == null) {
			return " ";
		}
		String res = " ";
		res += inOrderRecu(head.left) + " ";
		res += head.value + " ";
		res += inOrderRecu(head.right) + " ";
		return res;
	}

	public static Node biggestSubBST(Node head) {
		int[] record = new int[3];
		return posOrder(head, record);
	}

	public static Node posOrder(Node head, int[] record) {
		if(head == null) {
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
			return null;
		}
		int value = head.value;
		Node left = head.left;
		Node right = head.right;
		Node lBST = posOrder(left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		Node rBST = posOrder(right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		record[1] = Math.min(lMin, value);
		record[2] = Math.max(rMax, value);
		if(left == lBST && right == rBST && lMax < value && value < rMin) {
			record[0] = lSize + rSize + 1;
			return head;
		}
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST : rBST;
	}
}
