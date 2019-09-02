package com.rice.entity;

import lombok.Data;

@Data
public class Dog {
    private String name;

    private Integer age;

    public static void main(String[] args) {
        Node root1=new Node(2);
        root1.addNode(4);
        root1.addNode(3);
        root1.traversalNode();
        Node root2=new Node(5);
        root2.addNode(6);
        root2.addNode(4);
        root2.traversalNode();
    }

}
