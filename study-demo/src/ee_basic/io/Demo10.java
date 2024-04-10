package ee_basic.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// OutputStream 写数据
public class Demo10 {
    public static void main(String[] args) {
        // 往test.txt中写数据
        try (OutputStream outputStream = new FileOutputStream("d:/test.txt", true)) {
            String s = "hello Spring";
            outputStream.write(s.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
