package net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket;

    // 客户端需要指定服务器的ip和端口号
    public TcpEchoClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public void start() {
        System.out.println("客户端启动!");

        // 用于获取控制台输入
        Scanner scanner = new Scanner(System.in);
        // inputStream用于获取服务器发来的响应, outputStream用于发送请求
        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {

            // 把服务器发来的二进制响应使用Scanner转化为字符流
            Scanner scan = new Scanner(inputStream);
            // 使用printWriter进行发送请求
            PrintWriter printWriter = new PrintWriter(outputStream);

            while (true) {
                // 1.构造请求
                System.out.print("-> ");
                String request = scanner.next();

                // 2.把请求发送给服务器
                printWriter.println(request);
                printWriter.flush();

                // 3.读取服务器返回的响应
                String response = scan.next();

                // 4. 打印此次交互的数据
                System.out.println(response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
