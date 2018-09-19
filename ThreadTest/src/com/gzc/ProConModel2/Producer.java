package com.gzc.ProConModel2;

import org.omg.CORBA.INITIALIZE;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private List<PCData> queue;
    private int len;
    public Producer(List<PCData> queue ,int len){
        this.queue = queue;
        this.len = len;
    }


    @Override
    public void run() {
        try {
            while (true){
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
                //随机获取0-100之间的数
                Random r = new Random();
                int temp = r.nextInt(100);

                PCData data = new PCData();
                data.setData(temp);
                synchronized (queue){
                    if(queue.size() >= len){  //队列填满，停止生产，唤醒消费者
                        queue.notifyAll();
                        queue.wait();  //进入等待，释放锁
                    }else{
                        queue.add(data);
                        System.out.println("生产者"+Thread.currentThread().getId()+"生产了数据："+data.getData());
                    }
                }
                Thread.sleep(1000);

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
