package com.networkprogram.base;

import java.net.InetAddress;

/**
 * @author YCKJ0750
 * @date 2018/9/3 13:53
 * 基础的网络类——InetAddress类。该类的功能是代表一个IP地址，
 * 并且将IP地址和域名相关的操作方法包含在该类的内部。
 */
    public class InetAddressDemo {

        public static void main(String[] args) {
            try {
                //使用域名创建对象
                InetAddress inet01 = InetAddress.getByName("www.baidu.com");
                System.out.println(inet01);

                //使用ip创建对象
                InetAddress inet02 = InetAddress.getByName("180.97.33.107");
                System.out.println(inet02);

                //获得本机地址对象
                InetAddress inet03 = InetAddress.getLocalHost();
                System.out.println(inet03);

                //获取对象中存储的域名
                String host = inet03.getHostName();
                System.out.println("本机域名为:"+host);

                //获取对象中的存储的IP
                String ip = inet03.getHostAddress();
                System.out.println("本机IP为:"+ip);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
