class Node {
  public int value;
  public Node next;
  public Node(int data) {
    this.value = data;
  }
}

class LinkList1 {

  public static void main(String[] args) {
    Node link1 = new Node(1);
    Node link2 = new Node(2); link1.next = link2;
    Node link3 = new Node(3); link2.next = link3;
    Node node1 = new Node(2);
    Node node2 = new Node(3); node1.next = node2;
    Node node3 = new Node(4); node2.next = node3;
    printCommonPart(link1, node1);
  }

  public static void printCommonPart(Node head1, Node head2) {
    System.out.println("Common part of the two LinkList:");
    while(head1 != null && head2 != null) {
      if(head1.value < head2.value) {
        head1 = head1.next;
      } else if(head1.value > head2.value) {
        head2 = head2.next;
      } else {
        System.out.print(head1.value+" ");
        head1 = head1.next;
        head2 = head2.next;
      }
    }
    System.out.println();
  }

}
