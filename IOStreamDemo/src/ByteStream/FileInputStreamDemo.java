package ByteStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * @author YCKJ0750
 * @date 2018/8/27 15:47
 */
public class FileInputStreamDemo {

    /**
     * 创建字节输入流读取文件
     */
    @Test
    public void test01(){
        File file = new File("E:\\ioStreamTest\\io01.txt");
        FileInputStream fileInputStream = null;
        try {
            //创建字节输入流对象
            fileInputStream = new FileInputStream(file);
            //读取文件
            int ch = 0;
            StringBuilder words = new StringBuilder();
            while((ch = fileInputStream.read())!=-1){
                words.append((char) ch);
            }
            System.out.println(words);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 创建缓冲输入流
     */
    @Test
    public void test02()throws IOException{
        File file = new File("E:\\ioStreamTest\\io01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] buf = new byte[1024];
        StringBuffer words = new StringBuffer();
        //读取内容的长度
        int len = 0;
        while ((len = fileInputStream.read(buf))!=-1){
            System.out.println("长度====="+len);
            words.append(new String(buf,0,len));
        }
        System.out.println(words);
        fileInputStream.close();
    }

}
