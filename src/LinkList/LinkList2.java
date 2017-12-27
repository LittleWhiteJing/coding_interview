class Node {
  public int value;
  public Node next;
  public Node(int data) {
      this.value = data;
  }
}

class DoubleNode {
  public int value;
  public DoubleNode last;
  public DoubleNode next;
  public DoubleNode(int data) {
    this.value = data;
  }
}

class LinkList2 {

  public static void main(String[] args) {
	
	int[] arr = new int[]{1,2,3,4,5};
	Node n1 = generateLink(arr);
	Node head = removeLastKthNode(n1, 2);
	Node cur = head;
	while(cur != null) {
		System.out.print(cur.value+" ");
		cur = cur.next;
	}
  
  }

  public static Node generateLink(int[] arr) {
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
	if(hNode != null) {
		tNode.next = null;
	}
	return hNode;
  } 

  public static DoubleNode generateDLink(int[] arr) {
  	DoubleNode hNode = null;
	DoubleNode tNode = null;
	for(int i = 0; i < arr.length; i++) {
		DoubleNode cur = new DoubleNode(arr[i]);
		if(hNode == null) {
			hNode = cur;
		} else {
			tNode.next = cur;
			cur.last = tNode;
		}
		tNode = cur;
	}
	if(hNode != null) {
		tNode.next = null;
	}
	return hNode;
  }


  public static Node removeLastKthNode(Node head, int lastkth) {
    if(head == null || lastkth < 1) {
      return head;
    }
    Node cur = head;
    while(cur != null) {
      cur = cur.next;
      lastkth--;
    }
    if(lastkth == 0) {
      head = head.next;
    }
    if(lastkth < 0) {
      cur = head;
      while(++lastkth != 0) {
        cur = cur.next;
      }
      cur.next = cur.next.next;
    }
    return head;
  }

  public static DoubleNode removeDoubleNode(DoubleNode head, int lastkth) {
    if(head == null || lastkth < 1) {
      return head;
    }
    DoubleNode cur = head;
    while(cur != null) {
      cur = cur.next;
      lastkth--;
    }
    if(lastkth == 0) {
      head = head.next;
      head.last = null;
    }
    if(lastkth < 0) {
      cur = head;	    
      while(++lastkth != 0) {
        cur = cur.next;
      }
      DoubleNode newNext = cur.next.next;
      cur.next = newNext;
      if(newNext != null) {
        newNext.last = cur;
      }
    }
    return head;

  }



















}
