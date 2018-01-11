class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree12 {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.left.right = new Node(8);
		head.left.right.left = new Node(9);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		Node match = new Node(2);
		match.left = new Node(4);
		match.right = new Node(5);
		match.left.right = new Node(8);
		match.right.left = new Node(9);
		boolean res = isSubtree(head, match);
		System.out.println(res);
	}

	public static boolean isSubtree(Node t1, Node t2) {
		String t1Str = serialByPre(t1);
		String t2Str = serialByPre(t2);
		return getIndexOf(t1Str, t2Str) != -1;
	}

	public static String serialByPre(Node head) {
		if(head == null) {
			return "#!";
		}
		String res = head.value + "!";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}

	public static int getIndexOf(String s, String m) {
		if(s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int si = 0;
		int mi = 0;
		int[] next = getNextArray(ms);
		while(si < ss.length && mi < ms.length) {
			if(ss[si] == ms[mi]) {
				si++;
				mi++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	public static int[] getNextArray(char[] ms) {
		if(ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while(pos < next.length) {
			if(ms[pos - 1] == ms[cn]) {
				next[pos++] = ++cn;
			} else if(cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next;
	}
	
}
