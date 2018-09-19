package com.gzc.ProConModel;



import java.text.MessageFormat;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<PCData> queue;
    private static final int SLEEPTIME =1000;

    public Consumer(){

    }

    public  Consumer(BlockingQueue<PCData> queue){
        this.queue = queue;
    }

    public void run(){
        System.out.println("Consumer ID==="+Thread.currentThread().getId());
        Random r = new Random();
        try {
            while (true){
                PCData data = queue.take();
                if(data!=null){
                    int result =  data.getIntData()*data.getIntData();
                    System.out.println(MessageFormat.format("{0}*{1}={2}",
                                      data.getIntData(),data.getIntData(),result));
                    Thread.sleep(r.nextInt(SLEEPTIME));
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
