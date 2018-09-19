package DesignPattern;

/**
 * @author YCKJ0750
 * @date 2018/8/29 14:10
 */
public class SingleInstance {

    private static volatile SingleInstance singleInstance;

    private SingleInstance (){}

    public SingleInstance getInstance(){
        if(singleInstance==null){
            synchronized(SingleInstance.class){
                if(singleInstance==null){
                    singleInstance = new SingleInstance();
                }
            }
        }
        return singleInstance;
    }
}
