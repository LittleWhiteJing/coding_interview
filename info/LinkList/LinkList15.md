# 将搜索二叉树转换成双向链表

### 题目

对二叉树的节点来说，有本身的值域，有指向左孩子和右孩子的两个指针；对于双向链表的节点来说，有本身的值域，有指向上一个节点和下一个节点的指针。在结构上，两种结构由相似性，现在有一棵搜索二叉树，请将其转换为一个有序的双向链表。

例如，节点定义为：

    public class Node {

        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
          this.value = data;
        }

    }   

一棵搜索二叉树如图所示

               6
            /     \
           4        7
         /  \        \       
        2             9
      /  \           /
     1    3         8

这棵搜索二叉树转换后的双向链表从头到尾依次是1~9，对于每一个节点来说，原来的right指针等价于转换后的next指针，原来的left指针等价于转换后的last指针，最后返回转换后的双向链表头节点。

### ~~要求~~


### 难度

 ★ ☆ ☆ ☆

### 代码

 [Java源码实现](../../src/LinkList/LinkList15.java)
