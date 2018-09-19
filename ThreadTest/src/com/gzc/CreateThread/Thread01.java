package com.gzc.CreateThread;

//创建线程方法一  继承Thread（无法实现多继承）
public class Thread01 extends Thread {
    private String name ;

    Thread01(){}

    Thread01(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0;i<10;i++){
            System.out.println(i+"====我是==="+this.name);
        }
    }

    public static  void main(String []args){
        //创建线程
        Thread myThread01 =new Thread01("myThread01");
        Thread myThread02 =new Thread01("myThread02");
        myThread01.start();
        myThread02.start();
        for (int j = 0;j<10;j++) {
            System.out.println(j+"====我是主线程");
        }


    }

}
