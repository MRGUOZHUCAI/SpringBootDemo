package ByteStream;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author YCKJ0750
 * @date 2018/8/27 16:21
 */
public class CopyTest {

    @Test
    public void CopyTest()throws IOException {
        //创建源文件文件
        File file0 = new File("E:\\ioStreamTest\\io01.txt");
        //创建目标文件
        File file1 = new File("E:\\ioStreamTest\\copy.txt");
        //创建输入输出对象
        FileInputStream fileInputStream = new FileInputStream(file0);
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        //创建缓冲
        byte[] buf  = new byte[1024];
        //记录成功读取字节数
        int len = 0;
        //读取文件
        while((len = fileInputStream.read(buf)) != -1){
        //写入文件
            fileOutputStream.write(buf,0,len);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
