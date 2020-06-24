package com.coding.epi;

public class BinaryTreeNode {
    BinaryTreeNode left;
    BinaryTreeNode right;
    BinaryTreeNode next;
    public int data;
    int lis;
    int height;
    int size;
    Color color;

    public static BinaryTreeNode newNode(int data) {
        BinaryTreeNode n = new BinaryTreeNode();
        n.left = null;
        n.right = null;
        n.data = data;
        n.lis = -1;
        n.height = 1;
        n.size = 1;
        n.color = Color.RED;
        return n;
    }
}
