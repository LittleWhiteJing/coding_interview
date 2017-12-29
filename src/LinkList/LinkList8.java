class Node {
	public int value;
	public Node next;
	public Node(int data) {
		this.value = data;
	}
}

class LinkList8 {

	public static void main(String[] args) {
		int[] arr = new int[]{9, 0, 4, 5, 1};
		int pivot = 3;
		Node head = generateLinklist(arr);
		Node now = listPartition2(head, 3);
		while(now != null) {
			System.out.print(now.value+" ");
			now = now.next;
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

	public static Node listPartition(Node head, int pivot) {
		if(head == null) {
			return head;
		}
		int length = 0;
		Node cur = head;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		cur = head;
		Node[] nArr = new Node[length];
		for(int i = 0; i < nArr.length; i++) {
			nArr[i] = cur;
			cur = cur.next;	
		}
		int i = 0;	
		arrPartition(nArr, pivot);
		for(i = 1; i != nArr.length; i++) {
			nArr[i-1].next = nArr[i];
		}
		nArr[i-1].next = null;
		return nArr[0];
	}

	public static void arrPartition(Node[] nArr, int pivot) {
		int small = -1;
		int big = nArr.length;
		int index = 0;
		while(index != big) {
			if(nArr[index].value < pivot) {
				swap(nArr, ++small, index++);
			} else if(nArr[index].value == pivot) {
				index++;
			} else {
				swap(nArr, --big, index++);
			}
		}
	}

	public static void swap(Node[] nArr, int m, int n) {
		Node tmp = nArr[m];
		nArr[m] = nArr[n];
		nArr[n] = tmp;
	}

	public static Node listPartition2(Node head, int pivot) {
		Node sH = null;
		Node sT = null;
		Node mH = null;
		Node mT = null;
		Node bH = null;
		Node bT = null;
		Node next = null;
		while(head != null) {
			next = head.next;
			head.next = null;
			if(head.value < pivot) {
				if(sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if(head.value == pivot) {
				if(mH == null) {
					mH = head;
					mT = head;
				} else {
					mT.next = head;
					mT = head;
				}
			} else {
				if(bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}
		if(sT != null) {
			sT.next = mH;
			mT = mT != null ? mT : sT;
		} 

		if(mT != null) {
			mT.next = bH;	
		}
		return sH != null ? sH : mH != null ? mH : bH;
	
	}



}
