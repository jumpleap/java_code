package ee_basic.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

// Tcp客户端代码
public class TcpEchoClient {
    // 用于和服务器进行连接的基础
    private Socket socket;

    // 需要给客户端指定 服务器的IP地址和端口号, 进行访问
    public TcpEchoClient(String ip, int port) throws IOException {
        // 需要在创建 Socket 的同时, 和服务器"建立连接", 此时就得告诉 Socket 服务器在哪里
        // 当我们 new 这个对象的时候, 操作系统内核就已经帮我们完成三次握手了, 即完成了建立连接的过程了
        socket = new Socket(ip, port);
    }

    // 用这个方法来启动客户端
    public void start() {
        System.out.println("客户端启动!");
        // 用于读取控制台的内容作为请求
        Scanner scanner = new Scanner(System.in);

        try (InputStream inputStream = socket.getInputStream();
             OutputStream outputStream = socket.getOutputStream()) {
            // 用来把字符串转为字节数组的数据, 发送给服务器
            PrintWriter printWriter = new PrintWriter(outputStream);
            // 用于读取服务器发来的数据, 我们可以使用这个来获取字符串
            Scanner scannerNext = new Scanner(inputStream);

            while (true) {
                // 1.从控制台读取数据作为请求
                System.out.print("-> ");
                String request = scanner.next();

                // 2.发送请求给服务器
                printWriter.println(request);
                // 刷新缓冲区
                printWriter.flush();

                // 3.读取服务器返回的响应
                String response = scannerNext.next();

                // 4.显示响应内容
                System.out.println(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
