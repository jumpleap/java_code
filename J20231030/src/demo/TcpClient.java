package demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    private Socket socket = null;

    public TcpClient(String serverIp, int serverPort) throws IOException {
        // 需要在创建 Socket 的同时, 和服务器 "建立连接", 此时就得告诉 Socket 服务器在哪里~~
        // 具体建立连接的细节, 不需要咱们代码手动干预. 是内核自动负责的.
        // 当我们 new 这个对象的时候, 操作系统内核, 就开始进行 三次握手 具体细节, 完成建立连接的过程了.
        socket = new Socket(serverIp, serverPort);
    }

    public void start() {
        // tcp 的客户端行为和 udp 的客户端差不多.
        // 都是:
        // 3. 从服务器读取响应.
        // 4. 把响应显示到界面上.
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            PrintWriter writer = new PrintWriter(outputStream);
            Scanner scannerNetwork = new Scanner(inputStream);
            while (true) {
                // 1. 从控制台读取用户输入的内容
                System.out.print("-> ");
                String request = scanner.next();
                // 2. 把字符串作为请求, 发送给服务器
                //    这里使用 println, 是为了让请求后面带上换行.
                //    也就是和服务器读取请求, scanner.next 呼应
                writer.println(request);
                writer.flush();
                // 3. 读取服务器返回的响应.
                String response = scannerNetwork.next();
                // 4. 在界面上显示内容了.
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpClient client = new TcpClient("127.0.0.1", 9090);
        client.start();
    }
}