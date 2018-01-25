import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree21 {

	public static void main(String[] args) {
		int[] pre1Arr = {1,2,4,5,8,9,3,6,7};
		int[] inArr = {4,2,8,5,9,1,6,3,7};
		Node head1 = preInToTree(pre1Arr, inArr);
		printByInOrder(head1);	
		System.out.println();
		int[] pre2Arr = {1,2,4,5,3,6,7};
		int[] posArr = {4,5,2,6,7,3,1};
		Node head2 = prePosToTree(pre2Arr, posArr);
		printByInOrder(head2);	

	}

	public static void printByInOrder(Node head) {
		if(head == null) {
			return ;
		}
		Stack<Node> stack = new Stack<Node>();
		while(head != null || !stack.isEmpty()) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				System.out.print(head.value + " ");
				head = head.right;
			}
		}
		System.out.println();
	} 

	public static Node preInToTree(int[] pre, int[] in) {
		if(pre == null || in == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return preIn(pre, 0, pre.length-1, in, 0, in.length-1, map);
	}

	public static Node preIn(int[] p, int pi, int pj, int[] n, int ni, int nj, HashMap<Integer, Integer> map) {
		if(pi > pj) {
			return null;
		}
		Node head = new Node(p[pi]);
		int index = map.get(p[pi]);
		head.left = preIn(p, pi+1, pi+index-ni, n, ni, index-1, map);
		head.right = preIn(p, pi+index-ni+1, pj, n, index+1, nj, map);
		return head;
	}

	public static Node inPosToTree(int in[], int[] pos) {
		if(in == null || pos == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < in.length; i++) {
			map.put(in[i], i);
		}
		return inPos(in, 0, in.length-1, pos, 0, pos.length-1, map);
	}	
	
	public static Node inPos(int[] n, int ni, int nj, int[] s, int si, int sj, HashMap<Integer, Integer> map) {
		if(si > sj) {
			return null;
		}
		Node head = new Node(s[si]);
		int index = map.get(s[si]);
		head.left = inPos(n, ni, index-1, s, si, si+index-ni-1, map);
		head.right = inPos(n, index+1, nj, s, si+index-ni, sj-1, map);
		return head;
	} 
	
	public static Node prePosToTree(int[] pre, int[] pos) {
		if(pre == null || pos == null) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < pos.length; i++) {
			map.put(pos[i], i);
		}
		return prePos(pre, 0, pre.length-1, pos, 0, pos.length-1, map);
	}

	public static Node prePos(int[] p, int pi, int pj, int[] s, int si, int sj, HashMap<Integer, Integer> map) {
		Node head = new Node(s[sj--]);
		if(pi == pj) {
			return head;
		}
		int index = map.get(p[++pi]);
		head.left = prePos(p, pi, pi+index-si, s, si, index, map);
		head.right = prePos(p, pi+index-si+1, pj, s, index+1, sj, map);
		return head;
	}

}


