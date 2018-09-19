package com.example.link;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author YCKJ0750
 * @date 2018/9/11 14:35
 */
public class Links {
    //已访问的 url 集合  已经访问过的 主要考虑 不能再重复了 使用set来保证不重复;
    private static Set visitedUrlSet = new HashSet();

    //待访问的url集合  待访问的主要考虑 1:规定访问顺序;2:保证不提供重复的带访问地址;
    private static LinkedList unVisitedUrlQueue = new LinkedList();

    //获得已经访问的url项目
    public static int getVisitedUrlNum(){
        return visitedUrlSet.size();
    }

    //添加访问过的url
    public static void addVisitedUrlSet(String url){
        visitedUrlSet.add(url);
    }

    //移除访问过的url
    public static void removeVisitedUrlSet(String url){
        visitedUrlSet.remove(url);
    }

    //获取待访问的url集合
    public static LinkedList getUnVisitedUrlQueue(){
        return unVisitedUrlQueue;
    }

    //添加到待访问的集合中 保证每个URL只被访问一次
    public static void addUnvisitedUrlQueue(String url){
        if(url != null && !url.trim().equals("") && !visitedUrlSet.contains(url) && !unVisitedUrlQueue.contains(url)){
            unVisitedUrlQueue.add(url);
        }
    }

    //删除待访问的url
    public static Object removeHeadOfUnvisitedUrlQueue(){
         return unVisitedUrlQueue.removeFirst();
    }

    //判断未访问的URL队列中是否为空
    public static boolean unVisitedUrlQueueIsEmpty(){
        return unVisitedUrlQueue.isEmpty();
    }

}
