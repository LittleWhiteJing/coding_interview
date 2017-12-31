import java.util.*;

class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList13 {
	
	public static void main(String[] args) {
		int[] arr = new int[]{1,2,2,2,3,3,3,4,4,4,5};
		Node head = generateLinklist(arr);
		removeRep2(head);
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


	public static void removeRep(Node head) {
		if(head == null) {
			return ;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = head;
		Node cur = head.next;
		Node next = null;
		set.add(head.value);
		while(cur != null) {
			next = cur.next;
			if(set.contains(cur.value)){
				pre.next = cur.next;
			} else {
				set.add(cur.value);
				pre = cur;
			}
			cur = cur.next;
		}
	}

	public static void removeRep2(Node head) {
		Node cur = head;
		Node pre = null;
		Node next = null;
		while(cur != null) {
			pre = cur;
			next = cur.next;
			while(next != null) {
				if(cur.value == next.value) {
					pre.next = next.next;
				} else {
					pre = next;
				}
				next = next.next;
			}
			cur = cur.next;
		}
	}

}
