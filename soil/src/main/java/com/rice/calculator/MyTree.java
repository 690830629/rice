package com.rice.calculator;

public class MyTree {

    private static TreeNode root;

    static {
        root = new TreeNode(1, null, null);
    }


    public TreeNode addData(TreeNode node) {
        if (node == null) {
            return new TreeNode(node.getData(), null, null);
        }
        node.setLeft(addData(node.getLeft()));
        node.setRight(addData(node.getRight()));
        return node;

    }

    public void traverseTreeNode(TreeNode root) {
        traverseTreeNode(root.getLeft());
        System.out.println(root.getData());
        traverseTreeNode(root.getRight());
    }

    public static void main(String[] args) {
        MyTree myTree=new MyTree();
        for(int i=0;i<20;i++){
            TreeNode node;

        }
    }
}
