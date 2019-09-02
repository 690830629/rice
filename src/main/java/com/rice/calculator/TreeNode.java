package com.rice.calculator;

import lombok.Data;

@Data
public class TreeNode {
    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
    public TreeNode(){

    }


}
