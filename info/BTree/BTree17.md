# 在二叉树中找到一个节点的后继节点

### 题目

现在有一种新的二叉树节点类型如下：

    public class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data) {
              this.value = data;
        }
    }

该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设一棵Node类型的节点组成的二叉树，树中每个节点的parent指针都正确地指向自己的父节点，头节点的parent指向null。只给一个在二叉树中的某个节点node，请实现返回node的后继节点的函数。在二叉树的中序遍历的序列中，node的下一个节点叫做node的后继节点。

例如，图3-40所示的二叉树

                          6
                     /          \     
                    3            9
                 /     \       /   \
                1       4     8    10
                 \       \   /
                  2       5 7

中序遍历的结果为：1，2，3，4，5，6，7，8，9，10

所以节点1的后继节点为节点2，节点2的后继节点为节点3，...，节点10的后继节点为null。                  

### ~~要求~~


### 难度

 ★ ★ ☆ ☆

### 代码

 [Java源码实现](../../src/BTree/BTree17.java)
