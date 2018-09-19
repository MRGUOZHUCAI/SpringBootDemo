package com.networkprogram.base;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author YCKJ0750
 * @date 2018/9/3 14:46
 * * 简单的Socket客户端
 *  * 功能为：发送字符串“Hello”到服务器端，并打印出服务器端的反馈
 */
public class SimpleSocketClient {
    public static void main(String[] args) throws Exception{
        Socket socket = null;
        InputStream is = null;
        OutputStream os = null;

        //服务器端IP地址
        String serverIp = "127.0.0.1";
        //服务端端口号
        int port = 10000;

        //发送内容
        String data = "hello world!";
        try {
            //建立连接
            socket = new Socket(serverIp,port);

            //发送数据
            os = socket.getOutputStream();
            os.write(data.getBytes());

            //接收数据
            is = socket.getInputStream();
            byte[] b  = new byte[1024];
            int len ;
            while((len = is.read(b))!=-1){
                System.out.println("服务器反馈内容为:"+new String(b,0,len));
            }
        }catch (Exception e ){
            e.printStackTrace();
        }finally {
            //关闭流和连接
            is.close();
            os.close();
            socket.close();
        }
    }


}
