import java.util.*;

class Stack9 {

  public static void main(String[] args) {
    int[][] arr = new int[3][4];
    arr[0] = new int[]{1,0,1,1};
    arr[1] = new int[]{1,1,1,1};
    arr[2] = new int[]{1,1,1,0};
    int maxsize = maxRectSize(arr);
    System.out.println("Max size is "+maxsize);
  }

  public static int maxRectSize(int[][] map) {
    if(map == null || map.length == 0 || map[0].length == 0) {
      return 0;
    }
    int maxArea = 0;
    int[] height = new int[map[0].length];
    for(int i = 0; i < map.length; i++) {
      for(int j = 0; j < map[0].length; j++) {
          height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
      }
      maxArea = Math.max(maxRectFromBottom(height), maxArea);
    }
    return maxArea;
  }

  public static int maxRectFromBottom(int[] height) {
    if(height == null || height.length == 0) {
      return 0;
    }
    int maxArea = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for(int i = 0;i < height.length; i++) {
      while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
        int j = stack.pop();
        int k = stack.isEmpty() ? -1 : stack.peek();
        int curArea = (i-k-1) * height[j];
        maxArea = Math.max(curArea, maxArea);
      }
      stack.push(i);
    }
    while(!stack.isEmpty()) {
      int j = stack.pop();
      int k = stack.isEmpty() ? -1 : stack.peek();
      int curArea = (height.length-k-1) * height[j];
      maxArea = Math.max(curArea, maxArea);
    }
    return maxArea;
  }



}
