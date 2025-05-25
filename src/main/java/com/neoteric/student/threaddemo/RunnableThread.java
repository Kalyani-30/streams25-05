package com.neoteric.student.threaddemo;

public class RunnableThread {

    public static void main(String[] args) {
        System.out.println(" say hi from main thread"+Thread.currentThread());

        Thread th= new Thread(new HelloWorldRunnable());
        th.start();
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        th.interrupt();
    }
}
