package Serializable;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author YCKJ0750
 * @date 2018/8/28 10:20
 */
public class ObjectOutPutStreamDemo {

    /**
     * 对象序列化测试
     */
    @Test
    public void test01()throws IOException {
       // User user = new User("001","gzc",24,"JAVA Developer");
        User user = new User("001",24,"JAVA Developer");
        File file = new File("E:\\ioStreamTest\\user03.object");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fileOutputStream);
        oos.writeObject(user);
        oos.close();
    }


}
