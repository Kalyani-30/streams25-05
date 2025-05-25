package com.neoteric.student.streamsdemo;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

     Father father= new Father();
     father.name= "asd " ;

        father.sonList = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            Son son = new Son();
            son.sonName = "Son " + i;

            List<Child> children = new ArrayList<>();
            for (int j = 1; j <= 2; j++) {
                Child child = new Child();
                child.childName = "Child " + i + "-" + j;
                children.add(child);
            }
            son.childList = children;

            father.sonList.add(son);
        }
        long total = 1 + // 1 Father (Grandfather)
                father.sonList.stream() // Sons
                        .mapToLong(son -> 1 + son.childList.size()) // 1 for son + number of children
                        .sum();

        System.out.println("Total members: " + total);


    }
}
