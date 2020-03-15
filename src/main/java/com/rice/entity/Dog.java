package com.rice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class Dog implements Animal {
    private String name;

    private Integer age;

    public Dog(){}

    @Override
    public void jump() {
        System.out.println(this.name+"高兴的跳了起来...");
    }
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.age=19;
    }

}
