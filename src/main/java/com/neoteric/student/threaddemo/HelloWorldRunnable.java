package com.neoteric.student.threaddemo;

public class HelloWorldRunnable implements Runnable{
    @Override
    public void run() {

        while (true){
            if(Thread.interrupted()){
                System.out.println(" stop the program");
                break;
            }
            System.out.println(" working ...");
            try {
                Thread.sleep(500);
            }catch (InterruptedException e){
                System.out.println("then catch the program in stop in interrupted");
                break;
            }
        }
        hii();
        System.out.println(" say hii from thread");
    }

    public void  hii(){
        System.out.println("hello from helloworldthred");
    }
}
