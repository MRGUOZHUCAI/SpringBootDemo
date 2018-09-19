package DesignPattern;

/**
 * @author YCKJ0750
 * @date 2018/8/29 14:28
 */
public class SingleInstance01 {

    private static final SingleInstance01 instance= new SingleInstance01();

    private SingleInstance01(){}

    public static SingleInstance01 getInstance(){
            return instance;
    }
}
