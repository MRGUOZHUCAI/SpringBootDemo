package com.gzc.ProConModel2;

import jdk.nashorn.internal.ir.CatchNode;

import java.util.List;

public class Consumer implements Runnable{
    private List<PCData> queue;

    public Consumer(List<PCData> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    break;
                }
                PCData data = null;
                synchronized (queue){
                    if(queue.size() == 0){
                        queue.wait();
                        queue.notifyAll();
                    }else{
                        data = queue.remove(0);
                        System.out.println("消费者"+Thread.currentThread().getId()+"消费了数据："+data.getData()+"=====平方得到结果是"+data.getData()*data.getData());
                    }
                }
                Thread.sleep(1000);

            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
