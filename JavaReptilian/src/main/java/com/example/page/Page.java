package com.example.page;

import com.example.utils.CharsetDetector;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.vaadin.external.jsoup.Jsoup;
import com.vaadin.external.jsoup.nodes.Document;
import lombok.Data;

import java.io.UnsupportedEncodingException;

/**
 * @author YCKJ0750
 * @date 2018/9/11 10:16
 */
@Data
public class Page {

    //网页源码
    private String html;
    //字符集
    private String charSet;
    //url路径
    private String url;
    //内容类型
    private String contentType;
    //内容
    private byte[] content;
    //网页dom文档
    private Document document;

    public Page(String url, String contentType, byte[] content) {
        this.url = url;
        this.contentType = contentType;
        this.content = content;
    }

    public String getCharSet() {
        return charSet;
    }

    public String getUrl() {
        return url;
    }

    public String getContentType() {
        return contentType;
    }

    public byte[] getContent() {
        return content;
    }


    //返回网页的源码字符串
    public String getHtml() {
        if(html != null){
            return html;
        }
        if(content == null){
            return null;
        }
        if(charSet == null){
            charSet = CharsetDetector.guessEncoding(content);
        }
        try {
            this.html = new String (content,charSet);
            return html;
        }catch (UnsupportedEncodingException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Document getDocument() {
        if(document != null){
            return document;
        }
        try {
            this.document = Jsoup.parse(getHtml(),url);
            return document;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



}


