package Serializable;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author YCKJ0750
 * @date 2018/8/28 10:40
 */
public class ObjectInputStreamDemo {

    /**
     * 对象反序列化测试
     */
    @Test
    public void test02()throws Exception {
        File file = new File("E:\\ioStreamTest\\user03.object");
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fileInputStream);
        User user = (User)ois.readObject();
        System.out.println(user.toString());
    }

}
