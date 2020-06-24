package com.coding.epi;

import java.util.ArrayList;
import java.util.List;

public class TreeTraverse {

    public List<Integer> preOrder(BinaryTreeNode root) {
        return preOrder(root, new ArrayList<>());
    }

    public List<Integer> inOrder(BinaryTreeNode root) {
        return inOrder(root, new ArrayList<>());
    }
    public List<Integer> postOrder(BinaryTreeNode root) {
        return postOrder(root, new ArrayList<>());
    }

    private List<Integer> preOrder(BinaryTreeNode node, List<Integer> acc) {
        if (node == null) return acc;

        acc.add(node.data);
        preOrder(node.left, acc);
        preOrder(node.right, acc);

        return acc;
    }

    private List<Integer> inOrder(BinaryTreeNode node, List<Integer> acc) {
        if (node == null) return acc;

        inOrder(node.left, acc);
        acc.add(node.data);
        inOrder(node.right, acc);

        return acc;
    }
    private List<Integer> postOrder(BinaryTreeNode node, List<Integer> acc) {
        if (node == null) return acc;

        postOrder(node.left, acc);
        postOrder(node.right, acc);
        acc.add(node.data);

        return acc;
    }
}
