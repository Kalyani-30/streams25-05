package com.neoteric.student.threaddemo;

public class ThreadDemo  {

    public static void main(String[] args) {
        System.out.println(" hello from main thread  "+Thread.currentThread());
        HelloWorldThread ht= new HelloWorldThread();
          ht.start();
}
}
