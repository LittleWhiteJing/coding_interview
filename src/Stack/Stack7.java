import java.util.*;

class Stack7{
	
	public static void main(String[] args) {
	
		int[] arr = new int[]{4, 3, 5, 4, 3, 3, 6, 7};
		int[] res = getMaxWindow(arr, 3);
		System.out.println("The output arr is:");
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i]+" ");
		}	

	}
	
	public static int[] getMaxWindow(int[] arr, int w) {
		if(arr == null || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for(int i = 0; i < arr.length; i++) {
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();
			}
			qmax.addLast(i);
			if(qmax.peekFirst() == i - w) {
				qmax.pollFirst();
			}
			if(i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

}
