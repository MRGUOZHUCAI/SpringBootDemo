package CharStream;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author YCKJ0750
 * @date 2018/8/27 17:40
 */
public class CopyTest {

    @Test
    public void test()throws IOException {
        File file0  = new File("E:\\ioStreamTest\\charStreamTest.txt");
        File file1  = new File("E:\\ioStreamTest\\charStreamCopy.txt");

        FileWriter fileWriter =  new FileWriter(file1);
        FileReader fileReader = new FileReader(file0);

        int len = 0;
        char[] buf = new char[1024];

        while((len = fileReader.read(buf)) != -1){
            System.out.println(buf[0]);
            fileWriter.write(buf,0,len);
        }
        fileWriter.flush();
        fileWriter.close();
        fileReader.close();
    }
}
