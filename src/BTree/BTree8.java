
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class Record {
	public int l;
	public int r;
	public Record(int left, int right) {
		this.l = left;
		this.r = right;
	}
}

class BTree8 {
	public static void main(String[] args) {
		Node head = new Node(6);
		head.left = new Node(1);
		head.left.left = new Node(0);
		head.left.right = new Node(3);
		head.right = new Node(12);
		head.right.left = new Node(10);
		head.right.left.left = new Node(4);
		head.right.left.right = new Node(14);
		head.right.left.left.left = new Node(2);
		head.right.left.left.right = new Node(5);
		head.right.left.right.left = new Node(11);
		head.right.left.right.right = new Node(15);
		head.right.right = new Node(13);
		head.right.right.left = new Node(20);
		head.right.right.right = new Node(16);
		int num = bsTopoSize2(head);
		System.out.println(num);
	}

	public static int bsTopoSize(Node head) {
		if(head == null) {
			return 0;
		}
		int max = maxTopo(head, head);
		max = Math.max(bsTopoSize(head.left), max);
	      	max = Math.max(bsTopoSize(head.right), max);
		return max;	
	}

	public static int maxTopo(Node h, Node n) {
		if(h != null && n != null && isBSTNode(h, n, n.value)){
			return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;
		}
		return 0;
	}
	
	public static boolean isBSTNode(Node h, Node n, int value) {
		if(h == null) {
			return false;
		}
		if(h == n) {
			return true;
		}
		return isBSTNode(h.value > value ? h.left : h.right, n, value);
	}

	public static int bsTopoSize2(Node head) {
		Map<Node, Record> map = new HashMap<Node, Record>();
		return posOrder(head, map);
	}

	public static int posOrder(Node h, Map<Node, Record> map) {
		if(h == null) {
			return 0;
		}
		int ls = posOrder(h.left, map);
		int rs = posOrder(h.right, map);
		modifyMap(h.left, h.value, map, true);
		modifyMap(h.right, h.value, map, false);
		Record lr = map.get(h.left);
		Record rr = map.get(h.right);
		int lbst = lr == null ? 0 : lr.l + lr.r + 1;
		int rbst = rr == null ? 0 : rr.l + rr.r + 1;
		map.put(h, new Record(lbst, rbst));
		return Math.max(lbst + rbst + 1, Math.max(ls, rs));
	}

	public static int modifyMap(Node n, int v, Map<Node, Record> m, boolean s) {
		if(n == null || (!m.containsKey(n))) {
			return 0;
		}
		Record r = m.get(n);
		if((s && n.value > v) || ((!s) && n.value < v)) {
			m.remove(n);
			return r.l + r.r + 1;
		} else {
			int minus = modifyMap(s ? n.right : n.left, v, m, s);
			if(s) {
				r.r = r.r - minus;
			} else {
				r.l = r.l - minus;
			}
			m.put(n,r);
			return minus;
		}
		
	}

}
