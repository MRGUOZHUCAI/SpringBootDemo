package ByteStream;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author YCKJ0750
 * @date 2018/8/27 15:12
 */
public class FileOutPutStream {

    public static void main(String[] args){

    }


    //创建文件对象和字节输出流对象并写入文件
    @Test
    public void test01()throws Exception{
        //创建一个文件
        File file = new File("E:\\ioStreamTest\\io01.txt");
        //创建输出流对象
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //输出内容
        byte[] words = "abcdefg".getBytes();
        //向目标文件输出内容
        fileOutputStream.write(words);
        fileOutputStream.write(words,0,3);
        //关闭流对象
        fileOutputStream.close();
    }

    /**
     * 换行和续写测试
     */
    @Test
    public void test02(){
        File file = new File("E:\\ioStreamTest\\io01.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file,true);
            String words = "\r\n"+"hello ,my name is gzc.";
            fileOutputStream.write(words.getBytes());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
