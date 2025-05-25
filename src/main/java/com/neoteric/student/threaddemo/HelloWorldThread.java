package com.neoteric.student.threaddemo;

public class HelloWorldThread extends Thread{

    public void run(){
        hii();
        System.out.println(" hello from threadMethod");
    }

    public void  hii(){
        System.out.println("hello from helloworldthred");
    }
}
