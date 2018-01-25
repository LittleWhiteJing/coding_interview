class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree20 {
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(7);
		head.right.right = new Node(8);
		int res = maxDistance(head);
		System.out.println(res + " ");
	}

	public static int maxDistance(Node head) {
		int[] record = new int[1];
		return posOrder(head, record);
	}

	public static int posOrder(Node head, int[] record) {
		if(head == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = posOrder(head.left, record);
		int maxfromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxfromRight = record[0];
		int curNodeMax = maxfromLeft + maxfromRight + 1;
		record[0] = Math.max(maxfromLeft, maxfromRight) + 1;
		return Math.max(Math.max(lMax, rMax), curNodeMax);
	}


}


