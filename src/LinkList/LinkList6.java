
class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList6 {

	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5};
		Node head = generateCirclelist(arr);
		//Node only = jpsephusKill(head, 3);
		Node only = jpsephusKill(head, 3);
		System.out.println(only.value);
	}
	
	public static Node generateCirclelist(int[] arr) {
		Node head = null;
		Node tail = null;
		for(int i = 0; i < arr.length; i++) {
			Node cur = new Node(arr[i]);
			if(head == null) {
				head = cur;
			} else {
				tail.next = cur;
			}
			tail = cur;
			if(i == arr.length -1) {
				tail.next = head;
			}
		}
		return head;
	}


	public static Node jpsephusKill(Node head, int num) {
		if(head == null || head.next == head || num < 1) {
			return head;
		}
		Node last = head;
		while(head != last.next) {
			last = last.next;
		}
		int count = 0;
		while(head != last) {
			if(++count == num) {
				last.next = head.next;	
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
		
	}

	public static Node jpsephusKill2(Node head, int num) {
		if(head == null || head.next == head || num < 1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1;
		while(cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, num);
		while(--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}
	
	public static int getLive(int i, int m) {
		if(i == 1) {
			return 1;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
	}




}
