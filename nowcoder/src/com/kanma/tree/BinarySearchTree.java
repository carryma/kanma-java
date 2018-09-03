package com.kanma.tree;

/**
 * @ Desc   ：二叉查找树数据结构以及相关API实现
 * @ Author ：MaKang
 * @ Date   ：Created in 2018/9/3 23:43
 */
public class BinarySearchTree {
    private static class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(int data) {
            this.data = data;
            this.leftNode = null;
            this.rightNode = null;
        }

        TreeNode(int data, TreeNode leftNode, TreeNode rightNode) {
            this.data = data;
            this.leftNode = leftNode;
            this.rightNode = rightNode;


        }
    }

    //很关键,二叉搜索树的域:根节点,即初始化BST
    //TO-DO:在构造函数中初始化BST(创建根节点)
    private TreeNode root;

    //每次插入都要从root开始进行对比,从而保证树的结构满足BST的特性
    public void insert(int data) {
        root = insert(data, root);
    }

    private TreeNode insert(int data, TreeNode newNodeForData) {
        if (newNodeForData == null) {
            return new TreeNode(data);
        }
        if (data < newNodeForData.data) {
            newNodeForData.leftNode = insert(data, newNodeForData.leftNode);
        } else if (data > newNodeForData.data) {
            newNodeForData.rightNode = insert(data, newNodeForData.rightNode);
        }
        return newNodeForData;
    }

    //前序输出BST各个节点
    public void preOrder(TreeNode node) {
        //方法退出的条件,根子节点
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.leftNode);
        preOrder(node.rightNode);

    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] array = new int[]{8, 6, 2, 4, 1, 3};
        for (int data : array) {
            bst.insert(data);
        }
        bst.preOrder(bst.root);
    }
}
