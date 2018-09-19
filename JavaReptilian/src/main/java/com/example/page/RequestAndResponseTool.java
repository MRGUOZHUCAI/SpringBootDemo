package com.example.page;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.IOException;

/**
 * @author YCKJ0750
 * @date 2018/9/11 11:42
 */
public class RequestAndResponseTool {

    public static Page sendRequestAndGetReponse(String url) {
        Page page = null;
        //1.生成HttpClient 对象并设置参数
        HttpClient httpClient = new HttpClient();
        //设置http连接超时 5 s
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
        //2.生成GetMethod 对象并设置参数
        GetMethod getMethod = new GetMethod(url);
        //设置get请求超时5s
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000);
        //设置请求重试处理
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //3.执行Http Get 请求
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            //判断访问的状态码
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed:" + getMethod.getStatusLine());
            }
            //4.处理Http响应内容
            byte[] responseBody = getMethod.getResponseBody();  //读取为字节 数组
            String contentType = getMethod.getResponseHeader("Content-Type").getValue();

            page = new Page( url,contentType,responseBody); //封装为页面
        } catch (HttpException e) {
            //发生致命的异常，可能是协议不对
            System.out.println("Please check your provided http address!");
            e.printStackTrace();
        } catch (IOException e) {
            //发生网络异常
            e.printStackTrace();
        } finally {
            //释放连接
            getMethod.releaseConnection();
        }
            return page;
    }
 }

