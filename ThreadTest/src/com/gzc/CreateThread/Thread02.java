package com.gzc.CreateThread;


//继承runable接口，可以多继承
public class Thread02 implements Runnable {
    private String  name;

    public Thread02(){

    }

    public Thread02(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0;i < 10;i++){
            System.out.println(i+"====我是===="+this.name);
        }
    }

    public static void main(String[] args) {
        Thread02 myThread01 = new Thread02("myThread01");
        Thread02 myThread02 = new Thread02("myThread02");

        Thread t1 = new Thread(myThread01);
        Thread t2 = new Thread(myThread02);

        t1.start();
        t2.start();

        for(int j = 0; j<10; j++){
            System.out.println(j+"====我是主线程");
        }
    }
}
