
import java.util.*;

class Node {
	public int value;
	public Node left;
	public Node right;
	public Node(int data) {
		this.value = data;
	}
}

class BTree14 {

	public static void main(String[] args) {
		int[] arr = new int[]{2,1,3,6,5,7,4};
		boolean res = isPostArray(arr);
		System.out.println(res);
		Node head = posArrayToBST(arr);
		inOrderNorecu(head);
	}

	public static void inOrderNorecu(Node head) {
		if(head == null) {
			return ;
		}
		Stack<Node> stack = new Stack<Node>();
		while(!stack.isEmpty() || head != null) {
			if(head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				System.out.print(head.value + " ");
				head = head.right;
			}
		}
	}

	public static boolean isPostArray(int[] arr) {
		if(arr == null || arr.length == 0) {
			return false;
		}
		return isPost(arr, 0, arr.length-1);
	}

	public static boolean isPost(int[] arr, int start, int end) {
		if(start > end) {
			return true;
		}
		int less = -1;
		int more = end;
		for(int i = 0; i < end; i++) {
			if(arr[end] > arr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		if(less == -1 || more == end) {
			return isPost(arr, start, end-1);
		}
		if(less != more-1) {
			return false;
		}
		return isPost(arr, start, less) && isPost(arr, more, end-1);
	}
	
	public static Node posArrayToBST(int[] posArr) {
		if(posArr == null) {
			return null;
		}
		return posToBST(posArr, 0, posArr.length - 1);
	}

	public static Node posToBST(int[] posArr, int start, int end) {
		if(start > end) {
			return null;
		}
		Node head = new Node(posArr[end]);
		int less = -1;
		int more = end;
		for(int i = start; i < end; i++) {
			if(posArr[end] > posArr[i]) {
				less = i;
			} else {
				more = more == end ? i : more;
			}
		}
		head.left = posToBST(posArr, start, less);
		head.right = posToBST(posArr, more, end - 1);
		return head;
	}



}
