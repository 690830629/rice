package com.rice.entity;

import lombok.Data;

@Data
public class Node {

    private int data;
    private Node next;

    //显示该节点内容
    public void displayNode() {
        System.out.println("data=" + data);
    }

    public Node(int data) {
        this.data = data;
    }

    public Node() {

    }

    public void addNode(int data) {
        Node node = new Node(data);
        Node nextNode = this.next;
        if (null != nextNode) {
            node.next = nextNode;
        }
        this.next = node;
    }

    public void traversalNode() {
        Node node = this;
        while (null != node) {
            System.out.println(node.data);
            node = node.next;
        }
    }

}
