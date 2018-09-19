package CharStream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author YCKJ0750
 * @date 2018/8/27 17:12
 */
public class FileReaderDemo {

    @Test
    public void test01()throws IOException {
        FileReader fileReader = new FileReader(new File("E:\\ioStreamTest\\charStreamTest.txt"));
        char[] buf = new char[1024];
        int len = 0 ;
        while ((len=fileReader.read(buf)) != -1){
            System.out.println("这次读取字符==="+len);
            System.out.println(new String(buf,0,len));
        }

    }
}
