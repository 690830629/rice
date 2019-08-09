package com.rice.entity;

import lombok.Data;

@Data
public class Node {
    Node parent;
    Node leftChild;
    Node rightChild;
    Integer data;

    //显示该节点内容
    public void displayNode() {
        System.out.println("data=" + data);
    }
}
