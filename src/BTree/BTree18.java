
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree18 {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.right.left = new Node(8);
		Node res1 = lowestAncestor(head, head.right.left, head.right.right.left);
		Record1 oRec1 = new Record1(head);
		Node res2 = oRec1.query(head.right.left, head.right.right.left);
		Record2 oRec2 = new Record2(head);
		Node res3 = oRec2.query(head.right.left, head.right.right.left);
		System.out.println(res1.value + " ");
		System.out.println(res2.value + " ");
		System.out.println(res3.value + " ");
	}

	public static Node lowestAncestor(Node head, Node o1, Node o2) {
		if(head == null || head == o1 || head == o2) {
			return head;
		}
		Node left = lowestAncestor(head.left, o1, o2);
		Node right = lowestAncestor(head.right, o1, o2);
		if(left != null && right != null) {
			return head;
		}
		return left != null ? left : right;
	}
}

class Record1{
	private HashMap<Node, Node> map;

	public Record1(Node head){
		map = new HashMap<Node, Node>();
		if(head != null) {
			map.put(head, null);
		}
		setMap(head);
	}

	private void setMap(Node head) {
		if(head == null) {
			return ;
		}
		if(head.left != null) {
			map.put(head.left, head);
		}
		if(head.right != null) {
			map.put(head.right, head);
		}
		setMap(head.left);
		setMap(head.right);
	}

	public Node query(Node o1, Node o2) {
		HashSet<Node> path = new HashSet<Node>();
		while(map.containsKey(o1)) {
			path.add(o1);
			o1 = map.get(o1);
		}
		while(!path.contains(o2)) {
			o2 = map.get(o2);
		}
		return o2;
	}

}


class Record2{
	private HashMap<Node, HashMap<Node, Node>> map;

	public Record2(Node head) {
		map = new HashMap<Node, HashMap<Node, Node>>();
		initMap(head);
		setMap(head);
	}

	private void initMap(Node head) {
		if(head == null) {
			return ;
		}
		map.put(head, new HashMap<Node, Node>());
		initMap(head.left);
		initMap(head.right);
	}

	private void setMap(Node head) {
		if(head == null) {
			return ;
		}
		headRecord(head.left, head);
		headRecord(head.right, head);
		subRecord(head);
		setMap(head.left);
		setMap(head.right);
	}

	private void headRecord(Node n, Node h) {
		if(n == null) {
			return ;
		}
		map.get(n).put(h, h);
		headRecord(n.left, h);
		headRecord(n.right, h);
	}

	private void subRecord(Node head) {
		if(head == null) {
			return ;
		}
		preLeft(head.left, head.right, head);
		subRecord(head.left);
		subRecord(head.right);
	}

	private void preLeft(Node l, Node r, Node h) {
		if(l == null) {
			return ;
		}
		preRight(l, r, h);
		preLeft(l.left, r, h);
		preLeft(l.right, r, h);
	}

	private void preRight(Node l, Node r, Node h) {
		if(r == null) {
			return ;
		}
		map.get(l).put(r, h);
		preRight(l, r.left, h);
		preRight(l, r.right, h);
	}

	public Node query(Node o1, Node o2) {
		if(o1 == o2) {
			return o1;
		}
		if(map.containsKey(o1)) {
			return map.get(o1).get(o2);
		}
		if(map.containsKey(o2)) {
			return map.get(o2).get(o1);
		}
		return null;
	}


}



























































































































