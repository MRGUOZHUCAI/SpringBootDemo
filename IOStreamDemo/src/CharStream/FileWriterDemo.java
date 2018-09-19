package CharStream;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;

/**
 * @author YCKJ0750
 * @date 2018/8/27 17:02
 */
public class FileWriterDemo {


    /**
     * 测试字符输入流
     */
    @Test
    public void test01()throws Exception{
        File file = new File("E:\\ioStreamTest\\charStreamTest.txt");
        FileWriter fileWriter = new FileWriter(file);
        String words = "你好，欢迎来到我的世界！";
        fileWriter.write(words);
        fileWriter.flush();
        fileWriter.close();
    }
}
